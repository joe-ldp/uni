#include <iostream>
#include <string>

using namespace std;

float[] Multiply(float[] a, float[] b);
float[] Delcare(float[] item);

int main()
{
	float[] matrixA = new float[0];
	float[] matrixB = new float[0];

	matrixA = Declare(matrixA);
	matrixB = Declare(matrixB);

	float[] ans = Multiply(matrixA, matrixB);

	for (int i = 0; i < ans.GetLength(0); i++)
	{
		for (int j = 0; j < ans.GetLength(1); j++)
		{
			cout << (ans[i, j]) << ", ";
		}
		cout << "\n";
	}

	system("pause");
	return 0;
}

int ay = 0;
//int AY{ get = > ay++; set = > ay = value; }

int bx = 0;
//int BX{ get = > bx++; set = > bx = value; }

float[] Multiply(float[] a, float[] b)
{
	float[, ] result = new float[a.GetLength(0), b.GetLength(1)];
	int rx = 0;
	int ry = 0;

	for (int ax = 0; ax < result.GetLength(0); ax++)
	{
		for (int by = 0; by < result.GetLength(1); by++)
		{
			float tot = 0;

			for (int i = 0; i < a.GetLength(1); i++)
			{
				tot += a[ax, ++ay/*AY*/] * b[/*BX*/++bx, by];
			}
			AY = 0; BX = 0;

			result[rx, ry] = tot;
			ry++;
		}
		ry = 0;
		rx++;
	}

	return result;
}

float[] Declare(float[, ] item)
{
	cout << "Matrix size x:\n";
	string sizeX;
	cin >> sizeX;

	cout << "Matrix size y:\n";
	string sizeY;
	cin >> sizeY;

	try { item = new float[int.Parse(sizeX), int.Parse(sizeY)]; }
	catch { Declare(item); }

	for (int x = 0; x < item.GetLength(0); x++)
	{
		for (int y = 0; y < item.GetLength(1); y++)
		{
			cout << "Enter value for position {0}, {1}", x + 1, y + 1);
			item[x, y] = float.Parse(cin));
		}
	}

	for (int i = 0; i < item.GetLength(0); i++)
	{
		for (int j = 0; j < item.GetLength(1); j++)
		{
			cout << item[i, j << ", ";
		}
		cout << "\n";
	}

	return item;
}