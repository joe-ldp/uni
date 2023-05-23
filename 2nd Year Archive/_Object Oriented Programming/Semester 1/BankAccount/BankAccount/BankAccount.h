#pragma once

#include <string>

using namespace std;

class BankAccount
{
public:
	BankAccount(unsigned long accountNumber, string customerName, int balance);
	~BankAccount();

	int getBalance() const;
	string getCustomerName() const;
	bool withdraw(int amount);
	bool deposit(int amount);

private:
	unsigned long accountNumber;
	string customerName;
	int balance;  // in pence
};

