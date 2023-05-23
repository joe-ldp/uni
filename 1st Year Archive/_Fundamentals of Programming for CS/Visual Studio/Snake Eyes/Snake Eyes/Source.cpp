#include <iostream>
#include <iomanip>
#include <string>
#include <algorithm>

using namespace std;

int snakeEyes();
void displayDiceFace(int number);
bool yesNoResponse();
int randomNumber(int min, int max);

int main()
{
	//for (int i = 1; i <= 6; i++) displayDiceFace(i);

	/*cout << "Please enter yes (Y) or no (N): ";
	if (yesNoResponse())
	{
		cout << "\nThe user said yes";
	}
	else
	{
		cout << "\nThe user said no";
	}*/

	//for (int i = 0; i < 25; i++) cout << randomNumber(0, i*10) << "\n";



	//int highScore = 0;
	int score = snakeEyes();

	if (score == -1)
	{
		cout << "You've gone bust. You just had to push your luck a little too much...\n";
	}
	else if (score == -2)
	{
		cout << "Wise choice... the house always wins.\n\nRemember, always Gamble Aware folks...\n\n";
	}
	else
	{
		cout << "Well done. You beat snake eyes with a total of " << score << "\n";

		/*if (score > highScore)
		{
			highScore = score;
			cout << "Well done, you have got a new highest total";
		}*/
	}

	cout << "\n\n";
	system("pause");
	return 0;
}

int snakeEyes()
{
	cout << "Welcome to Snake Eyes\n\n";
	cout << "Throw as many times as you dare and get as high a score as possible...\n... but before getting double 1s or double 6s\nThrowing doubles will halve your score\nAre you ready to play? (y/n) ";

	if (yesNoResponse())
	{
		int throwNum(1);
		int dice1(0);
		int dice2(0);
		bool play = true;
		while (play)
		{
			cout << "Throw " << throwNum << "\n";

			dice1 = randomNumber(1, 6);
			displayDiceFace(dice1);

			dice2 = randomNumber(1, 6);
			displayDiceFace(dice2);

			throwNum++;



			//cin.ignore();
		}
	}
	else
	{
		return -2;
	}

	return 0;
}

void displayDiceFace(int number)
{
	string fullLn = "*********\n";
	string blankLn = "*       *\n";

	switch (number)
	{
		case 1:
		{
			cout << fullLn << blankLn << "*     1 *\n*     1 *\n*     1 *\n*     1 *\n*     1 *\n" << blankLn << fullLn;
			break;
		}
		case 2:
		{
			cout << fullLn << blankLn << "* 22222 *\n*     2 *\n* 22222 *\n* 2     *\n* 22222 *\n" << blankLn << fullLn;
			break;
		}
		case 3:
		{
			cout << fullLn << blankLn << "* 33333 *\n*     3 *\n*   333 *\n*     3 *\n* 33333 *\n" << blankLn << fullLn;
			break;
		}
		case 4:
		{
			cout << fullLn << blankLn << "* 4   4 *\n* 4   4 *\n* 44444 *\n*     4 *\n*     4 *\n" << blankLn << fullLn;
			break;
		}
		case 5:
		{
			cout << fullLn << blankLn << "* 55555 *\n* 5     *\n* 55555 *\n*     5 *\n* 55555 *\n" << blankLn << fullLn;
			break;
		}
		case 6:
		{
			cout << fullLn << blankLn << "* 66666 *\n* 6     *\n* 66666 *\n* 6   6 *\n* 66666 *\n" << blankLn << fullLn;
			break;
		}
		default:
		{

			break;
		}
	}
}

bool yesNoResponse()
{
	string userInput;
	cin >> userInput;

	transform(userInput.begin(), userInput.end(), userInput.begin(), toupper);
	//cout << userInput;

	if (userInput == "Y")
	{
		return true;
	}
	else if (userInput == "N")
	{
		return false;
	}
	else
	{
		cout << "\nInvalid input, please try again: ";
		return yesNoResponse();
	}
}

int randomNumber(int min, int max)
{
	return rand() % (max - min + 1) + 1 + min;
}