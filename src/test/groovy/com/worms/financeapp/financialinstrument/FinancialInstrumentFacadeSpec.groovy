package com.worms.financeapp.financialinstrument

import com.worms.financeapp.UnitSpec
import com.worms.financeapp.financialinstrument.dto.FinancialInstrumentResponse

class FinancialInstrumentFacadeSpec extends UnitSpec {

    private FinancialInstrumentFacade instrumentFacade = new FinancialInstrumentConfig().financialInstrumentFacade()

    def "should get empty list of instruments when none was added before"() {
        when:
            Collection<FinancialInstrumentResponse> instruments = instrumentFacade.findAll()

        then:
            instruments != null
            instruments.isEmpty()
    }
}