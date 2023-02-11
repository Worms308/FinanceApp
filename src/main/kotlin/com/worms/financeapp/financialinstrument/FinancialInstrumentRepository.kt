package com.worms.financeapp.financialinstrument

import org.springframework.data.repository.Repository
import java.util.UUID

internal interface FinancialInstrumentRepository : Repository<UUID, FinancialInstrument> {

    fun findAll(): Collection<FinancialInstrument>
}

internal class InMemoryFinancialInstrumentRepository: FinancialInstrumentRepository {

    private val map = mutableMapOf<UUID, FinancialInstrument>()
    override fun findAll(): Collection<FinancialInstrument> {
        return map.values
    }

}