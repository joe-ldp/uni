#include "TurtleWindow.h"

TurtleWindow::TurtleWindow() : turtle(nullptr)
{
	setImmediateDrawMode(false);
	commands = new CommandList(L"commands.txt");
}

TurtleWindow::~TurtleWindow()
{

}

void TurtleWindow::onCreate()
{
	EasyGraphics::onCreate();

	::SetWindowText(getHWND(), L"OOP4CS: Turtle Drawing");
}

void TurtleWindow::onDraw()
{
	clearScreen(WHITE);

	turtle->draw(getBackBuffer(), 0, 0);

	EasyGraphics::onDraw();
}

void TurtleWindow::onSize(UINT nType, int cx, int cy)
{
	EasyGraphics::onSize(nType, cx, cy);

	if (turtle == nullptr && cx != 0 && cy != 0)
	{
		turtle = new TurtleCanvas(cx, cy);
	}
}