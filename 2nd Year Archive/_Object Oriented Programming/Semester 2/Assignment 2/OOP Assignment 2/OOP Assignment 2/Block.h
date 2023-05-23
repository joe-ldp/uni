#pragma once
#include "EasyGraphics.h"
#include <vector>

using namespace std;

class Block
{
public:
	Block(int x, int y, int width, int height, int row);
	~Block();

	void draw(EasyGraphics* canvas);

	static void initialiseBlocks(vector<vector<Block*>*> &blocks, int numCols, int numRows);
	RECT getHitBox();
	bool destroyed();
	void hit();

private:
	int x, y, width, height, health, colour;

	static constexpr int colours[] = { EasyGraphics::RED, 0x00005AFF, EasyGraphics::YELLOW, EasyGraphics::DARK_GREEN, EasyGraphics::BLUE };

	RECT hitBox;
};

inline RECT Block::getHitBox() { return hitBox; }

inline bool Block::destroyed() { return health <= 0; }

inline void Block::hit() { health--; }