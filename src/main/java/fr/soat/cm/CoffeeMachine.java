package fr.soat.cm;

/**
 * Coffee machine.
 *
 * @author patouche - 4/15/16.
 */
public class CoffeeMachine {


    /**
     * Translate a incoming order into a drink maker protocol string.
     *
     * @param incomingOrder the incoming order
     * @return a string in drink maker protocol
     */
    public String translate(final IncomingOrder incomingOrder) {
        return incomingOrder.getOrderType().getIdentifier()
                + ":"
                + (incomingOrder.getSugarNumber() > 0 ? incomingOrder.getSugarNumber() : "")
                + ":";
    }
}
