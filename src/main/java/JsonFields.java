public enum JsonFields {
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
    TimeLeft("time_left"),

    Cards("cards"),
    Description("desc"),
    CardActionType("action_type"),
    Origin("origin"),
    Intent("intent"),
    CollectSalary("collect_salary"),
    CardValue("value"),
    AmountHouse("amount_house"),
    AmountHotel("amount_hotel");




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
