#include "Dice.h"

Dice::Dice()
{
	value = 0;
	held = false;
}

Dice::Dice(int value)
{
	this->value = value;
	held = false;
}

Dice::Dice(bool held)
{
	value = 0;
	this->held = held;
}

Dice::Dice(int value, bool held)
{
	this->value = value;
	this->held = held;
}

Dice::~Dice()
{

}

void Dice::roll()
{

}

void Dice::hold()
{
	held = true;
}