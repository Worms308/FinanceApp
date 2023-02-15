package com.worms.financeapp.financialinstrument

import com.worms.financeapp.UnitSpec
import com.worms.financeapp.financialinstrument.dto.FinInstrumentPayload
import com.worms.financeapp.financialinstrument.dto.FinInstrumentResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

class FinInstrumentFacadeSpec extends UnitSpec {

    private FinInstrumentFacade instrumentFacade = new FinInstrumentConfig().financialInstrumentFacade()

    def "should get empty list of instruments when none was added before"() {
        given:
            def pageable = PageRequest.of(0, 10)

        when:
            Page<FinInstrumentResponse> instruments = instrumentFacade.findAll(pageable)

        then:
            instruments != null
            instruments.isEmpty()
    }

    def "should create new instrument to the repository"() {
        given:
            def instrument = buildDefaultFinInstrumentPayload()

        when:
            def result = instrumentFacade.create(instrument)

        then:
            result.isOk()
            result.entityId != null
    }

    private FinInstrumentPayload buildDefaultFinInstrumentPayload() {
        new FinInstrumentPayload("Test instrument")
    }
}