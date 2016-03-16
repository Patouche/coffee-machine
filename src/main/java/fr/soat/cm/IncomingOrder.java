package fr.soat.cm;

/**
 * Incoming order bean to describe a client order.
 *
 * @author patouche - 4/15/16.
 */
public class IncomingOrder {

    /** The order type. */
    private OrderType orderType;

    /** The sugar number. */
    private int sugarNumber = 0;

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public int getSugarNumber() {
        return sugarNumber;
    }

    public void setSugarNumber(int sugarNumber) {
        this.sugarNumber = sugarNumber;
    }
}
