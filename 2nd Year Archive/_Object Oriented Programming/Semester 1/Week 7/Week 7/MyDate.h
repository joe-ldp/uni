#pragma once
class MyDate
{
public:
  MyDate();
  MyDate(const int day, const int month, const int year);
  ~MyDate();

  void setDate(const int day, const int month, const int year);
  int getDay() const;
  int getMonth() const;
  int getYear() const;

private:
  int day, month, year;
};

inline MyDate::MyDate() : day(0), month(0), year(0) {}
inline MyDate::MyDate(const int day, const int month, const int year):day(day), month(month), year(year) {}

inline MyDate::~MyDate() {}

inline void MyDate::setDate(const int day, const int month, const int year)
{
  this->day=day;
  this->month=month;
  this->year=year;
}

inline int MyDate::getDay() const { return day; }
inline int MyDate::getMonth() const { return month; }
inline int MyDate::getYear() const { return year; }
