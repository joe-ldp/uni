#include <iostream>
#include <iomanip>
#include <time.h>
#include <string>
#include <conio.h>
#include <assert.h>
using namespace std;
void KeepCounting();
void NumberConversion();
void UPCCalculator();
void UPCChecker();
int main()
{
	bool runProgram = true;
	while (runProgram)
	{
		cout << "FoP4CS Mini Applications\n------------------------\nPlease select an option:\n1) Keep Counting Game\n2) Number Conversion Tool\n3) Universal Product Code (UPC) Calculator\n4) Universal Product Code (UPC) Checker\n9) Quit\nPlease enter option: ";
		string userInput = "";
		cin >> userInput;
		int choice(0);
		try
		{
			choice = stoi(userInput);
			switch (choice)
			{
				case 1:
					KeepCounting();
					break;
				case 2:
					NumberConversion();
					break;
				case 3:
					UPCCalculator();
					break;
				case 4:
					UPCChecker();
					break;
				case 9:
					runProgram = false;
					break;
				default:
					cout << "Please make a valid choice from the menu\n\n";
					system("pause");
					system("cls");
					break;
			}
		}
		catch (...)
		{
			cout << "Please make a valid choice from the menu\n\n";
			system("pause");
			system("cls");
		}
	}
	cout << "\n\n";
	system("pause");
	return 0;
}
void KeepCounting()
{
	system("cls");
	cout << "Keep Counting\n--------------\nYou will be presented with 8 addition questions. After the first question, the left-hand operand is the result of the previous addition\n\nPress any key to start...\n";
	char input = _getch();
	srand((int)time(NULL));
	int number1((rand() % 15) + 1), number2(0), ans(0), userInput(0);
	clock_t start = clock();
	const int numQuestions = 8;
	bool passed = true;
	for (int q = 1; q <= numQuestions; q++)
	{
		number2 = (rand() % 10) + 1;
		if ((rand() % 2) == 1)
		{
			ans = number1 + number2;
			cout << "Question " << q << ": " << number1 << " + " << number2 << " = ";
		}
		else
		{
			ans = number1 - number2;
			cout << "Question " << q << ": " << number1 << " - " << number2 << " = ";
		}
		cin >> userInput;
		if (userInput == ans)
			cout << "\n";
		else
		{
			cout << "Wrong answer. The correct answer was " << ans << ".\n\n";
			passed = false;
			break;
		}
		number1 = ans;
	}
	double duration = (clock() - start) / ((double)CLOCKS_PER_SEC / 10) / 10;
	if (passed) cout << "Well done, you got all of them right.\nQuestions complete in " << setprecision(3) << duration << " seconds (average per question of " << setprecision(3) << duration/ numQuestions << "s)\n\n";
	else cout << "You got one wrong.\nTime elapsed: " << setprecision(3) << duration << " seconds.\n\n";
	cout << "Press any key to return to main menu...";
	input = _getch();
	system("cls");
}
string DenaryToBase(int denary, int base);
void NumberConversion()
{
	system("cls");
	cout << "Number Conversion\n-----------------\nPlease enter a positive denary number: ";
	int denary(0);
	cin >> denary;
	string binary = DenaryToBase(denary, 2);
	string hex = DenaryToBase(denary, 16);
	cout << "Binary: " << binary << "\nHex: " << hex << "\n\nPress any key to return to main menu...";
	char input = _getch();
	system("cls");
}
string DenaryToBase(int denary, int base)
{
	string convertedNumber;
	int remainder(0), iterations = floor(log((float)denary) / log((float)base)) + 1;
	for (int i = 0; i < iterations; i++)
	{
		remainder = denary % base;
		denary /= base;
		if (remainder < 10)
			convertedNumber += remainder + 48;
		else
			convertedNumber += remainder + 55;
	} 
	std::reverse(convertedNumber.begin(), convertedNumber.end());
	return convertedNumber;
}
int CalculateCheckDigit(int code);
void UPCCalculator()
{
	system("cls");
	cout << "Universal Product Code (UPC) Calculator\n---------------------------------------\nThis calculator will take a 6-digit product code and generate a trailing 7th check digit to produce the final 7-digit UPC.\nPlease enter 6-digit code to generate final UPC code: ";
	string inputCode;
	int checkDigit(0);
	cin >> inputCode;
	try
		checkDigit = CalculateCheckDigit(stoi(inputCode));
	catch (...)
	{
		cout << "\n\nInvalid input. Press any key to try again.";
		char input = _getch();
		return UPCCalculator();
	}
	cout << "The final 7-digit UPC is: " << inputCode << checkDigit << "\n\nPress any key to return to main menu...";
	char input = _getch();
	system("cls");
}
void UPCChecker()
{
	system("cls");
	cout << "Universal Product Code (UPC) Checker\n\n------------------------------------\n\nThis checker will take a 7-digit UPC code with check digit and validate the code using the check digit. Please enter the 7-digit UPC code to be checked: ";
	int sixDigit, checkDigit;
	string UPC;
	cin >> UPC;
	try
	{
		sixDigit = stoi(UPC) / 10;
		checkDigit = CalculateCheckDigit(sixDigit);
	}
	catch (...)
	{
		cout << "\n\nInvalid input. Press any key to try again.";
		char input = _getch();
		return UPCChecker();
	}
	if (checkDigit == stoi(UPC) % 10)
		cout << "\nThe 7-digit code provided contains a valid check digit - this code is valid.\n";
	else
		cout << "\nThe 7-digit code provided contains an invalid check digit - this code is not valid.\n";
	cout << "Press any key to return to main menu...";
	char input = _getch();
	system("cls");
}
int CalculateCheckDigit(int code)
{
	if (code > 999999 || code < 0) throw "Invalid code!";
	const int numDigits = 6;
	int digitsChecker, digit, result(0);
	for (int i = 1; i <= numDigits; i++)
	{
		digitsChecker = (int)(pow(10, numDigits - i));
		if (code > digitsChecker)
		{
			digit = code / digitsChecker;
			code %= digitsChecker;

			if ((i + 1) % 2 == 0) digit *= 3;
			result += digit;
		}
	}
	int remainder = result % 10;
	if (remainder == 0) return 0;
	else return 10 - remainder;
}