#include "Element.h"
#include <fstream>
#include <Windows.h>

vector<Element*>* Element::loadElements(const wchar_t* filename)
{
	vector<Element*>* res = new vector<Element*>;

	ifstream fin(filename, ios::in);
	if (!fin.fail())
	{
		int atomic, column;
		string name, symbol;
		float mass;

		// 1	Hydrogen	H	1.0079	1
		fin >> atomic >> name >> symbol >> mass >> column;
		while (!fin.eof())
		{
			Element* newElement = new Element(atomic, name, symbol, mass, column);
			
			res->push_back(newElement);

			fin >> atomic >> name >> symbol >> mass >> column;
		}

		fin.close();
	}

	return res;
}

Element::Element(int atomic, const string& name, const string& symbol, float mass, int column) : atomicNumber(atomic), atomicMass(mass), column(column), x(0), y(0), width(0), height(0), selected(false)
{
	//wchar_t* name, *symbol;

	this->name = new wchar_t[name.size() + 1];
	this->symbol = new wchar_t[symbol.size() + 1];

	MultiByteToWideChar(CP_ACP, 0, name.c_str(), -1, this->name, name.size() + 1);
	MultiByteToWideChar(CP_ACP, 0, symbol.c_str(), -1, this->symbol, symbol.size() + 1);
}

Element::~Element()
{
	delete name;
	delete symbol;
}

void Element::draw(EasyGraphics* canvas)
{
	if (selected)
	{
		canvas->setBackColour(EasyGraphics::DARK_BLUE);
		canvas->setTextColour(EasyGraphics::WHITE);
	}
	else
	{
		canvas->setBackColour(EasyGraphics::WHITE);
		canvas->setTextColour(EasyGraphics::BLACK);
	}

	canvas->drawRectangle(x, y, width, height, true);
	canvas->drawText(symbol, x + (width / 4), y + (height / 8));
}

void Element::drawInfo(EasyGraphics* canvas, const boxRect& infoBox)
{
	const int TAB = 100;
	const int ROW = 15;
	const int PAD = 5;

	char buffer[500];
	// 1	Hydrogen	H	1.0079	1
	canvas->drawRectangle(infoBox.x, infoBox.y, infoBox.width, infoBox.height, true);

	canvas->drawText("Element Name: ", infoBox.x + 10, infoBox.y + PAD + (ROW*1));
	canvas->drawText(name, infoBox.x + 10 + TAB, infoBox.y + PAD + (ROW*1));

	canvas->drawText("Element Symbol: ", infoBox.x + 10, infoBox.y + PAD + (ROW*2));
	canvas->drawText(symbol, infoBox.x + 10 + TAB, infoBox.y + PAD + (ROW*2));

	_itoa_s(atomicNumber, buffer, 100, 10);
	canvas->drawText("Atomic Number: ", infoBox.x + 10, infoBox.y + PAD + (ROW*3));
	canvas->drawText(buffer, infoBox.x + 10 + TAB, infoBox.y + PAD + (ROW*3));

	_gcvt_s(buffer, atomicMass, atomicMass, 40);
	//_itoa_s(atomicMass, buffer, 100, 10);
	canvas->drawText("Atomic Mass: ", infoBox.x + 10, infoBox.y + PAD + (ROW*4));
	canvas->drawText(buffer, infoBox.x + 10 + TAB, infoBox.y + PAD + (ROW*4));

}