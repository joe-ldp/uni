class Card
{
    constructor(suite_, isRed_, val_, faceUp_)
    {
        this.suite = suite_;
        this.isRed = isRed_;
        this.val = val_;
        this.faceUp = faceUp_;
        this.area = 1; //1234
    }
    
    canStackOn(card)
    {
        switch(card.area)
        {
            case 3:
            {
                if (this.isRed == !card.isRed && this.val == (card.val - 1))
                {
                    return true;
                }
                else
                {
                    return false;
                }
                break;
            }
            case 4:
            {
                if (this.suite == card.suite && this.val == (card.val + 1))
                {
                    return true;
                }
                else
                {
                    return false;
                }
                break;
            }
        }
        
    }

    isValidMove(faceUpCards)
    {
        faceUpCards.array.forEach(card => {
            if (this.canStackOn(card))
            {
                return true;
            }
        });

        return false;
    }
}