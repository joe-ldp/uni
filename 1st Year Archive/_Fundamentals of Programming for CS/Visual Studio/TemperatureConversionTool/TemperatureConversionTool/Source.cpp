#include <iostream>
#include <iomanip>
#include <string>

using namespace std;

void TempConv();
int CtoF(int C);
int CtoK(int C);

void ExcSumm();
float metToMiles(int metres);
float calcMph(float miles, int seconds);
int calcPace(int seconds, float miles);

void NumbManip();
int input();

int main()
{
	//TempConv();
	//ExcSumm();
	NumbManip();

	return 0;
}

#pragma region TemperatureConverter

void TempConv()
{
	cout << "Temperature Converter 9000\n";
	cout << "Please input a temperature in Degrees Celcius\n\n";

	int C;
	cin >> C;

	int F = CtoF(C);
	int K = CtoK(C);

	cout << "\n\nThe value in Celcius is: " << C << "\xF8\C";
	cout << "\nThe value in Fahrenheit is: " << F << "\xF8\F";
	cout << "\nThe value in Kelvin is: " << K << "\xF8\K\n\n";
}

int CtoF(int C)
{
	// (°C × 9/5) + 32

	int F = (int) ((C * 9/5) + 32);

	return F;
}

int CtoK(int C)
{
	// °C + 273.15

	int K = C + 273;

	return K;
}

#pragma endregion

#pragma region ExcerciseSummary

void ExcSumm()
{
	cout << "Excercise Summaryinator 9000\n";

	cout << "\nPlease input the distance travelled in whole metres:\n";
	int metres; // whole metres
	cin >> metres;

	cout << "\nPlease input the time taken to travel this distance, in whole seconds:\n";
	int seconds; // whole seconds
	cin >> seconds;

	float miles; // miles to 1dp
	miles = metToMiles(metres);

	//float miles = metToMiles(metres);

	//float miles(metToMiles(metres));


	float mph; // mph to 1dp
	mph = calcMph(miles, seconds);


	int secPerMile = calcPace(seconds, miles);

	int mins = floor(secPerMile / 60);
	int secs = secPerMile % 60;

	//cout << secPerMile << ", " << secPerMile/60 << ", " << floor(secPerMile/60) << ", " << mins << ", " << secs;

	cout << "\n\nDistance in miles (1dp): " << setprecision(2) << miles << "\n";
	cout << "Average speed in miles per hour: " << setprecision(2) << mph << "\n";
	cout << "Average pace in minutes and seconds per mile: " << mins << "m" << secs << "s per mile\n\n";
}

float metToMiles(int metres)
{
	//return metres / 1609.344f;
	return (5 * (metres / 1000.0f)) / 8;
}

float calcMph(float miles, int seconds)
{
	double hours = seconds / 3600.0; // use a double for greater accuracy ?

	//cout << miles << ", " << seconds << ", " << hours; // debug

	return miles / hours;
}

int calcPace(int seconds, float miles)
{
	int secPerMile = seconds / miles;
	//cout << secPerMile;
	return secPerMile;
}

#pragma endregion

#pragma region NumberManipulation

void NumbManip()
{
	cout << "Number Manipulator 9000\n";
	
	int theNumber = input();

	cout << "The number: " << theNumber;


}

int input()
{
	cout << "Please enter a 4-digit whole number:\n";

	int theNumber;
	cin >> theNumber;

	if (theNumber >= 1000 && theNumber <= 9999)
	{

	}
	else
	{
		theNumber = input();
	}

	return theNumber;
}

#pragma endregion