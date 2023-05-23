#include <iostream>
#include <string>

using namespace std;

int StringLength(const char theStr[]);
void DisplayString(const char theStr[]);
int CompareStrings(const char str1[], const char str2[], const bool caseSensitive = true);
void ConcatStrings(char out[], const int maxOutLength, const char source[]);
void RemoveCharacter(char theStr[], const int pos);

int main()
{
	/*const char text[] = "Number 1 is \0one";
	int length = StringLength(text);*/

	/*const char text[] = "this is a thingy mc thinger with a \n new line here and \n there, also an escape \0 character\n";
	DisplayString(text);*/

	/*cout << CompareStrings("Hello", "Hello", false) << "\n";

	cout << CompareStrings("A", "B", false) << "\n";
	cout << CompareStrings("B", "A", false) << "\n";

	cout << CompareStrings("A", "a", false) << "\n";
	cout << CompareStrings("a", "A", false) << "\n";

	cout << CompareStrings("HI", "hi", false) << "\n";*/

	/*char str1[10] = "Hello";
	char str2[] = "World";
	ConcatStrings(str1, 10, str2);
	cout << str1;*/

	char text[] = "Hello World";
	cout << text << "\n";
	RemoveCharacter(text, -3);
	cout << text << "\n";

	system("pause");
	return 0;
}

int StringLength(const char theStr[])
{
	int count(0);

	while (theStr[count] != '\0')
	{
		count++;
	}

	return count;
}

void DisplayString(const char theStr[])
{
	int pos(0);
	while (theStr[pos])
	{
		cout << theStr[pos++];
	}
}

int CompareStrings(const char str1[], const char str2[], const bool caseSensitive)
{
	int pos(0);
	char char1, char2;

	while (str1[pos] || str2[pos])
	{
		char1 = str1[pos];
		char2 = str2[pos++];

		if (!caseSensitive)
		{
			char1 = tolower(char1);
			char2 = tolower(char2);
		}

		if (char1 != char2) return char1 < char2 ? -1 : 1;
	}

	return 0;
}

void ConcatStrings(char out[], const int maxOutLength, const char source[])
{
	bool write = false;
	int startAt(0);

	for (int i = 0; i < maxOutLength; i++)
	{
		if (out[i] == '\0') write = true;
		
		if (write)
		{
			out[i] = source[i - startAt];
		}
		else
		{
			startAt++;
		}
	}

	out[maxOutLength] = '\0';
}

void RemoveCharacter(char theStr[], const int removePos)
{
	int pos(0);
	while (theStr[pos] && removePos >= 0)
	{
		if (pos >= removePos)
		{
			theStr[pos] = theStr[pos + 1];
		}
		pos++;
	}

	//theStr[pos] = '\0';
}