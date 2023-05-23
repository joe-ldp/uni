#include "PeriodicTable.h"

PeriodicTable::PeriodicTable()
{
	setImmediateDrawMode(false);
}

PeriodicTable::~PeriodicTable()
{

}

void PeriodicTable::onDraw()
{
	clearScreen(WHITE);

	EasyGraphics::onDraw();
}