#include "Question.h"

Question::Question() : userAns(999999)
{
	op1 = generateRandOp();
	op2 = generateRandOp();
}

Question::~Question()
{

}