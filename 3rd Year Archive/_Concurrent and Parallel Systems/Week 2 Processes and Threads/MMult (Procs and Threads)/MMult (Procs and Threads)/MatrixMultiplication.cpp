// MatrixMultiplication.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <thread>
#include <vector>
#include <string>
#include <mutex>

void multiply(int **a, int **b, int **result, unsigned int r, unsigned int col1, unsigned int col2);
std::mutex mtx;

int main()
{
    unsigned int row1, col1, row2, col2;
    int **a, **b, **result;
    unsigned int i, j;
    std::vector<std::thread> threadHandles;

    std::fstream first("first.txt", std::fstream::in);
    std::fstream second("second.txt", std::fstream::in);
    std::fstream resultFile("result.txt", std::fstream::out);

    if (!first.is_open() || !second.is_open())
    {
        std::cout << "Unable to open input file(s)" << std::endl;
        exit(1);
    }

    first >> row1 >> col1;
    second >> row2 >> col2;

    if (col1 != row2)
    {
        std::cout << "Unable to perform multiplication between a matrix " << row1 << " X " << col1 << " and a matrix " << row2 << " X " << col2 << std::endl;
        exit(1);
    }

    a = new int* [row1];
    for (i = 0; i < row1; i++)
    {
        a[i] = new int[col1];

        for (j = 0; j < col1; j++)
        {
            if (first.eof())
            {
                std::cout << "Unable to read enough data for the first matrix" << std::endl;
                exit(1);
            }
            first >> a[i][j];
        }
    }

    b = new int* [row2];
    for (i = 0; i < row2; i++)
    {
        b[i] = new int[col2];

        for (j = 0; j < col2; j++)
        {
            if (second.eof())
            {
                std::cout << "Unable to read enough data for the second matrix" << std::endl;
                exit(1);
            }
            second >> b[i][j];
        }
    }

    result = new int* [row1];
    for (i = 0; i < row1; i++)
    {
        result[i] = new int[col2];

        for (j = 0; j < col2; j++)
        {
            result[i][j] = 0;
        }
    }

    //multiply!!!
    std::cout << "Perform multiplication" << std::endl;

    for (int c = 0; c < col1; c++)
    {
        threadHandles.emplace_back(multiply, a, b, result, c, col1, row1);
    }

    for (int i = 0; i < col1; i++)
        threadHandles[i].join();

    resultFile << row1 << " " << col2 << std::endl;
    for (i = 0; i < row1; i++)
    {
        for (j = 0; j < col2; j++)
        {
            resultFile << result[i][j] << " ";
        }
        resultFile << std::endl;
    }

    first.close();
    second.close();
    resultFile.close();

    return 0;
}

void multiply(int **a, int **b, int **result, unsigned int c, unsigned int col1, unsigned int row1)
{
    unsigned int i, j;

    for (i = 0; i < col1; i++)
    {
        for (j = 0; j < row1; j++)
        {
            mtx.lock();
            result[i][c] += a[i][c] * b[j][i];
            mtx.unlock();
        }
    }
}