#pragma once
#include <vector>
#include <string>
#include "EasyGraphics.h"

using namespace std;

struct boxRect
{
	int x, y, width, height;
};

class Element
{
public:
	~Element();

	void draw(EasyGraphics* canvas);
	bool setPosition(int x, int y, int width, int height);
	bool hitTest(int x, int y);
	void drawInfo(EasyGraphics* canvas, const boxRect& infoBox);

	void select(bool select);
	int getAtomicNumber() const { return atomicNumber; }
	int getColumn() const { return column; }

	static vector<Element*>* loadElements(const wchar_t* filename);

protected:


private:
	wchar_t* name, *symbol;
	float atomicMass;
	int atomicNumber, column;

	int x, y, width, height;
	bool selected;

	Element(int atomic, const string& name, const string& symbol, float mass, int column);
};

inline bool Element::setPosition(int x, int y, int width, int height)
{
	this->x = x;
	this->y = y;
	this->width = width;
	this->height = height;

	return (column == 18);
}

inline bool Element::hitTest(int x, int y)
{
	return (x >= this->x && x <= (this->x + this->width)) && (y >= this->y && y <= (this->y + this->height));
}

inline void Element::select(bool selected) { this->selected = selected; }