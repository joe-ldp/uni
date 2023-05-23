#pragma once
#include "TurtleCanvas.h"
#include <fstream>

using namespace std;

class TurtleCommand
{
public:
	TurtleCommand(TurtleCommand* parent);

	virtual void execute(TurtleCanvas* canvas) = 0;

private:
	TurtleCommand *parent, *child;

};

inline TurtleCommand::TurtleCommand(TurtleCommand* parent) : parent(parent), child(nullptr) {}