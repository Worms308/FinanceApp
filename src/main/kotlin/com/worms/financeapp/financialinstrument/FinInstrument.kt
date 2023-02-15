package com.worms.financeapp.financialinstrument

import com.worms.financeapp.financialinstrument.dto.FinInstrumentPayload
import com.worms.financeapp.financialinstrument.dto.FinInstrumentResponse

internal data class FinInstrument(
    val id: String,
    val simpleName: String
) {
    fun toResponse() = FinInstrumentResponse(
        id,
        simpleName
    )

    fun toPersistence() = FinInstrumentPersistence(
        id,
        simpleName
    )

    companion object {
        fun fromPayload(payload: FinInstrumentPayload, uuid: String): FinInstrument {
            return FinInstrument(
                uuid,
                payload.simpleName
            )
        }
    }
}
