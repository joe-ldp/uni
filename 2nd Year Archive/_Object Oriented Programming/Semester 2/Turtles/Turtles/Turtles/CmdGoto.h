#pragma once
#include "TurtleCommand.h"

class CmdGoto : public TurtleCommand
{
public:
	CmdGoto(TurtleCommand* parent, ifstream& fin);
	CmdGoto(TurtleCommand* parent, int x, int y);
	virtual void execute(TurtleCanvas* canvas);

private:
	int x, y;
};

inline void CmdGoto::execute(TurtleCanvas* canvas)
{
	canvas->moveTo(x, y);
}

inline CmdGoto::CmdGoto(TurtleCommand* parent, int x, int y) : x(x), y(y), TurtleCommand(parent) {}

inline CmdGoto::CmdGoto(TurtleCommand* parent, ifstream& fin) : TurtleCommand(parent)
{
	fin >> x >> y;
}
