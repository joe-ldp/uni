#include <assert.h>
#include <conio.h>
#include <iostream>
#include <time.h>

using namespace std;

// Function prototypes
void playHangmanGame();
int chooseWord(char word[], const int maxwordlength);
void displayHangman(const int incorrects);
void displayWord(const char text[]);
void displayUnusedCharacters(const bool guessedchars[]);
char getValidInput(bool guessedchars[]);
void initArray(char data[], const int length, const char value);
void initArray(bool data[], const int length, const bool value);
bool updateUserGuess(const char word[], char userguess[], const int wordlength, const char guess, int& remaining);

int main()
{
	// seed the random number generator
	srand((int)time(NULL));

	// play a game of hangman
	playHangmanGame();

	system("pause");
	return 0;
}

void playHangmanGame()
{
	const int MAX_GUESSES = 6;
	const int MAX_CHARACTERS = 20;
	bool guessedchars[26];  // array used to determine whether the user has already guessed that character
	char word[MAX_CHARACTERS], userguess[MAX_CHARACTERS]; // word will store the word to guess and userguess is the guess state

	// Get the word to guess
	const int wordlength = chooseWord(word, MAX_CHARACTERS);

	// set up the guessedcharacter array to be all false (not been guessed yet)
	initArray(userguess, wordlength, '-');

	// set up the userguess with "blanks" based on the length of the word to guess
	initArray(guessedchars, 26, false);

	cout << "Welcome to Hangman\n";
	cout << "You have " << MAX_GUESSES << " incorrect guess attempts to correctly determine the hidden word\n";
	cout << "Press any key to start...";
	// Look this function up using the MSDN documentation (put the cursor into the function - _getch - and press F1
	char input = _getch();
	
	// Start the main game loop
	int remaining = wordlength;
	int incorrects = 0;
	do
	{
		// Display the hangman image
		displayHangman(incorrects);

		// Display the state of the user word (including blanks and correctly guessed characters)
		cout << "Word: ";
		displayWord(userguess);

		// display the list of letters that the user can still choose from
		cout << "\n\n";
		cout << "Unguessed Letters: ";
		displayUnusedCharacters(guessedchars);

		// display the number of guesses remaining
		cout << "\n\n";
		cout << "Remaining guesses: " << (MAX_GUESSES - incorrects);

		// get valid character from the user
		cout << "\n\nPress a key to guess ";
		input = getValidInput(guessedchars);

		// update the word based on the user guess - if no changes happened then add one to the number of incorrect guesses
		if (!updateUserGuess(word, userguess, wordlength, input, remaining))
			++incorrects;

		cout << "\n\n";
	} while (remaining > 0 && incorrects < MAX_GUESSES);  // loop while there are remaining letters to guess and incorrect guesses haven't exceeded the maximum

	displayHangman(incorrects);

	if (remaining == 0)
		cout << "Well done... you correctly guessed the word, which was ";
	else
		cout << "Bad luck, you didn't get the word, which was ";

	displayWord(word);
	cout << "\n\n";
}

// this method updates the userguess against the character entered
// if the character is in the word, true is returned, else false is
bool updateUserGuess(const char word[], char userguess[], const int wordlength, const char guess, int& remaining)
{
	bool found = false;
	remaining = 0;
	for (int i = 0; i < wordlength; i++)
	{
		if (word[i] == guess)
		{
			userguess[i] = guess;
			found = true;
		}
		else if (userguess[i] == '-')
			++remaining;
	}
	return found;
}

// initalise the array with the specified value
void initArray(char data[], const int length, const char value)
{
	for (int i = 0; i < length; i++)
		data[i] = value;
	data[length] = '\0';  // add null-terminating character
}

// initalise the array with the specified value
void initArray(bool data[], const int length, const bool value)
{
	for (int i = 0; i < length; i++)
		data[i] = value;
}

// This function relys on the null-terminating character at the end of the valid portion of the text array
void displayWord(const char text[])
{
	int index = 0;
	while (text[index] != '\0')
	{
		cout << " " << text[index];
		++index;
	}
}

// Displays a list of letters still available for the user to choose from
void displayUnusedCharacters(const bool guessedchars[])
{
	for (int i = 0; i < 26; i++)
	{
		if (guessedchars[i])
			cout << "  ";
		else
			cout << " " << (char)('A' + i);
	}
}

// get a valid character from the user and check it hasn't been used before and if so ask for another
char getValidInput(bool guessedchars[])
{
	char input;
	bool valid = false;
	do
	{
		input = _getch();

		// if the character entered is a lower case value, convert it to upper case
		if (input >= 'a' && input <= 'z')
			input = input - 32;

		if (input >= 'A' && input <= 'Z')
		{
			int index = input - 'A';  // remember, ASCII values are just numbers so 'A'-'A' is 0, 'B'-'A' is 1, etc...
			if (guessedchars[index])  // check it hasn't already been tr
				cout << "\nThat character has already been guessed (are you trying to swing?).  Please try again ";
			else
			{
				guessedchars[index] = true;
				valid = true;
			}
		}
		else // the character entered is invalid (e.g. #, 1, 6, etc)
			cout << "\nInvalid input, please try again ";

	} while (!valid);

	return input;
}

// randomly chooses a word from a collection, copies to the word array and returns the length of the word
int chooseWord(char word[], const int maxwordlength)
{
	// Here is my really imaginative dictionary of hangman words
	const int NO_OF_WORDS = 3;
	const string words[NO_OF_WORDS] = { "HELLO", "WORLD", "BYE" };

	int selectedword = rand() % NO_OF_WORDS;
	int wordlength = words[selectedword].length();

	// make sure that the caller has passed an array that is big enough
	assert(wordlength < maxwordlength);

	// copy the data across to the array
	for (int i = 0; i < wordlength; i++)
		word[i] = words[selectedword].at(i);

	// append the word with the null-terminating character
	word[wordlength] = '\0';

	return wordlength;
}


// Displays the hangman image
void displayHangman(const int incorrects)
{
	// This method is only valid if the caller passes a number between 0...6 inclusive
	// so make sure they do, else complain about it via the assert
	assert(incorrects >= 0 && incorrects <= 6);

	// clears the screen
	system("cls");

	// depending on how many incorrect guesses the user has made, display the corresponding hangman image
	switch (incorrects)
	{
		case 6:
			cout << " ----------\n";
			cout << " | /      |\n";
			cout << " |/       _\n";
			cout << " |       [~]\n";
			cout << " |        -\n";
			cout << " |      / | \\\n";
			cout << " |     /  |  \\\n";
			cout << " |       / \\\n";
			cout << " |      /   \\\n";
			cout << " |     /     \\\n";
			cout << " |\n";
			cout << " -----------------\n";
			break;
		case 5:
			cout << " -----------\n";
			cout << " | /      |\n";
			cout << " |/       _\n";
			cout << " |       [^]\n";
			cout << " |        -\n";
			cout << " |      / | \\\n";
			cout << " |     /  |  \\\n";
			cout << " |       / \\\n";
			cout << " |      /   \\\n";
			cout << " |     /     \\\n";
			cout << " |  |-----------|\n";
			cout << " -----------------\n";
			break;
		case 4:
			cout << " -----------\n";
			cout << " | /      |\n";
			cout << " |/\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " -----------------\n";
			break;
		case 3:
			cout << " -----------\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " -----------------\n";
			break;
		case 2:
			cout << " \n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " |\n";
			cout << " -----------------\n";
			break;
		case 1:
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " -----------------\n";
			break;
		case 0:
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
			cout << " \n";
	}
}