#pragma once
#include <Windows.h>
#include <math.h>

class TurtleCanvas
{
public:
	TurtleCanvas(int width, int height);
	~TurtleCanvas();

	void draw(HDC hdcdst, int x, int y);

	void moveTo(int x, int y);
	void rotate(int degrees);
	void forward(int pixels);
	void backward(int pixels);
	void penUp();
	void penDown();
	void setPenColour(int colour, int thickness);
	void clear(int colour);

protected:


private:
	int angle;
	double x, y;
	bool penup;

	int width, height;

	HDC hdc, hdcturtle;
	HPEN hpen;
	HBITMAP hbmp, hbmpturtle;
	int turtlewidth, turtleheight;

	static double calcRadians(double degrees);
};

inline void TurtleCanvas::setPenColour(int colour, int thickness)
{
	hpen = CreatePen(PS_SOLID, thickness, colour);
	DeleteObject(SelectObject(hdc, hpen));
}

inline void TurtleCanvas::moveTo(int x, int y)
{
	this->x = x + (width / 2.0);
	this->y = y + (height / 2.0);
}

inline void TurtleCanvas::rotate(int degrees)
{
	this->angle += degrees;
}

inline void TurtleCanvas::backward(int pixels)
{
	forward(-pixels);
}

inline void TurtleCanvas::penUp()
{
	this->penup = true;
}

inline void TurtleCanvas::penDown()
{
	this->penup = false;
}

inline double TurtleCanvas::calcRadians(double degrees)
{
	const double CONVERSION = 6.283185307179586 / 360;
	return degrees * CONVERSION;
}