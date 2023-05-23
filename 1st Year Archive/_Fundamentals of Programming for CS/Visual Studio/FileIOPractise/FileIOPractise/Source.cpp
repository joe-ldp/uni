#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void WriteFile();
void ReadFile();
string SelectFile();

int main()
{
	bool runProgram = true;

	while (runProgram)
	{
		cout << "Epic Fileinator 9000 \n------------------------ \nPlease select an option: \n1) Write to a file \n2) Read from a file \n9) Quit \nPlease enter option: ";

		string userInput;
		cin >> userInput;

		int choice(0);
		try
		{
			choice = stoi(userInput);

			switch (choice)
			{
				case 1:
				{
					WriteFile();
					break;
				}
				case 2:
				{
					ReadFile();
					break;
				}
				case 9:
				{
					runProgram = false;
					break;
				}
				default:
				{
					cout << "Please make a valid choice from the menu\n\n";
					system("pause");
					system("cls");
					break;
				}
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

string SelectFile()
{
	string filename;
	cout << "Enter the name of the file you want to access: ";
	cin >> filename;

	return filename;
}

void WriteFile()
{
	ofstream file(SelectFile());

	if (!file.fail())
	{
		string input;
		do
		{
			cout << "Enter text (Ctrl-Z to end): ";
			cin >> input;

			if (cin)
			{
				if (input == "\\n") file << "\n";
				else file << input;
			}
		} while (cin);
	}

	cin.clear();
	cin.ignore();

	file.close();
}

void ReadFile()
{

}