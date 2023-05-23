#pragma once
#include "Question.h"

class Addition : public Question
{
public:
	Addition();
	~Addition();

private:

	virtual char getSymbol() const;
	virtual int getAns() const;
};

inline char Addition::getSymbol() const
{
	return '+';
}

inline int Addition::getAns() const
{
	return getOp1() + getOp2();
}