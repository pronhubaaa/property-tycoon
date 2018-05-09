public enum CardType {
    PotLuck("Pot Luck"),
    OpportunityKnocks("Opportunity Knocks");

    private String value;

    CardType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static CardType fromString(String s) {
        for (CardType cardType : CardType.values()) {
            if (cardType.value.equalsIgnoreCase(s)) {
                return cardType;
            }
        }
        throw new IllegalArgumentException("No constant with that text");
    }
}