#pragma once
#include "TurtleCommand.h"

class CommandList
{
public:
	CommandList(const wchar_t* filename);

private:
	TurtleCommand* root;
};