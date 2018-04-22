public enum CardType {
    PlotLuck("Plot Luck"),
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
}
