#pragma once
#include "TurtleCommand.h"

class CmdRotate : public TurtleCommand
{
public:
	CmdRotate(TurtleCommand* parent, ifstream& fin);
	virtual void execute(TurtleCanvas* canvas);

private:
	int degrees;
};

inline void CmdRotate::execute(TurtleCanvas* canvas)
{
	canvas->rotate(degrees);
}

inline CmdRotate::CmdRotate(TurtleCommand* parent, ifstream& fin) : TurtleCommand(parent)
{
	fin >> degrees;
}
