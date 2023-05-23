#pragma once
#include "Question.h"

class Subtraction : public Question
{
public:
	Subtraction();
	~Subtraction();

private:

	virtual char getSymbol() const;
	virtual int getAns() const;
};

inline char Subtraction::getSymbol() const
{
	return '-';
}

inline int Subtraction::getAns() const
{
	return getOp1() - getOp2();
}