package com.worms.financeapp.financialinstrument

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "financial-instrument")
internal data class FinInstrumentPersistence(
    @Id val id: String,
    val simpleName: String
) {
    fun toDomain() = FinInstrument(
        id,
        simpleName
    )
}
