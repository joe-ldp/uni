#pragma once

class FitnessTracker
{
public:
	FitnessTracker();
	~FitnessTracker();

	int totalTimeSpent;

protected:
	int totalCaloriesBurnt;

private:

	int totalDistanceTravelled;
	int totalStepCount;
};

