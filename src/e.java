
enum SUIT {
    HEART,
    CLUB,
    SPADE,
    DIAMOND
}

enum RANK {
    KING(4),
    JACK(2),
    LADY(3),
    ACE(11),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);
    private int value;
    RANK(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}
