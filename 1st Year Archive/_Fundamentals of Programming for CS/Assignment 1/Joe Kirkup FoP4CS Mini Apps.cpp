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

// MENU //

int main()
{
	// Declare a bool to control the main loop of the program; while it is true the menu will continue to run over and over after each mini application finishes
	bool runProgram = true;

	while (runProgram)
	{
		// Say some stuff
		cout << "FoP4CS Mini Applications\n";
		cout << "------------------------\n";
		cout << "Please select an option:\n";
		cout << "1) Keep Counting Game\n";
		cout << "2) Number Conversion Tool\n";
		cout << "3) Universal Product Code (UPC) Calculator\n";
		cout << "4) Universal Product Code (UPC) Checker\n";
		cout << "9) Quit\n";
		cout << "Please enter option: ";

		// Take the user's input...
		string userInput = "";
		cin >> userInput;

		// ... and try to...
		int choice(0);
		try
		{
			// ... cast it as an int
			choice = stoi(userInput);

			/// Source for stoi:
			/// http://www.cplusplus.com/reference/string/stoi/

			// Then switch the casted input so we can act on their choice by calling the appropriate function
			switch (choice)
			{
				case 1:
				{
					KeepCounting();
					break;
				}
				case 2:
				{
					NumberConversion();
					break;
				}
				case 3:
				{
					UPCCalculator();
					break;
				}
				case 4:
				{
					UPCChecker();
					break;
				}
				case 9:
				{
					// This is the choice for exit; set runProgram to false so that the program loop terminates
					runProgram = false;
					break;
				}
				default:
				{
					// Must mean the user has entered an int but not one listed on the menu options. Simply leave the try statement and go back into the loop...
					cout << "Please make a valid choice from the menu\n\n";
					system("pause");
					system("cls");
					break;
				}
			}
		}
		catch (...) // Must mean the user has not entered an int
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

// KEEP COUNTING GAME //

/*
	When developing the 'keep counting' method, I varied the random number generation ranges to vary the difficulty,
	and balance between positive and negative numbers throughout the course of the game.
	I settled on the values seen below as they provide a consistently nice balance between the two signs but don't make it too hard.
*/

void KeepCounting()
{
	// Say some stuff
	system("cls");
	cout << "Keep Counting\n";
	cout << "--------------\n";
	cout << "You will be presented with 8 addition questions. ";
	cout << "After the first question, the left-hand operand is the result of the previous addition\n\n";
	cout << "Press any key to start...\n";

	char input = _getch();
	// Source for _getch(): https://docs.microsoft.com/en-us/cpp/c-runtime-library/reference/getch-getwch

	// Declare operands and answer tracking variables, used to generate questions and check if the user got them right
	int number1(0), number2(0), ans(0), userInput(0);

	// Randomise the seed
	srand((int)time(NULL));
	// Randomise the first number (this only needs doing once as after each step this number is set to the previous step's answer, not randomised)
	number1 = (rand() % 15) + 1;

	// 'Start a timer' (take the current time value so we can calculate the difference between start and end times later)
	clock_t start = clock();

	// Source for clock():
	// https://stackoverflow.com/a/3220503

	// Just a constant holding the number of questions, as the value is used in multiple places...
	const int numQuestions = 8;

	// ... and a bool we initialise as true then set to false if the user fails (this is for the output after the game has ended)
	bool passed = true;

	// Iterate for the correct number of questions; we start the iterating variable at 1 just to better represent the question numbers
	for (int q = 1; q <= numQuestions; q++)
	{
		// Randomise the second number (no need to randomise the seed as we did this before the loop)
		number2 = (rand() % 10) + 1;

		if ((rand() % 2) == 1) // Use a 50/50 random number to decide whether to do an addition or subtraction question
		{
			// Calculate the answer, and tell the user what the question is
			ans = number1 + number2;
			cout << "Question " << q << ": " << number1 << " + " << number2 << " = ";
		}
		else
		{
			// As above...
			ans = number1 - number2;
			cout << "Question " << q << ": " << number1 << " - " << number2 << " = ";
		}

		cin >> userInput;

		if (userInput == ans) // If the user is right, we don't need to do anything right now
		{
			cout << "\n";
		}
		else // If the user is wrong, tell them the correct answer, set the passed variable to false and break out of the for loop (to end the game)
		{
			cout << "Wrong answer. The correct answer was " << ans << ".\n\n";
			passed = false;
			break;
		}

		// If we get to this point, the user must have passed so we can set the new left-hand operand to this question's answer
		number1 = ans;
	}

	// Record the overall time taken
	double duration = (clock() - start) / ((double)CLOCKS_PER_SEC / 10) / 10;

	// Say some stuff
	if (passed) cout << "Well done, you got all of them right.\nQuestions complete in " << setprecision(3) << duration << " seconds (average per question of " << setprecision(3) << duration/ numQuestions << "s)\n\n";
	else cout << "You got one wrong.\nTime elapsed: " << setprecision(3) << duration << " seconds.\n\n";


	cout << "Press any key to return to main menu...";
	input = _getch();
	system("cls");
}

// NUMBER CONVERSION //

/*
	Whilst developing the number conversion part of the program, I went through several stages of method design, originally having separate functions
	for converting to binary and hexadecimal, but after some tweaking of the hex method I realised I could easily turn it into a function which
	converted denary numbers to any base, in less lines of code (and possibly in a more efficient manner) than in dedicated functions.

	All three of these functions inevitably needed a lot of tweaking and testing to make sure all the maths was spot on, so I used some for loops
	to test the functions thoroughly by calling them many times without having to run the code many times or give many inputs.
	An example of one of these is left in the main number conversion function below (lines 221-224)
*/

string DenaryToBase(int denary, int base);

void NumberConversion()
{
	// Say some stuff
	system("cls");
	cout << "Number Conversion\n";
	cout << "-----------------\n";
	cout << "Please enter a positive denary number: ";

	// We assume the user enters a valid input, as specified in the brief
	int denary(0);
	cin >> denary;

	/*for (int b = 2; b <= 36; b++)
	{
		cout << "Base " << b << ": " << DenaryToBase(denary, b) << "\n";
	}*/

	// Call the conversion function a couple times...
	string binary = DenaryToBase(denary, 2);
	string hex = DenaryToBase(denary, 16);
	
	// ... and output the results
	cout << "Binary: " << binary << "\n";
	cout << "Hex: " << hex << "\n\n";


	cout << "Press any key to return to main menu...";
	char input = _getch();
	system("cls");
}

string DenaryToBase(int denary, int base)
{
	string convertedNumber; // The function does not know if the base will be >10 (i.e. using non-numeral characters) so we must keep the output as a string
	int remainder(0);

	// Calculate the number of iterations needed using the logarithm to the base of the numeral base of the denary number, floored, +1
	int iterations = floor(log((float)denary) / log((float)base)) + 1;
	for (int i = 0; i < iterations; i++)
	{
		remainder = denary % base; // Calculate the remainder using modulo
		denary /= base; // Update the number ready for the next step

		if (remainder < 10) // If the remainder is <10, we are still within numerals 0-9 so...
			convertedNumber += remainder + 48; // ... add 48 to get the corresponding ASCII code for the number
		else // We are beyond numerals 0-9 so...
			convertedNumber += remainder + 55; // ... add 55 to get the corresponding A-F (or higher) ASCII code
	} 

	std::reverse(convertedNumber.begin(), convertedNumber.end()); // Reverse the string (since the calculation works backwards)

	return convertedNumber;
}

/*
	To make sure that the check digit calculating function was working properly (and crucially, correctly dealing with zeros in the code),
	I worked out examples of all possibilites involving zeros (and a few others) to run through the function;

	0, 1, 2, 3, 4, 5 = ((0 + 2 + 4) * 3) + 1 + 3 + 5 = 18 + 9 = 27 % 10 = 7 != 0 -> 10 - 7 = 3
	1, 0, 2, 3, 4, 5 = ((1 + 2 + 4) * 3) + 0 + 3 + 5 = 21 + 8 = 29 % 10 = 7 != 0 -> 10 - 9 = 1
	1, 2, 0, 3, 4, 5 = ((1 + 0 + 4) * 3) + 2 + 3 + 5 = 15 + 10 = 25 % 10 = 7 != 0 -> 10 - 5 = 5
	1, 2, 3, 0, 4, 5 = ((1 + 3 + 4) * 3) + 2 + 0 + 5 = 24 + 7 = 31 % 10 = 7 != 0 -> 10 - 1 = 9
	1, 2, 3, 4, 0, 5 = ((1 + 3 + 0) * 3) + 2 + 4 + 5 = 12 + 11 = 23 % 10 = 7 != 0 -> 10 - 3 = 7
	1, 2, 3, 4, 5, 0 = ((1 + 3 + 5) * 3) + 2 + 4 + 0 = 27 + 6 = 33 % 10 = 7 != 0 -> 10 - 3 = 7

*/

// UPC CHEKCER / CALCULATOR //

int CalculateCheckDigit(int code);

void UPCCalculator()
{
	// Say some stuff
	system("cls");
	cout << "Universal Product Code (UPC) Calculator\n";
	cout << "---------------------------------------\n";
	cout << "This calculator will take a 6-digit product code ";
	cout << "and generate a trailing 7th check digit to produce ";
	cout << "the final 7-digit UPC.\n";
	cout << "Please enter 6-digit code to generate final UPC code: ";

	// Get the user's input and declare a variable for storing the calculated check digit
	string inputCode; // The user's input is stored in a string so that we can retain leading zeros
	int checkDigit(0);

	cin >> inputCode;
	try
	{
		// Try to call the function. If the stoi() here fails, we fall into the catch statement
		// If the code is invalid (not 6 digits), the function throws an error and we fall into the catch statement
		checkDigit = CalculateCheckDigit(stoi(inputCode));
	}
	catch (...)
	{
		// Yell at the user and call the function again
		cout << "\n\nInvalid input. Press any key to try again.";
		char input = _getch();
		return UPCCalculator();
	}

	// If we get through the try statement, the calculation worked and we can now output the result
	cout << "The final 7-digit UPC is: " << inputCode << checkDigit << "\n\n";


	cout << "Press any key to return to main menu...";
	char input = _getch();
	system("cls");
}

void UPCChecker()
{
	// Say some stuff
	system("cls");
	cout << "Universal Product Code (UPC) Checker\n\n";
	cout << "------------------------------------\n\n";
	cout << "This checker will take a 7-digit UPC code with check digit ";
	cout << "and validate the code using the check digit. ";
	cout << "Please enter the 7-digit UPC code to be checked: ";

	// Variables to store the UPC minus the proposed check digit, and the calculated check digit
	int sixDigit, checkDigit;
	// User input
	string UPC;
	cin >> UPC;

	// Same input handling as in UPCCalculator()...
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


	if (checkDigit == stoi(UPC) % 10) // If the check digit we calculated is the same as the last digit of the input...
	{
		// ... it is valid!
		cout << "\nThe 7-digit code provided contains a valid check digit - this code is valid.\n";
	}
	else // But if not...
	{
		// ... then it's not valid
		cout << "\nThe 7-digit code provided contains an invalid check digit - this code is not valid.\n";
	}


	cout << "Press any key to return to main menu...";
	char input = _getch();
	system("cls");
}

int CalculateCheckDigit(int code)
{
	if (code > 999999 || code < 0) throw "Invalid code!"; // Throw an error if the code isn't 6 digits (technically could be 6 zeros)

	const int numDigits = 6; // Number of digits in the input code
	int digitsChecker, digit, result(0); // Variables to check for leading zeros; store current digit; store the result of calculations

	for (int i = 1; i <= numDigits; i++) // Iterate once for each digit
	{
		digitsChecker = (int)(pow(10, numDigits - i)); // 10 the power of 1-6 along with forced integer division can be used to validate the number of digits and get each digit individually
		if (code > digitsChecker) // If this digit is not a 0... (if it is, the current version of code will be less than digitsChecker)
		{
			digit = code / digitsChecker; // Extract the digit...
			code %= digitsChecker; // ... and discard it from the code using the remainder

			if ((i + 1) % 2 == 0) digit *= 3; // If the current position is odd, multiply the digit by 3...
			result += digit; // ... then add the digit to the result (this is not the final check digit, but used to calculate it)
		}
	}

	int remainder = result % 10; // Calculate the remainder using modulo

	if (remainder == 0) return 0; // If the remainder is 0, the check digit is 0
	else return 10 - remainder; // If not, the check digit is 10 minus the remainder
}