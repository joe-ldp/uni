#include "TwentyQuestions.h"
#include "Addition.h"
#include <time.h>

TwentyQuestions::TwentyQuestions()
{

}

TwentyQuestions::~TwentyQuestions()
{

}

void TwentyQuestions::playGame()
{
    srand((int)time(NULL));

    Question* questions[NO_OF_QUESTIONS];
    for (int i = 0; i < NO_OF_QUESTIONS; i++)
    {
        if (rand() < (RAND_MAX / 2))
            questions[i] = new Addition();
        //    else
        //      questions[i]=new Subtraction();

        cout << "Question " << (i + 1) << ": ";
        questions[i]->displayQuestion();
        questions[i]->readAnswer();
    }

    int correct = 0;
    for (int i = 0; i < NO_OF_QUESTIONS; i++)
    {
        // and then do the list of correct answers
        if (questions[i]->isCorrect())
            ++correct;
    }

    for (int i = 0; i < NO_OF_QUESTIONS; i++)
    {
        // and then do the list of wrong answers with solutions
    }

    cout << "You scored " << correct << " out of " << NO_OF_QUESTIONS;

    for (int i = 0; i < NO_OF_QUESTIONS; i++)
        delete questions[i];
}