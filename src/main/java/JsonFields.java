public enum JsonFields {
    Tile("tile"),
    Type("type"),
    Name("name"),
    Position("position"),
    Value("value"),
    Group("group"),
    CardType("cardType"),
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

    JsonFields(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
