package com.worms.financeapp.financialinstrument

import com.worms.financeapp.financialinstrument.dto.FinancialInstrumentResponse
import java.util.UUID

internal data class FinancialInstrument (
    val id: UUID
) {
    fun toResponse() = FinancialInstrumentResponse(
        id
    )
}
