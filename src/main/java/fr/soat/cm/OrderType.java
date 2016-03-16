package fr.soat.cm;

/**
 * Type of customer order.
 *
 * @author patouche - 4/15/16.
 */
public enum OrderType {

    /** Coffee type. */
    COFFEE("C"),

    /** Tea type. */
    TEA("T"),

    /** Chocolate type. */
    CHOCOLATE("H");

    /** Order type identifier. */
    private final String identifier;

    /**
     * Enum constructor.
     *
     * @param identifier identifier for drink maker protocol
     */
    OrderType(final String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
