#include "Breakout.h"

Breakout::Breakout()
{
	// Initialise
	setImmediateDrawMode(false);
	srand((int)time(NULL));
}

Breakout::~Breakout()
{
	
}

void Breakout::onCreate()
{
	EasyGraphics::onCreate();
	startGame();

	::SetWindowText(getHWND(), L"OOP4CS: Breakout");
}

void Breakout::startGame()
{
	if (gameStarted) return;

	gameStarted = true;

	paddle = paddle->getInstance();
	ball = ball->getInstance();

	setTimer(1, 0);
	setTimer(2, 400);
}

void Breakout::onMouseMove(UINT nFlags, int x, int y)
{
	//startGame();

	paddle->updatePos(x, windowWidth);
	paddle->draw(this);

	EasyGraphics::onDraw();
}

void Breakout::onKeyDown(UINT nChar, UINT nRepCnt, UINT nFlags)
{
	//generateLevel();
}

void Breakout::onTimer(UINT id)
{
	if (id == 1) // Select timer ID#1
	{
		ball->move();

		if (hitTest(ball->getHitBox(), paddle->getHitBox()))
		{
			ball->bounce(2);
		}

		RECT ballHB = ball->getHitBox();
		if (ballHB.right >= windowWidth) ball->bounce(1);
		if (ballHB.left <= 0) ball->bounce(3);
		//if (ballHB.bottom >= windowHeight) ball->bounce(2);
		if (ballHB.top <= 0) ball->bounce(4);

		for (vector<Block*>* row : blocks)
		{
			for (Block* block : *row)
			{
				if (block->destroyed()) continue;

				int hitDir = hitTest(ball->getHitBox(), block->getHitBox());
				if (hitDir)
				{
					ball->bounce(hitDir);
					block->hit();
				}
			}
		}

		onDraw(); // Update the screen
		setTimer(1, 33); // Restart the timer to keep the ball on the move
	}
	if (id == 2)
	{
		generateLevel();
		killTimer(2);
	}
}

void Breakout::onDraw()
{
	clearScreen(BLACK); // Reset screen

	ball->draw(this);
	paddle->draw(this);

	for (vector<Block*>* row : blocks)
	{
		for (Block* block : *row)
		{
			if (block->destroyed()) continue;

			block->draw(this);
		}
	}

	EasyGraphics::onDraw();
}

void Breakout::generateLevel()
{
	Block::initialiseBlocks(blocks, windowWidth, windowHeight);
}

void Breakout::onSize(UINT nType, int cx, int cy)
{
	EasyGraphics::onSize(nType, cx, cy);

	windowWidth = cx;
	windowHeight = cy;
}