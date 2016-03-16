package fr.soat.cm

import spock.lang.Specification
import spock.lang.Unroll

class CoffeeMachineTest extends Specification {

    @Unroll
    def "drink maker should receive the correct '#instruction.*' for #type"() {
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

}
