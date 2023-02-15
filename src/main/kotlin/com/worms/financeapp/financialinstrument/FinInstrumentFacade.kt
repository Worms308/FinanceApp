package com.worms.financeapp.financialinstrument

import com.worms.financeapp.financialinstrument.dto.CreateResult
import com.worms.financeapp.financialinstrument.dto.FinInstrumentPayload
import com.worms.financeapp.financialinstrument.dto.FinInstrumentResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

internal class FinInstrumentFacade(
    private val repository: FinInstrumentRepository
) {
    private var defaultPageSize: Int = 10

    fun findAll(pageable: Pageable?): Page<FinInstrumentResponse> {
        return repository.findAll(pageable ?: Pageable.ofSize(defaultPageSize))
            .map { it.toDomain().toResponse() }
    }

    fun create(finInstrumentPayload: FinInstrumentPayload): CreateResult = try {
        val finInstrument = convertPayloadToDomainObject(finInstrumentPayload)
        val result = repository.save(finInstrument.toPersistence())
        CreateResult.success(result.id)
    } catch (ex: Exception) {
        CreateResult.error(ex.message)
    }

    private fun convertPayloadToDomainObject(finInstrumentPayload: FinInstrumentPayload): FinInstrument {
        val id = UUID.randomUUID().toString()
        return FinInstrument.fromPayload(finInstrumentPayload, id)
    }
}