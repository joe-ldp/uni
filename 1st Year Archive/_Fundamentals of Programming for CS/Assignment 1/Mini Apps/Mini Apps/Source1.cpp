//string baseChars[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

#include <iostream>
#include <iomanip>
#include <time.h>
#include <string>
#include <conio.h>

using namespace std;

string DenaryToBinary(int denary);
string DenaryToHex(int denary);

string DenaryToBinary(int denary)
{
	string binaryString; // String to append characters to as we calculate the result
	int remainder(0); // Int to store each character as they are calculated

	if (denary % 2) binaryString += "1";
	else binaryString += "0";

	while (denary / 2 > 0)
	{
		denary /= 2; // Divide the denary value by 2 (remainder is trashed due to integer division)
		remainder = denary % 2; // Take the remainder using the modulo operator
		binaryString += to_string(remainder); // Append the remainder to the result
	}

	std::reverse(binaryString.begin(), binaryString.end());

	return (binaryString);
}

string DenaryToHex(int denary)
{
	string hexString;
	int remainder(0);

	do
	{
		remainder = denary % 16;
		if (remainder)
		{
			denary = (denary / 16);
		}
		else
		{
			denary /= 16;
		}

		string hexChar;
		switch (remainder)
		{
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			hexChar = to_string(remainder);
			break;
		case 10:
			hexChar = "A";
			break;
		case 11:
			hexChar = "B";
			break;
		case 12:
			hexChar = "C";
			break;
		case 13:
			hexChar = "D";
			break;
		case 14:
			hexChar = "E";
			break;
		case 15:
			hexChar = "F";
			break;
		}
		hexString += hexChar;

	} while (denary % 16 != 0);

	std::reverse(hexString.begin(), hexString.end());

	return hexString;
}