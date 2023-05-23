struct Region
{
	bool initiated = false;

	Region(int xPos_, int yPos_, int xSize_, int ySize_)
	{
		xPos = xPos_;
		yPos = yPos_;
		xSize = xSize_;
		ySize = ySize_;

		initiated = true;
	}

	Region()
	{
		xPos = 0; yPos = 0; xSize = 0; ySize = 0;
	}

	int xPos;
	int yPos;

	int xSize;
	int ySize;
};

struct Coords
{
	Coords(int x_, int y_)
	{
		x = x_;
		y = y_;
	}

	Coords()
	{

	}

	bool isWithin(Region r)
	{
		if (x >= r.xPos && y >= r.ySize)
		{
			if (x <= r.xPos + r.xPos && y <= r.yPos + r.ySize)
			{
				return true;
			}
		}
		return false;
	}

	int x;
	int y;
};