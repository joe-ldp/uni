#pragma once
#include <windows.h>

class CollisionBox
{
public:
	bool hitTest(RECT other);

private:
	RECT hitBox;
};

