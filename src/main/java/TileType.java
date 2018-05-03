/**
 * This enumeration will show different tile types
 */
public enum TileType {
    Go("Go"),
    FreeParking("FreeParking"),
    Utility("Utility"),
    Station("Station"),
    Property("Property"),
    Jail("Jail"),
    GoToJail("GoToJail"),
    Tax("TaxTile"),
    Card("CardTile");

    private String value;

    TileType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static TileType fromString(String s) {
        for (TileType TileType : TileType.values()) {
            if (TileType.value.equalsIgnoreCase(s)) {
                return TileType;
            }
        }
        throw new IllegalArgumentException("No constant with that text");
    }
}