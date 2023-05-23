#include "Ball.h"

Ball* Ball::instance = nullptr;

Ball::Ball() : x(400), y(400), dx(8), dy(8), radius(10)
{

}

Ball::~Ball()
{

}

void Ball::draw(EasyGraphics* canvas)
{
	canvas->setBackColour(EasyGraphics::WHITE);
	canvas->setPenColour(EasyGraphics::WHITE, 1);
	canvas->drawCircle(x, y, radius, true);
}

void Ball::move()
{
	x += dx;
	y += dy;
	hitBox = RECT{ instance->x - 5, instance->y - 5, instance->x + 5, instance->y + 5 };
}

void Ball::bounce(int axis)
{
	if (axis == 1) dx *= -1;
	if (axis == 2) dy *= -1;
}

Ball *Ball::getInstance()
{
	if (instance == nullptr)
	{
		instance = new Ball();
		instance->hitBox = RECT{ instance->x - 5, instance->y - 5, instance->x + 5, instance->y + 5 };
	}
	return instance;
}