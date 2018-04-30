public enum Colour {

    // Insert Hex codes within the String
    // You can access these by using the toString method
    Brown("Brown"),
    Blue("Blue"),
    Purple("Purple"),
    Orange("Orange"),
    Red("Red"),
    Yellow("Yellow"),
    Green("Green"),
    DeepBlue("Deep Blue"),
    White("White");


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

    public static Colour fromString(String s) {
        for (Colour colour : Colour.values()) {
            if (colour.value.equalsIgnoreCase(s)) {
                return colour;
            }
        }
        throw new IllegalArgumentException("No constant with that text");
    }
}