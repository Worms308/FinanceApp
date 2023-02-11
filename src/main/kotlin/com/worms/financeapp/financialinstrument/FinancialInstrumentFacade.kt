package com.worms.financeapp.financialinstrument

import com.worms.financeapp.financialinstrument.dto.FinancialInstrumentResponse

internal class FinancialInstrumentFacade(
    private val repository: FinancialInstrumentRepository
) {

    fun findAll(): Collection<FinancialInstrumentResponse> {
        return repository.findAll()
            .map { it.toResponse() }
    }
}