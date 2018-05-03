public enum PlayerPiece {
    Phone(1),
    Boot(2),
    Trophy(3),
    Cat(4),
    Spoon(5),
    HatStand(6);

    private int value;

    PlayerPiece(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int toInt() {
        return this.getValue();
    }

    public String toString() {
        return "" + this.getValue();
    }

    public static PlayerPiece fromInt(int i) {
        for (PlayerPiece PlayerPiece : PlayerPiece.values()) {
            if (PlayerPiece.value == i) {
                return PlayerPiece;
            }
        }
        throw new IllegalArgumentException("No constant with that text");
    }
}