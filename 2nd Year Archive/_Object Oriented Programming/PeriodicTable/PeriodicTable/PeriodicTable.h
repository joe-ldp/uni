#pragma once
#include "EasyGraphics.h"
#include "Element.h"

class PeriodicTable : public EasyGraphics
{
public:
	PeriodicTable();
	~PeriodicTable();
	
protected:
	virtual void onDraw();
	virtual void onCreate();
	virtual void onSize(UINT nType, int cx, int cy);
	virtual void onLButtonDown(UINT nFlags, int x, int y);

private:
	vector<Element*>* elements;
	Element* selectedElement;

	boxRect infoBox;

};