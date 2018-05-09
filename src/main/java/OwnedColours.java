public enum OwnedColours {
    Brown("#844b4b"),
    Blue("#93acf7"),
    Purple("#ee91f4"),
    Orange("#fdba97"),
    Red("#fb7c7c"),
    Yellow("#f8ed96"),
    Green("#84f382"),
    DeepBlue("#8586fd"),
    Grey("#989797"),
    White("#b8b8b8");

    private String value;

    OwnedColours(final String value) {
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
