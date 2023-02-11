package com.worms.financeapp.financialinstrument

import org.springframework.context.annotation.Configuration

@Configuration
internal class FinancialInstrumentConfig {

    fun financialInstrumentFacade(): FinancialInstrumentFacade {
        val repository = InMemoryFinancialInstrumentRepository()
        return FinancialInstrumentFacade(repository)
    }
}