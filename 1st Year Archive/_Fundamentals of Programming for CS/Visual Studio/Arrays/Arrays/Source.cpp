#include <iostream>
#include <time.h>

using namespace std;

void RandomlyPopulateArray(int arr[], int size, int min, int max);
int FindValueInArray(int arr[], int size, int toFind);
void OutputArray(char arr[], int size);
void OutputArray(int arr[], int size);
int FindAndReplace(int arr[], int size, char find, char replace);

int main()
{
	/*const int size = 15;
	int myArray[size];

	RandomlyPopulateArray(myArray, size, 1, 15);

	OutputArray(myArray, size);

	cout << FindValueInArray(myArray, size, 3);*/

	char charArr[] = { 'H', 'e', 'l', 'l', 'o', '\0' }; // insert 'Hello' into an array of characters
	OutputArray(charArr, 6); // goes to the first definition of the function

	int intArr[] = { 'H', 'e', 'l', 'l', 'o', '\0' }; // insert 'Hello' into an array of integers (each element will store the integer value of the character - using ASCII)
	FindAndReplace(intArr, 6, 'H', 'B');
	OutputArray(intArr, 6); // goes to the second definition of the function

	cout << "\n\n";
	system("pause");
	return 0;
}

void RandomlyPopulateArray(int arr[], int size, int min, int max)
{
	srand((int)time(NULL)); // randomise the seed
	for (int i = 0; i < size + 1; i++) // iterate through the array
	{
		arr[i] = rand() % (max - min) + 1 + min; // randomise each element
	}
}

int FindValueInArray(int arr[], int size, int toFind)
{
	int occ(0); // occurrences of toFind

	for (int i = 0; i < size + 1; i++) // iterate throught the array
	{
		if (arr[i] == toFind) // if the array element is equal to what we are looking for...
		{
			occ++; // ... update the number of occurrences
		}
	}

	return occ;
}

void OutputArray(char arr[], int size) // version #1 / original definition of the function, takes a char array
{
	for (int i = 0; i < size + 1 && arr[i] != '\0'; i++)
	{
		cout << arr[i]; // just outputs the chars
	}
	cout << "\n";
}

void OutputArray(int arr[], int size) // function overload: same name with different parameters, takes an int array
{
	for (int i = 0; i < size + 1 && (char)arr[i] != '\0'; i++)
	{
		cout << (char)arr[i]; // converts the ints to the corresponding chars using (char)
	}
	cout << "\n";
}

int FindAndReplace(int arr[], int size, char find, char replace)
{
	int changes(0); // number of characters found and replaced

	for (int i = 0; i < size + 1; i++) // iterate through the array
	{
		if (arr[i] == find) // if the array element is equal to what we are looking for...
		{
			arr[i] = replace; // ... replace it...
			changes++; // ... and update the number of changes
		}
	}

	return changes; // return the total number of changes made
}