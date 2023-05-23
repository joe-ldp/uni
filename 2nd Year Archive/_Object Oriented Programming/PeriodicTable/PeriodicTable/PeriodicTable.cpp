#include "PeriodicTable.h"

PeriodicTable::PeriodicTable() : selectedElement(nullptr)
{
	setImmediateDrawMode(false);

	// load elements here
	elements = Element::loadElements(L"elements.txt");
}

PeriodicTable::~PeriodicTable()
{
	// Clean up memory

	for (int i = 0; i < elements->size(); i++)
	{
		delete elements->at(i);
	}

	delete elements;
}

void PeriodicTable::onCreate()
{
	EasyGraphics::onCreate();

	::SetWindowText(getHWND(), L"OOP4CS: Periodic Table");
}

void PeriodicTable::onDraw()
{
	clearScreen(WHITE);

	setTextColour(BLACK);
	setPenColour(BLACK, 1);

	//RECT rect;
	//GetClientRect(getHWND(), &rect);

	for (int i = 0; i < elements->size(); i++)
	{
		Element* element = elements->at(i);
		element->draw(this);
	}

	if (selectedElement)
	{
		selectedElement->drawInfo(this, infoBox);
	}

	EasyGraphics::onDraw();
}

void PeriodicTable::onLButtonDown(UINT nFlags, int x, int y)
{
	if (selectedElement)
	{
		selectedElement->select(false);
		selectedElement = nullptr;
	}

	for (int i = 0; i < elements->size(); i++)
	{
		Element* element = elements->at(i);
		if (element->hitTest(x, y))
		{
			element->select(true);
			selectedElement = element;
			break;
		}
	}

	onDraw();
}

void PeriodicTable::onSize(UINT nType, int cx, int cy)
{
	EasyGraphics::onSize(nType, cx, cy);

	if (cx != 0 && cy != 0)
	{
		const int numColumns = 18 + 2; // +2 for some padding either side
		const int elWidth = (cx / numColumns);

		const int numRows = 16;
		const int elHeight = (cx / numRows);

		int x = 0, y = elHeight / 4;
		int atomicNumber, column, yOffset;

		for (int i = 0; i < elements->size(); i++)
		{
			Element* element = elements->at(i);

			atomicNumber = element->getAtomicNumber();
			column = element->getColumn();

			x = elWidth * column + (column > 2 ? elWidth/2 : 0);
			yOffset = (atomicNumber >= 57 && atomicNumber <= 71) || (atomicNumber >= 89 && atomicNumber <= 103) ? elHeight * 3 : 0;

			if (element->setPosition(x, y + yOffset, elWidth, elHeight))
			{
				y += elHeight;
			}
		}

		infoBox.width = cx / 3;
		infoBox.height = 100;
		infoBox.x = (cx - infoBox.width) / 2;
		infoBox.y = cy - infoBox.height - 20;
	}
}