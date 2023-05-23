#include "BankAccount.h"

BankAccount::BankAccount(unsigned long accountNumber, string customerName, int balance)
{
	this->accountNumber = accountNumber;
	this->customerName = customerName;
	this->balance = balance;
}

BankAccount::~BankAccount()
{

}

int BankAccount::getBalance() const { return balance; }

string BankAccount::getCustomerName() const { return customerName; }

bool BankAccount::withdraw(int pence)
{
	if (balance - pence >= 0)
	{
		balance -= pence;
		return true;
	}
	else
	{
		return false;
	}
}

bool BankAccount::deposit(int pence)
{
	if (pence >= 0)
	{
		balance += pence;
		return true;
	}
	else
	{
		return false;
	}
}