public enum Colour {

    // Insert Hex codes within the String
    // You can access these by using the toString method
    Brown(""),
    Blue(""),
    Purple(""),
    Orange(""),
    Red(""),
    Yellow(""),
    Green(""),
    DeepBlue(""),
    White("");


    private String value;

    Colour(final String value) {
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