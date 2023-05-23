#include "Block.h"

Block::Block(int x, int y, int width, int height, int row) : health(1), width(width), height(height), x(x), y(y), colour(colours[row])
{
	this->hitBox = RECT{ x, y, x + width, y + height };
}

Block::~Block()
{

}

void Block::draw(EasyGraphics* canvas)
{
	canvas->setBackColour(colour);
	canvas->setPenColour(colour, 1);
	canvas->drawRectangle(x + 5, y, width, height, true);
}

void Block::initialiseBlocks(vector<vector<Block*>*> &blocks, int width, int height)
{
	const int NUM_ROWS = 5;
	const int ROW_BLOCKS = 10;
	const int PAD = 5;
	const int BLOCK_WIDTH = (width / ROW_BLOCKS) - PAD;
	const int BLOCK_HEIGHT = height / (NUM_ROWS * 2);

	int x, y = BLOCK_HEIGHT;

	for (int rowNum = 1; rowNum <= NUM_ROWS; rowNum++) // 5 rows
	{
		x = 0;
		vector<Block*>* row = new vector<Block*>;
		for (int blockNum = 1; blockNum <= ROW_BLOCKS; blockNum++) // 10 "columns" (blocks per row)
		{
			Block* block = new Block(x, y, BLOCK_WIDTH, BLOCK_HEIGHT, rowNum - 1);
			x += BLOCK_WIDTH + PAD;
			row->push_back(block);
		}
		y += BLOCK_HEIGHT + PAD;
		blocks.push_back(row);
	}
}
