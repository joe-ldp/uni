#include "DrawingTool.h"

#pragma region EasyGraphics Functions

DrawingTool::DrawingTool()
{
	// Initialise
	setImmediateDrawMode(true);
	srand((int)time(NULL));

	//showPathCheat = true; // For Debug
}

DrawingTool::~DrawingTool()
{
	
}

void DrawingTool::onKeyDown(UINT nChar, UINT nRepCnt, UINT nFlags)
{
	if (level == 0) advanceLevel(); // To start the game
	
	currentDirection = nChar; // Whenever the user clicks, store their input
	if (canMove) // If the game is live and the user is moving,
	{
		setTimer(1, 0); // Call the timer to move the player
	}

	switch (nChar) // Check the value of nChar for special cases
	{
		case 'C': // Toggle cheat mode
			showPathCheat = !showPathCheat;
			break;

		case 'L': // Skip the level
			advanceLevel();
			break;
	}

	onDraw(); // Call onDraw() to ensure any graphic changes are pushed to the screen
}

void DrawingTool::onKeyUp(UINT nChar, UINT nRepCnt, UINT nFlags)
{
	canMove = true;
	if (canMove && (nChar == VK_LEFT || nChar == VK_RIGHT || nChar == VK_UP || nChar == VK_DOWN))
	{
		canMove = false;
		setTimer(1, 800); // Set a timer for how long until the player moves in the game
	}
}

void DrawingTool::onTimer(UINT id)
{
	if (id == 1) // Select timer ID#1
	{
		movePlayer(-1); // Call the move player function and pass -1 to use the currentDirection
		onDraw(); // Update the screen
		setTimer(1, 800); // Restart the timer to keep the player on the mov
	}
}

void DrawingTool::onDraw()
{
	clearScreen(DARK_GREEN); // BG
	setBackColour(GREY); // Pen setting
	setPenColour(BLACK, 3); // Pen setting

	// Draw some graphics to the screen (depending on what stage of the game we're in)
	drawSquares();
	drawCharacters();
	writeText();
}

#pragma endregion


#pragma region Game Logic Functions

void DrawingTool::advanceLevel()
{
	showPlayer = false; // Always start a level with the player invisible and unable to move
	canMove = false;
	killTimer(1); // Stop the player from moving automatically too
	currentDirection = 0; // Reset the direction
	for (int i = 0; i < 6; i++) // Reset the visited squares
	{
		for (int j = 0; j < 6; j++)
		{
			visitedCells[i][j] = false;
		}
	}

	level++; // Add one to the level number (we start at 0 at the beginning of the game, so like this the first time the function is called the level becomes 1)

	// Set grid sizes based on level, and set square pixel sizes based on grid size (i.e. how many can fit)
	if (level <= 4)
	{
		gridSize = 4;
		squareSize = 120;
	}
	else if (level <= 9)
	{
		gridSize = 5;
		squareSize = 95;
	}
	else
	{
		gridSize = 6;
		squareSize = 78;
	}

	generatePath(); // Generate a path for the user to traverse

	NPCGoPath(); // Demonstrate the path

	playerPos = path.at(0); // Set their position to the start of the path...
	showPlayer = true; // Show where they are
	canMove = true; // And let them start moving
}

void DrawingTool::generatePath()
{
	path.clear(); // Clear the path vector
	std::pair<int, int> newSquare((rand() % gridSize) + 1, (rand() % gridSize) + 1), lastSquare = newSquare, lastLastSquare;

	int dir, steps = 0, tries = 0;
	while (steps != level + 3)
	{
		dir = rand() % 4; // Random direction picker
		switch (dir)
		{
			case 0:
				newSquare.first++;
				break;
			case 1:
				newSquare.second++;
				break;
			case 2:
				newSquare.first--;
				break;
			case 3:
				newSquare.second--;
				break;
		}

		if (   newSquare.first >= 0 && newSquare.first < gridSize      // within x boundaries
			&& newSquare.second >= 0 && newSquare.second < gridSize    // within y boundaries
			&& newSquare != lastSquare && newSquare != lastLastSquare) // not backtracking (lastSquare is used for immediate, LLS is used to discourage grouping around one point)
		{
			steps++; // Increment the tracked number of steps
			path.push_back(newSquare); // Add this step to the path
			lastLastSquare = lastSquare; // Track the last last square
			lastSquare = newSquare; // Track the last square
		}
		else
		{
			newSquare = lastSquare; // Try again...
			tries++; // And keep track of how many times we try in case we get stuck
		}

		if (tries > 15) // In case of getting stuck, start the whole function again:
		{
			generatePath();
		}
	}
}

void DrawingTool::NPCGoPath()
{
	//showPathCheat = true; // Debug
	showNPC = true; // Show the NPC

	std::pair <int, int> coord;
	for (int i = 0; i < path.size(); i++) // Traverse the path square by square
	{
		coord = path.at(i); // Get the square's index
		npcPos = gridPoints[coord.first][coord.second]; // Set the NPC's position
		onDraw(); // Update graphics
		Sleep(800); // Wait a bit
	}

	showNPC = false; // Hide the NPC again
	//showPathCheat = false; // Debug

	onDraw(); // Update graphics
}

void DrawingTool::movePlayer(UINT nChar)
{
	if (nChar == -1) nChar = currentDirection; // Get the direction from the last time the player inputted a change in dir
	else currentDirection = nChar; // Or set a given new one

	std::pair<int, int> newPos = playerPos; // Dummy variable

	switch (nChar)
	{
		// Adjust the position according to the arrow key pressed
		case VK_LEFT:
			newPos.second--;
			break;
		case VK_RIGHT:
			newPos.second++;
			break;
		case VK_UP:
			newPos.first--;
			break;
		case VK_DOWN:
			newPos.first++;
			break;
	}

	if (std::count(path.begin(), path.end(), newPos)) // No need for grid boundary checks as if it's in the path it's a legal position and if not, it's not
	{
		if (newPos != path.back()) // If we haven't reached the end (tested this way round as only 1 move reaches the end but many don't, even when legal
		{
			playerPos = newPos; // Update the player's position
			visitedCells[playerPos.first][playerPos.second] = true;
		}
		else // We've reached the last square of the path
		{
			// WEINER
			advanceLevel();
		}
	}
	else // Illegal move, game over
	{
		canMove = false;
		showPlayer = false;
		gameOver = true;
	}

	//playerPos = newPos; // Debug
}

#pragma endregion


#pragma region Drawing Functions

void DrawingTool::drawSquares()
{
	int xIndent = 90, yIndent = 90, x = xIndent, y = yIndent;
	int count = 0;
	for (int xs = 0; xs < gridSize; xs++) // Iterate through the right amount of squares on the x and y axis
	{
		for (int ys = 0; ys < gridSize; ys++)
		{
			if (visitedCells[xs][ys]) setBackColour(CYAN); // Colour visited squares specially
			else setBackColour(GREY);

			drawRectangle(x, y, squareSize, squareSize, true);

			// If cheat mode activated
			if (showPathCheat)
			{
				std::pair<int, int> coord;
				for (int i = 0; i < path.size(); i++)
				{
					coord = path.at(i);
					if (std::pair<int, int>(xs, ys) == coord)
					{
						setBackColour(RED);
						drawRectangle(x, y, squareSize, squareSize, true);
						drawText(std::to_string(i).c_str(), x, y);
						break;
					}
				}
			}

			gridPoints[xs][ys].first = x + (squareSize / 2); // Find the middles of every square alongn the way for graphical purposes
			gridPoints[xs][ys].second = y + (squareSize / 2);

			x += squareSize + 5; // Add a gap
		}
		x = xIndent;
		y += squareSize + 5; // Add a gap
	}
}

void DrawingTool::drawCharacters()
{
	if (showNPC)
	{
		setBackColour(BLUE);
		drawTriangle(npcPos.first - 30, npcPos.second - 15, npcPos.first, npcPos.second + 30, npcPos.first + 30, npcPos.second - 15, true);
	}
	if (showPlayer)
	{
		setBackColour(BLUE);
		drawCircle(gridPoints[playerPos.first][playerPos.second].first, gridPoints[playerPos.first][playerPos.second].second, 30, true);
	}
}

void DrawingTool::writeText()
{
	setTextColour(BLACK);
	setFont(20, L"Tahoma");
	drawText(("Level: " + std::to_string(level)).c_str(), 100, 30);

	if (level == 0)
	{
		drawText("Try to follow me...", 300, 30);
		drawText("Press any key to start", 190, 605);
	}
	if (level == 100)
	{
		drawText("Congrats, you beat the game! Level 100!", 300, 30);
	}
	if (gameOver)
	{
		drawText(("Game over. Score: " + std::to_string(level - 1)).c_str(), 300, 30);
	}
}

#pragma endregion