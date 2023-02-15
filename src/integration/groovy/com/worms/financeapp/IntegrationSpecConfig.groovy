package com.worms.financeapp

import groovy.transform.CompileStatic
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.data.elasticsearch.client.ClientConfiguration
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration
import org.testcontainers.elasticsearch.ElasticsearchContainer
import spock.lang.Subject

@CompileStatic
@TestConfiguration
class IntegrationSpecConfig extends ElasticsearchConfiguration {

    static String ELASTIC_DOCKER_IMAGE = "docker.elastic.co/elasticsearch/elasticsearch:7.17.8"
    @Subject.Container
    static ElasticsearchContainer elasticContainer = new ElasticsearchContainer(ELASTIC_DOCKER_IMAGE)

    static def setup() {
        elasticContainer.start()
    }

    static def cleanup() {
        elasticContainer.stop()
    }

    @Override
    ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(elasticContainer.httpHostAddress)
                .build()
    }
}