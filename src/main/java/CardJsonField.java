public enum CardJsonField {
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

    CardJsonField(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static CardJsonField fromString(String s) {
        for (CardJsonField cardJsonField : CardJsonField.values()) {
            if (cardJsonField.value.equalsIgnoreCase(s)) {
                return cardJsonField;
            }
        }
        throw new IllegalArgumentException("No constant with that text:" + s);
    }

}
