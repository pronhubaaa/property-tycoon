public enum JsonField {
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

    // cards.json
    Cards("cards"),
    Description("desc"),
    CardActionType("action_type"),
    Origin("origin"),
    Intent("intent"),
    CollectSalary("collect_salary"),
    CardValue("value"),
    AmountHouse("amount_house"),
    AmountHotel("amount_hotel"),

    // action entities
    FreeParkingIntentEntity("free parking"),
    JailIntentEntity("jail"),
    PlayerIntentEntity("player"),
    PayableListIntentEntity("each player"),
    PotLuckIntentEntity("pot luck"),
    OpportunityKnocksIntentEntity("opportunity knocks");


    private String value;

    JsonField(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static JsonField fromString(String s) {
        for (JsonField jsonField : JsonField.values()) {
            if (jsonField.value.equalsIgnoreCase(s)) {
                return jsonField;
            }
        }
        throw new IllegalArgumentException("No constant with that text:" + s);
    }

}
