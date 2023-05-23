class Stack // Deck? Other name?
{
    constructor(maxSize_)
    {
        this.maxSize = maxSize_;

        this.cards = [];
    }

    constructor(maxSize_, card_)
    {
        this.maxSize = maxSize_;

        this.cards = [];
        cards[0] = card_;
    }

    constructor(maxSize_, cards_)
    {
        this.maxSize = maxSize_;

        this.cards = [];
        cards = cards_;
    }

    shuffle()
    {
        this.cards[this.cards.maxSize].faceUp = false;
        
        this.cards.sort(() => Math.random() - 0.5);

        this.cards[this.cards.maxSize].faceUp = true;
    }
}