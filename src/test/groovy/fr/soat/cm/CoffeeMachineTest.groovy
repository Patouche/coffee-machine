package fr.soat.cm

import spock.lang.Specification
import spock.lang.Unroll

class CoffeeMachineTest extends Specification {

    @Unroll
    def "drink maker should receive the correct '#instruction' for #type"() {
        given:
            def incomingOrder = new IncomingOrder()
            incomingOrder.setOrderType(type)
        when:
            def result = new CoffeeMachine().translate(incomingOrder);
        then:
            result.startsWith(instruction)
        where:
            type                || instruction
            OrderType.COFFEE    || "C"
            OrderType.TEA       || "T"
            OrderType.CHOCOLATE || "H"
    }

    @Unroll
    def "send '#instruction' to the drink maker to add #sugarNumber sugars for #type"() {
        given:
            def incomingOrder = new IncomingOrder()
            incomingOrder.setOrderType(type)
            incomingOrder.setSugarNumber(sugarNumber)
        when:
            def result = new CoffeeMachine().translate(incomingOrder);
        then:
            result.startsWith(instruction)
        where:
            type                || sugarNumber || instruction
            OrderType.COFFEE    || 0           || "C::"
            OrderType.COFFEE    || 1           || "C:1:"
            OrderType.COFFEE    || 2           || "C:2:"
            OrderType.TEA       || 0           || "T::"
            OrderType.TEA       || 1           || "T:1:"
            OrderType.TEA       || 2           || "T:2:"
            OrderType.CHOCOLATE || 0           || "H::"
            OrderType.CHOCOLATE || 1           || "H:1:"
            OrderType.CHOCOLATE || 2           || "H:2:"
    }

    @Unroll
    def "order contains #sugarNumber sugar the drink maker should add a stick for #type"() {
        given:
            def incomingOrder = new IncomingOrder()
            incomingOrder.setOrderType(type)
            incomingOrder.setSugarNumber(sugarNumber)
        when:
            def result = new CoffeeMachine().translate(incomingOrder);
        then:
            result == instruction
        where:
            type                || sugarNumber || instruction
            OrderType.COFFEE    || 0           || "C::"
            OrderType.COFFEE    || 1           || "C:1:0"
            OrderType.COFFEE    || 2           || "C:2:0"
            OrderType.TEA       || 0           || "T::"
            OrderType.TEA       || 1           || "T:1:0"
            OrderType.TEA       || 2           || "T:2:0"
            OrderType.CHOCOLATE || 0           || "H::"
            OrderType.CHOCOLATE || 1           || "H:1:0"
            OrderType.CHOCOLATE || 2           || "H:2:0"
    }

}
