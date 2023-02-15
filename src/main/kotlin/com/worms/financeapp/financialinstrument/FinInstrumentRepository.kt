package com.worms.financeapp.financialinstrument

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.data.repository.Repository

internal interface FinInstrumentRepository : Repository<FinInstrumentPersistence, String> {

    fun findAll(pageable: Pageable): Page<FinInstrumentPersistence>

    fun save(finInstrumentPersistence: FinInstrumentPersistence): FinInstrumentPersistence
}

@Suppress("unused")
@org.springframework.stereotype.Repository
internal interface ElasticFinInstrumentRepository : ElasticsearchRepository<FinInstrumentPersistence, String>, FinInstrumentRepository

internal class InMemoryFinInstrumentRepository : FinInstrumentRepository {

    private val map = mutableMapOf<String, FinInstrumentPersistence>()
    override fun findAll(pageable: Pageable): Page<FinInstrumentPersistence> {
        return PageImpl(map.values.stream()
            .skip(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .toList()
        )
    }

    override fun save(finInstrumentPersistence: FinInstrumentPersistence): FinInstrumentPersistence {
        map[finInstrumentPersistence.id] = finInstrumentPersistence
        return map[finInstrumentPersistence.id]!!
    }

}