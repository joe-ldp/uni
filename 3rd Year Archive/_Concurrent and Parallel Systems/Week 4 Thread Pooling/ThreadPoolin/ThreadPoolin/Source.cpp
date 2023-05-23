// MatrixMultiplication.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <fstream>
#include <thread>
#include <windows.h>
#include <string>
#include <vector>
#include <mutex>

#include "ThreadPool.hpp"

int multiply(int** a, int** b, int** result, unsigned int r, unsigned int col1, unsigned int col2);
double GetElapsedMs(LARGE_INTEGER& startTime);
void GenMatrices(unsigned int size);
std::mutex mtx;

int main()
{
    std::srand(std::time(nullptr));
    unsigned int row1, col1, row2, col2;
    int** a, ** b, ** result;
    unsigned int i, j, k;
    LARGE_INTEGER startTime;

    std::fstream first("first.txt", std::fstream::in);
    std::fstream second("second.txt", std::fstream::in);
    std::fstream resultFile("result.txt", std::fstream::out);

    GenMatrices(132);

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

    const int NUM_THREADS = 8;
    ThreadPool pool(NUM_THREADS);
    std::future<int>* values = new std::future<int>[col1];

    //multiply!!!
    std::cout << "Perform multiplication" << std::endl;

    QueryPerformanceCounter(&startTime);

    for (int c = 0; c < col1; c++)
    {
        values[c] = pool.enqueue(multiply, a, b, result, c, col1, row1);
    }

    for (int c = 0; c < col1; c++)
    {
        values[c].get();
    }

    //for (i = 0; i < row1; i++)
    //{
    //    for (j = 0; j < col2; j++)
    //    {
    //        for (k = 0; k < col1; k++)
    //        {
    //            result[i][j] += a[i][k] * b[k][j];
    //        }
    //    }
    //}

    double ms = GetElapsedMs(startTime);
    std::cout << "Calculation took " << ms << " milliseconds" << std::endl;

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

int multiply(int** a, int** b, int** result, unsigned int c, unsigned int col1, unsigned int row1)
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

    return 0;
}

void GenMatrices(unsigned int size)
{
    const int MAX = 200;
    int** m1, ** m2;
    m1 = new int* [size];
    m2 = new int* [size];

    for (unsigned int r = 0; r < size; r++)
    {
        m1[r] = new int[size];
        m2[r] = new int[size];

        for (unsigned int c = 0; c < size; c++)
        {
            m1[r][c] = (rand() / ((RAND_MAX + 1u) / (MAX * 2))) - MAX;
            m2[r][c] = (rand() / ((RAND_MAX + 1u) / (MAX * 2))) - MAX;
        }
    }

    std::fstream file1("first.txt", std::fstream::out);
    std::fstream file2("second.txt", std::fstream::out);

    file1 << size << " " << size << std::endl;
    file2 << size << " " << size << std::endl;

    for (unsigned int i = 0; i < size; i++)
    {
        for (unsigned int j = 0; j < size; j++)
        {
            file1 << m1[i][j] << " ";
            file2 << m1[i][j] << " ";
        }
        file1 << std::endl;
        file2 << std::endl;
    }
}

double GetElapsedMs(LARGE_INTEGER& startTime)
{
    LARGE_INTEGER endTime, elapsed, frequency;

    QueryPerformanceCounter(&endTime);

    if (!QueryPerformanceFrequency(&frequency))
        std::cout << "QueryPerformanceFrequency failed!\n";
    frequency.QuadPart /= 1000.0;

    elapsed.QuadPart = endTime.QuadPart - startTime.QuadPart;
    elapsed.QuadPart /= frequency.QuadPart;
    return elapsed.QuadPart;
}