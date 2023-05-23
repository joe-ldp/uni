#pragma once
#include "Activity.h"

class Walk : public Activity
{
public:
	Walk();
	~Walk();

	virtual void report() const;
};

