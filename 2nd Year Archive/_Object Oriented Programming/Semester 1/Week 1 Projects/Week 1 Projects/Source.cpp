#include <iostream>
#include <time.h>

using namespace std;

void arithmetic();
void guessingGame();
void mastermind();

int main()
{
	//arithmetic();
	//guessingGame();
	mastermind();

	return 0;
}

void arithmetic()
{
	int turn = 1, number1 = 0, number2 = 0, ans = 0, guess = 0;
	string sign;

	srand((int)time(NULL));
	number1 = (rand() % 10) + 1;

	while (true)
	{
		number2 = (rand() % 10) + 1;
		if (rand() % 2)
		{
			ans = number1 + number2;
			sign = "+";
		}
		else
		{
			ans = number1 - number2;
			sign = "-";
		}

		cout << "What is " << number1 << " " << sign << " " << number2 << "?\n";

		cin >> guess;

		if (guess == ans)
		{
			turn++;
			number1 = ans;
		}
		else
		{
			break;
		}
	}

	cout << "You got " << turn << " questions right before making a mistake";
}

void guessingGame()
{
	srand((int)time(NULL));
	int toGuess = (rand() % 10) + 1, userGuess = 0;
	bool guessed = false;
	cout << "Guess a number from 1 - 10\n";

	for (int attempts = 1; attempts <= 3; attempts++)
	{
		//cout << attempts << "\n";
		cin >> userGuess;
		if (userGuess == toGuess)
		{
			cout << "\nCorrect! It took you " << attempts << " attempt(s) to guess the number.\n";
			guessed = true;
		}
		else if (userGuess > toGuess)
		{
			cout << "That's not right. Go lower!\n";
		}
		else
		{
			cout << "That's not right. Go higher!\n";
		}
	}
	cout << "You ran out of tries. The number was " << toGuess << "\n\n";
}

void mastermind()
{

}