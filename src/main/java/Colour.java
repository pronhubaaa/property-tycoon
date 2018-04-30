public enum Colour {

    // Insert Hex codes within the String
    // You can access these by using the toString method
    Brown("#500707"),
    Blue("#5f84f4"),
    Purple("#eb5af5"),
    Orange("#fd8b4f"),
    Red("#f75555"),
    Yellow("#f6e454"),
    Green("#53fb50"),
    DeepBlue("#4e50fd"),
    Grey("#4d4d4d"),
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