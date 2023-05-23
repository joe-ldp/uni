#pragma once
#include <iostream>

using namespace std;

class Activity
{
public:
	Activity();
	~Activity();

	virtual void report() const = 0;

private:

};

