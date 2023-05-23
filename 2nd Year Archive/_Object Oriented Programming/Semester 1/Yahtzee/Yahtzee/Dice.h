#pragma once

using namespace std;

class Dice
{
public:
	Dice();
	Dice(int value);
	Dice(bool held);
	Dice(int value, bool held);
	~Dice();

	void roll();
	void hold();

private:
	int value;
	bool held;
};

