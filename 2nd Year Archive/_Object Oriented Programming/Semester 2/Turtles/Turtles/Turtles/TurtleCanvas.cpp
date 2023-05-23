#include "TurtleCanvas.h"

TurtleCanvas::TurtleCanvas(int width, int height) : width(width), height(height), x(0), y(0), angle(0), penup(false), hpen(0)
{
	BITMAPINFO backbmpinfo;
	backbmpinfo.bmiHeader.biSize = sizeof(BITMAPINFO);
	backbmpinfo.bmiHeader.biWidth = width;
	backbmpinfo.bmiHeader.biHeight = height;
	backbmpinfo.bmiHeader.biPlanes = 1;
	backbmpinfo.bmiHeader.biBitCount = 32;
	backbmpinfo.bmiHeader.biCompression = BI_RGB;
	backbmpinfo.bmiHeader.biSizeImage = backbmpinfo.bmiHeader.biWidth * backbmpinfo.bmiHeader.biHeight * backbmpinfo.bmiHeader.biBitCount / 8;
	backbmpinfo.bmiHeader.biXPelsPerMeter = 0;
	backbmpinfo.bmiHeader.biYPelsPerMeter = 0;
	backbmpinfo.bmiHeader.biClrUsed = 0;
	backbmpinfo.bmiHeader.biClrImportant = 0;

	HDC hdcsrc = ::GetDC(NULL);
	hbmp = CreateDIBSection(hdcsrc, &backbmpinfo, DIB_RGB_COLORS, NULL, NULL, NULL);
	hdc = CreateCompatibleDC(hdcsrc);

	if (hbmp && hdc)
		SelectObject(hdc, hbmp);

	hbmpturtle = (HBITMAP)LoadImage(NULL, L"turtle.bmp", IMAGE_BITMAP, 0, 0, LR_CREATEDIBSECTION | LR_LOADFROMFILE);
	if (hbmpturtle)
	{
		BITMAP info;
		GetObject(hbmpturtle, sizeof(BITMAP), &info);
		turtlewidth = info.bmWidth;
		turtleheight = info.bmHeight;

		hdcturtle = CreateCompatibleDC(hdcsrc);
		SelectObject(hdcturtle, hbmpturtle);
	}
	ReleaseDC(NULL, hdcsrc);

	clear(0x00FFFFFF);
	setPenColour(0x0, 2);
	moveTo(0, 0);
}

TurtleCanvas::~TurtleCanvas()
{
	DeleteObject(hbmp);
	DeleteDC(hdc);

	if (hbmpturtle)
	{
		DeleteObject(hbmpturtle);
		DeleteDC(hdcturtle);
	}

	if (hpen)
		DeleteObject(hpen);
}

void TurtleCanvas::clear(int colour)
{
	RECT rect = { 0, 0, width, height };
	LOGBRUSH logbrush = { BS_SOLID, colour, NULL };
	HBRUSH hbrush = CreateBrushIndirect(&logbrush);

	FillRect(hdc, &rect, hbrush);

	DeleteObject(hbrush);
}

void TurtleCanvas::forward(int pixels)
{
	double rads = calcRadians(angle);

	double dx = pixels * sin(rads);
	double dy = -pixels * cos(rads);

	if (!penup)
	{
		MoveToEx(hdc, (int)x, (int)y, NULL);
		LineTo(hdc, (int)(x + dx), (int)(y + dy));
	}

	x += dx;
	y += dy;
}

void TurtleCanvas::draw(HDC hdcdst, int x, int y)
{
	BitBlt(hdcdst, x, y, width, height, hdc, 0, 0, SRCCOPY);

	double rads = calcRadians(angle);

	XFORM xform;
	::SetGraphicsMode(hdcdst, GM_ADVANCED);
	xform.eM11 = (float)cos(rads);
	xform.eM12 = (float)sin(rads);
	xform.eM21 = -xform.eM12;
	xform.eM22 = xform.eM11;
	xform.eDx = x + this->x;
	xform.eDy = y + this->y;
	SetWorldTransform(hdcdst, &xform);

	TransparentBlt(hdcdst, -turtlewidth / 2, -turtleheight / 2, turtlewidth, turtleheight, hdcturtle, 0, 0, turtlewidth, turtleheight, 0x00FFFFFF);

	::ModifyWorldTransform(hdcdst, NULL, MWT_IDENTITY);
	::SetGraphicsMode(hdcdst, GM_COMPATIBLE);
}