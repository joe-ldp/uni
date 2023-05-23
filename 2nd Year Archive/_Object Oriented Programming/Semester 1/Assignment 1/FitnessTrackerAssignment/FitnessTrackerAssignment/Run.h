#pragma once
#include "Activity.h"

class Run : public Activity
{
public:
	Run();
	~Run();

	virtual void report() const;
};

