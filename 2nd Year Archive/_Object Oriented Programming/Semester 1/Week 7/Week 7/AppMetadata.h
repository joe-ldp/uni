#pragma once
#include <string>
#include "MyDate.h"

using namespace std;

class AppMetadata
{
public:
  AppMetadata(const AppMetadata& rhs);
  AppMetadata(const string appname, const int diskspace, const MyDate& installed, const MyDate& lastaccessed);
  ~AppMetadata();

  const string getAppName() const;
  const int getDiskSpace() const;
  const MyDate& getInstalled() const;
  const MyDate& getLastAccessed() const;

  const AppMetadata& operator=(const AppMetadata& rhs);

public:
  int created;
  string appname;
  int diskspace;
  MyDate installed, lastaccessed;

  static int createcount;
};

inline AppMetadata::AppMetadata(const AppMetadata& rhs) : appname(rhs.appname), diskspace(rhs.diskspace), installed(rhs.installed), lastaccessed(rhs.lastaccessed), created(++createcount)
{}

inline AppMetadata::AppMetadata(const string appname, const int diskspace, const MyDate& installed, const MyDate& lastaccessed) : appname(appname), diskspace(diskspace), installed(installed), lastaccessed(lastaccessed), created(++createcount)
{
  this->diskspace++;
}

inline AppMetadata::~AppMetadata() {}

inline const string AppMetadata::getAppName() const { return appname; }
inline const int AppMetadata::getDiskSpace() const { return diskspace; }
inline const MyDate& AppMetadata::getInstalled() const { return installed; }
inline const MyDate& AppMetadata::getLastAccessed() const { return lastaccessed; }

inline const AppMetadata& AppMetadata::operator=(const AppMetadata& rhs)
{
  if (this!=&rhs)
  {
    created=++createcount;
    appname=rhs.appname;
    diskspace=rhs.diskspace;
    installed=rhs.installed;
    lastaccessed=rhs.lastaccessed;

  }
  return *this;
}