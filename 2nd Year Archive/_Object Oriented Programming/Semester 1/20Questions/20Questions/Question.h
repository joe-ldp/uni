#pragma once
#include <stdlib.h>
#include <iostream>

using namespace std;

class Question
{
public:
	Question();
	~Question();

	void displayQuestion() const;
	void readAnswer();
	bool isCorrect() const;

private:
	int op1, op2, userAns;

	virtual char getSymbol() const = 0;
	virtual int getAns() const = 0;

	static const int MIN_OP = 1;
	static const int MAX_OP = 20;

	static int generateRandOp();

protected:
	int getOp1() const;
	int getOp2() const;
};

inline int Question::generateRandOp()
{
	return MIN_OP + (((MAX_OP - MIN_OP + 1) * rand()) / RAND_MAX);
}

inline void Question::displayQuestion() const
{
	cout << "What is " << getOp1() << " " << getSymbol() << " " << getOp2() << " = ";
}

inline void Question::readAnswer()
{
	cin >> userAns;
}

inline bool Question::isCorrect() const
{
	return userAns == getAns();
}

inline int Question::getOp1() const
{
	return op1;
}

inline int Question::getOp2() const
{
	return op2;
}