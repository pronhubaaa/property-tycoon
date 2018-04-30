public enum BoardJsonField {
    Tiles("tiles"),
    Type("type"),
    Name("name"),
    Position("position"),
    Value("value"),
    Group("group"),
    CardType("card_type"),
    Rent("rent"),
    Cost("cost"),
    HouseCost("house"),
    Trade("trade"),
    NumberTurns("number_of_turns"),
    Player("players"),
    Jail("in_jail"),
    Balance("balance"),
    Owned("owned_tiles"),
    Piece("piece"),
    CurrentPlayer("current_player"),
    GameType("game_type"),
    TimeLeft("time_left");

    private String value;

    BoardJsonField(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static BoardJsonField fromString(String s) {
        for (BoardJsonField boardJsonField : BoardJsonField.values()) {
            if (boardJsonField.value.equalsIgnoreCase(s)) {
                return boardJsonField;
            }
        }
        throw new IllegalArgumentException("No constant with that text:" + s);
    }

}
