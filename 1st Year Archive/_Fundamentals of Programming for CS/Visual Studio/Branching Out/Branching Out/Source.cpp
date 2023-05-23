#include <iostream>
#include <iomanip>
#include <time.h>
#include <string>

using namespace std;

#pragma region Question 1

void randomNumber()
{
	srand((int)time(NULL));

	int value = rand() % 5;
	//cout << value << "\n";

	int number;
	cout << "Give me a number: ";
	cin >> number;

	if (number == value)
	{
		cout << "Nice guess. That was the random number I generated";
	}
	else
	{
		cout << "Nope, that wasn't the one that I randomly generated";
	}

	cout << "\n\n";
}

void getValidInput()
{
	const string TO_MATCH = "Yes";

	string input;
	int retries = 0;

	cout << "Please type '" << TO_MATCH << "' here (case sensitive): ";
	do
	{
		cin >> input;
		if (input != TO_MATCH)
		{
			cout << "Nope, try again: ";
			++retries;
		}
	} while (input != TO_MATCH);

	if (retries == 0)
	{
		cout << "\nFirst time";
	}
	/// vvv
	else if (retries == 1)
	{
		cout << "\nSecond time, works a charm";
	}
	/// ^^^
	else if (retries < 3)
	{
		cout << "\nNot bad, but that only took " << retries << " retries";
	}
	else
	{
		cout << "\nSeriously..." << (retries + 1) << " times to write " << TO_MATCH << " what are you thinking?";
	}

	cout << "\n\n";
}

void sumOfNumbers()
{
	int sum(0);
	int numLoops(10);

	for (int i = 0; i < numLoops; i++)
	{
		int input;

		cout << "Please provide number " << (i + 1) << " to sum: ";
		cin >> input;

		sum += input;
	}

	cout << "The sum of those numbers is " << sum << " with an average of " << (sum / (float)numLoops) << "... tada...";

	cout << "\n\n";
}

#pragma endregion

#pragma region Question 3

int guess(int toGuess, int numGuesses);
void guessingGame()
{
	srand((int)time(NULL)); // Re-randomise the random seed

	int toGuess = (rand() % 10) + 1; // Generate a number for the user to guess
	cout << "toGuess " << toGuess << "\n"; // Debug

	cout << "I have a number between 1 and 10. Can you guess it?\n\n"; // Talk to the user

	//int numGuesses(0);
	int numGuesses = guess(toGuess, 0); // Call guess() to start recursive guessing process

	cout << "It took you " << numGuesses << " tries to guess the number\n\n";
}

int guess(int toGuess, int numGuesses)
{
	cout << "numGuesses " << numGuesses << "\n";

	int userGuess; // Variable to hold user's guess

	cout << "Guess #" << (numGuesses + 1) << ": "; // Tell the user to guess
	cin >> userGuess; // Take their input
	numGuesses++; // Increment numGuesses to keep track (could be done anywhere in the func but it's nice to do it here)

	if (userGuess == toGuess) // If they guessed right...
	{
		return numGuesses; // Go back to main function and return number of tries taken
		//return 100;
	}
	else if (userGuess < toGuess) // If they guessed low...
	{
		cout << "Sorry, that isn't it. Try going higher...\n\n"; // Yep
		return guess(toGuess, numGuesses); // Call guess() to make the user guess again
	}
	else // No logic needed; no other possibilities (well, the user could be guessing out of the range but that's their problem)
	{
		cout << "Sorry, that isn't it. Try going lower...\n\n"; // Yep
		return guess(toGuess, numGuesses); // Call guess() to make the user guess again
	}

	//cout << "potato\n";
	//return false;//remove this entirely (placeholder to stop err)
	//return 0;

	// Reason it was working without returns on recursive calls:
	// Return value on "return numGuesses;" gets placed into EAX register
	// No other code is run whilst going back up recursion ladder therefore EAX register value is left unchanged
	// When we eventually get back to "int numGuesses = guess(toGuess, 0);" the value is still there and it pulls it out
	// If "cout << "potato\n";" is left uncommented, this modifies the EAX register value and numGuesses gets set to 262650848
	// This is obviously VERY BAD. Not even bad practise, just wrong. MUST USE RETURNS WHEN CLIMBING BACK UP RECURSION.
}

#pragma endregion

#pragma region Question 4

void mathsGame()
{
	// Initialise variables, all numbers can be integers since we are generating and adding whole numbers
	int number1(0);
	int number2(0);
	int ans(0);

	int rightAnswers(0);
	int wrongAnswers(0);

	int userInput(0);
	const int NUM_QUESTIONS(5); // Constant for number of questions to ask the user

	for (int q = 1; q <= NUM_QUESTIONS; q++) // For loop using the variable "q" starting at 1 so we can use it to refer to the current question number
	{
		srand((int)time(NULL)); // Re-randomise the seed for new numbers
		number1 = (rand() % 10) + 1; // Randomise number 1
		number2 = (rand() % 10) + 1; // Randomise number 2

		if ((rand() % 2) == 1) // Choose whether to make it an addition problem...
		{
			ans = number1 + number2;
			cout << "Question " << q << ": " << number1 << " + " << number2 << " = ";
		}
		else // ...or a substraction problem
		{
			ans = number1 - number2;
			cout << "Question " << q << ": " << number1 << " - " << number2 << " = ";
		}
		//cout << "ans " << ans << "\n"; // Debug

		cin >> userInput; // Take the user's answer in
		//cout << "userInput" << userInput << "\n"; // Debug

		if (userInput == ans) // If it is correct:
		{
			rightAnswers++; // Increment right answers (so we can keep track of their score)
			cout << "  Correct\n"; // Tell them
		}
		else
		{
			wrongAnswers++; // Increment wrong answers (so we can keep track of their score)
			cout << "  Wrong - the answer is " << ans << ".\n"; // Scold them
		}
	}

	// Now the set of questions (for loop) is over (has terminated), we can give the user their dismal results because they suck
	if (rightAnswers == NUM_QUESTIONS) // Well for this one they don't suck - very impressive (full marks as number of right answers is equal to number of questions)
	{
		cout << "Well done, you got all of them right. " << NUM_QUESTIONS << " out of " << NUM_QUESTIONS << "!\n\n"; // rightAnswers could be used instead of NUM_QUESTIONS but should not be necessary
	}
	else // This one not so great, but not necessarily awful (no code distinguishing between a score of 1 or 4, might be nice to add this)
	{
		cout << "You got " << rightAnswers << " out of " << NUM_QUESTIONS << ".\n\n";
	}
}

#pragma endregion

#pragma region Question 5

void mastermind()
{
	cout << "Mastermind... come test your logical deduction skills...\n";
	cout << "I am thinking of a 4 digit number, you have 10 attempts to guess it\n";

	/*int toGuess[4];
	for (int i = 0; i < 4; i++)
	{
		srand((int)time(NULL));
		toGuess[i] = (rand() % 9) + 1;
		cout << toGuess[i];
	}*/
	srand((int)time(NULL));
	int toGuess = (rand() % 9999) + 1;
	cout << toGuess << "\n";

	const int ATTEMPTS_ALLOWED(10);
	for (int attempt = 1; attempt <= ATTEMPTS_ALLOWED; attempt++)
	{
		cout << "Attempt " << attempt << ": ";

		int userGuess;
		cin >> userGuess;

		while (userGuess < 0 || userGuess > 9999)
		{
			cout << "Please enter a valid 4-digit input: ";
			cin >> userGuess;
		}
		
		for (int i = 3; i >= 0; i--)
		{
			//cout << pow(10, i) << "\n";
			int digit;
			if (userGuess < pow(10, i))
			{
				digit = 0;
			}
			else
			{
				digit = userGuess / 10;
				userGuess %= 10;
			}
			cout << digit << "";
		}
	}
}

#pragma endregion

int main()
{
	//randomNumber();
	//getValidInput();
	//sumOfNumbers();
	//guessingGame();
	//mathsGame();
	mastermind();

	system("pause");
	return 0;
}