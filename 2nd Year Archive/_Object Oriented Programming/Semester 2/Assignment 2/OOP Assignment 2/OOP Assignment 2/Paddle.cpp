#include "Paddle.h"

Paddle* Paddle::instance = nullptr;


Paddle::Paddle() : x(400)
{

}

Paddle::~Paddle()
{

}

void Paddle::draw(EasyGraphics* canvas)
{
	canvas->setBackColour(EasyGraphics::BLACK);
	canvas->setPenColour(EasyGraphics::BLACK, 1);
	canvas->drawRectangle(0, y, 800, PADDLE_HEIGHT, true);

	canvas->setBackColour(EasyGraphics::WHITE);
	canvas->setPenColour(EasyGraphics::WHITE, 1);
	canvas->drawRectangle(x, y, PADDLE_WIDTH, PADDLE_HEIGHT, true);
}

Paddle *Paddle::getInstance()
{
	if (instance == nullptr)
	{
		instance = new Paddle();
		instance->hitBox = RECT{ instance->x, instance->y, instance->x + instance->PADDLE_WIDTH, instance->y + instance->PADDLE_HEIGHT };
	}
	return instance;
}

void Paddle::updatePos(int x, int max)
{
	this->x = x - (PADDLE_WIDTH / 2);

	if (this->x < 0) this->x = 0;
	if (this->x + PADDLE_WIDTH > max) this->x = max - PADDLE_WIDTH;

	this->hitBox.left = this->x;
	this->hitBox.right = this->x + PADDLE_WIDTH;
}