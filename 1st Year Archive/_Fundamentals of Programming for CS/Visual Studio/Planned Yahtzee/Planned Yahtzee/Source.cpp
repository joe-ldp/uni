#include <iostream>
#include <fstream>
#include <string>
#include <random>
#include <time.h>
#include <iomanip>

using namespace std;

struct Die
{
	Die()
	{
		val = 0;
		held = false;
	}

	short val;
	bool held;
};

struct Set
{
	Set()
	{
		dieCount = 6;
		dice = new Die[dieCount];
		
		scoreOn = 0;
		score = 0;
	}

	short dieCount;
	Die* dice;

	short scoreOn, score;
};

void RollSet(Set& set);
void PrintSet(Set& set);
void ScoreSet(Set& set, short scoreOn);
void PrintScorecard(int scores[]);

int main()
{
	srand((int)time(NULL));

	//Set h;
	//RollSet(h);
	//PrintSet(h);

	//for (int i = 1; i <= 6; i++)
	//{
	//	ScoreSet(h, i);
	//	cout << i << "s: " << h.score << "\n";
	//}

	const int numSets = 6;
	Set sets[numSets];
	Set& set = sets[0];
	int scores[] = { 0, 0, 0, 0, 0, 0 }, input;
	for (int i = 0; i < numSets; i++)
	{
		set = sets[i];
		cout << "Set #" << i + 1 << " of " << numSets << "\n-------------------\n";



		cout << "Enter a number 1-6 to hold or anything else to roll again: ";

		try
		{
			
			cin >> input;
			for (int j = 0; j < set.dieCount; j++)
			{
				if (set.dice[j].val == input)
				{
					set.dice[j].held = true;
				}
			}
		}
		catch (...)
		{

		}

		RollSet(set);
		cout << "\n\n\n";
	}
	
	//PrintScorecard(scores);

	system("pause");
	return 0;
}

void RollSet(Set& set)
{
	for (int i = 0; i < set.dieCount; i++)
	{
		set.dice[i].val = (rand() % 6) + 1;
		//if (rand() % 2 == 0) set.dice[i].held = true;
	}

	PrintSet(set);
}

void PrintSet(Set& set)
{
	cout << setw(6) << "Dice #\t";

	for (int i = 1; i <= set.dieCount; i++)
	{
		cout << setw(6) << i << "\t";
	}
	cout << "\n";

	cout << setw(6) << "Value\t";

	for (int i = 0; i < set.dieCount; i++)
	{
		cout << setw(6) << set.dice[i].val;

		if (set.dice[i].held) cout << "*";

		cout << "\t";
	}
	cout << "\n";
}

void ScoreSet(Set& set, short scoreOn)
{
	short score(0);
	
	for (int i = 0; i < set.dieCount; i++)
	{
		if (set.dice[i].val == scoreOn) score += scoreOn;
	}

	set.score = score;
	set.scoreOn = scoreOn;
}

void PrintScorecard(int scores[])
{
	cout << "---- SCORECARD ----\n";
	cout << setw(12) << "Aces: " << scores[0] << "\n";
	cout << setw(12) << "Twos: " << scores[1] << "\n";
	cout << setw(12) << "Threes: " << scores[2] << "\n";
	cout << setw(12) << "Fours: " << scores[3] << "\n";
	cout << setw(12) << "Fives: " << scores[4] << "\n";
	cout << setw(12) << "Sixes: " << scores[5] << "\n";
	cout << "-------------------\n\n";
}