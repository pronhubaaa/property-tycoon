public enum CardActionType {
    Draw("draw"),
    GetOutOfJailFree("get out of jail free"),
    Move("move"),
    Transaction("transaction");

    private String value;

    CardActionType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static CardActionType fromString(String s) {
        for (CardActionType actionType : CardActionType.values()) {
            if (actionType.value.equalsIgnoreCase(s)) {
                return actionType;
            }
        }
        throw new IllegalArgumentException("No constant with that text " + s);
    }
}
