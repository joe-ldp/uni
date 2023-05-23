#include <iostream>
#include <string>
#include <time.h>

using namespace std;

void outputCharArray(char arr[], int size);
int searchForChar(const char *arr, int size, char find);
void reveal(char revealArr[], int size, int revealIndex, const char *originalArr);
int findAndReplace(char *arr, int size, char find, char replace);
void populateArray(char *arr, int size, char pop);
char getGuess();

int main()
{
	// Randomise the seed
	srand((int)time(NULL));

	// Declare array of words to pick a word to guess from
	const int maxWordLength(12);
	const char guessableWords[][maxWordLength] =
	{
		"Average",
		"Male",
		"Hurry",
		"Ugly",
		"Spiritual",
		"Seed",
		"Whirl",
		"Books",
		"Hope",
		"Hospitable",
		"Nasty",
		"Forgetful"
	};

	// Set a difficulty (number of lives)
	const int ATTEMPTS_ALLOWED = 20;
	int lives = ATTEMPTS_ALLOWED;

	// Declare an array used to store the word to guess, and pick a word from the array above
	const char *toGuess = guessableWords[(rand() % 12) + 1];
	for (int i = 0; i < maxWordLength; i++)
	{
		cout << toGuess[i];
	}
	cout << "\n";

	// Find the length of the word we're trying to guess (used for the 'reveal array' below)
	int len(0);
	for (int i = 0; i < maxWordLength; i++)
	{
		if ((int)toGuess[i] != 0) len++;
	}
	const int guessLen = len;
	cout << guessLen << "\n";

	// Declare a 'reveal array' used to reveal each character of the word as the user guesses them...
	// ... and populate it with underscores, as unrevealed characters
	char revealArr[maxWordLength];
	populateArray(revealArr, maxWordLength, '_');

	// A couple of boolean variables to control game logic
	bool guessed = false;
	bool play = true;

	// Main game loop
	while (play)
	{
		// Tell the user some stuff...
		cout << lives << " lives remaining.\n";

		// Get their guess character
		char guess = getGuess();

		// Check if their guess was correct at all; assign the number of matching characters to an integer value
		int matchedChars = searchForChar(toGuess, guessLen, guess);
		cout << matchedChars << "\n"; // Debug

		// If the number of matching values is not 0...
		if (matchedChars)
		{
			//cout << "potato match\n";
			for (int i = 0; i < matchedChars; i++)
			{
				//cout << "potato match number" << i << "\n";
				//reveal(revealArr, guessLen, i, toGuess);
				revealArr[i] = toGuess[i];
			}
		}
		// Else...
		else
		{
			lives--;
		}

		// Output the 'reveal array'
		outputCharArray(revealArr, guessLen);

		// they ded lmao
		if (lives == 0)
		{
			cout << "You died lol\n\n";
			// End the game by setting the while loop's variable to false
			play = false;
		}
	}

	// Exit stuff
	std::cout << "\n";
	std::system("pause");
	return 0;
}

void outputCharArray(char arr[], int size)
{
	for (int i = 0; i < size + 1; i++)
	{
		cout << arr[i];
	}
	cout << "\n";
}

int searchForChar(const char *arr, int size, char find)
{
	int matchedChars(0);
	for (int i = 0; i < size; i++)
	{
		cout << arr[i] << "  " << find << "\n";
		//cout << (int)arr[i] << "  " << (int)find << "\n";
		//cout << (int)arr[i] << "\n";
		if (arr[i] == find)
		{
			cout << "potato\n";
			matchedChars++;
		}
	}

	return matchedChars;
}

void reveal(char revealArr[], int size, int revealIndex, const char *originalArr)
{
	for (int i = 0; i < size + 1; i++)
	{
		if (i == revealIndex)
		{
			revealArr[i] = originalArr[i];
		}
	}
}

int findAndReplace(char *arr, int size, char find, char replace)
{
	int changes(0); // number of characters found and replaced

	for (int i = 0; i < size + 1; i++)
	{
		if (arr[i] == find)
		{
			arr[i] = replace;
			changes++;
		}
	}

	return changes;
}

void populateArray(char *arr, int size, char pop)
{
	for (int i = 0; i < size + 1; i++)
	{
		arr[i] = pop;
	}
}

char getGuess()
{
	char guess;
	cout << "Guess a character: ";
	cin >> guess;
	cout << "\n";

	return guess;
}