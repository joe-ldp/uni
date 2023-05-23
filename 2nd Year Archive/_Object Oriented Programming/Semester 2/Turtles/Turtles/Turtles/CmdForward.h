#pragma once
#include "TurtleCommand.h"

class CmdForward : public TurtleCommand
{
public:
	CmdForward(TurtleCommand* parent, ifstream& fin);
	virtual void execute(TurtleCanvas* canvas);

private:
	int distance;
};

inline void CmdForward::execute(TurtleCanvas* canvas)
{
	canvas->forward(distance);
}

inline CmdForward::CmdForward(TurtleCommand* parent, ifstream& fin) : TurtleCommand(parent)
{
	fin >> distance;
}