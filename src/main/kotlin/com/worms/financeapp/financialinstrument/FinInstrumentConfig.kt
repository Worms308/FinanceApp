package com.worms.financeapp.financialinstrument

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories


@Configuration
@EnableElasticsearchRepositories
internal class FinInstrumentConfig : ElasticsearchConfiguration() {

    fun financialInstrumentFacade(): FinInstrumentFacade {
        val repository = InMemoryFinInstrumentRepository()
        return FinInstrumentFacade(repository)
    }

    @Bean
    fun financialInstrumentFacade(finInstrumentRepository: FinInstrumentRepository): FinInstrumentFacade {
        return FinInstrumentFacade(finInstrumentRepository)
    }

    override fun clientConfiguration(): ClientConfiguration {
        return ClientConfiguration.builder()
            .connectedToLocalhost()
            .build()
    }
}