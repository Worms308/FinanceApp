package com.worms.financeapp.financialinstrument


import com.worms.financeapp.IntegrationSpec
import com.worms.financeapp.TestPage
import com.worms.financeapp.IntegrationSpecConfig
import com.worms.financeapp.financialinstrument.dto.CreateResult
import com.worms.financeapp.financialinstrument.dto.FinInstrumentPayload
import com.worms.financeapp.financialinstrument.dto.FinInstrumentResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.reactive.server.WebTestClient

import static java.util.Collections.emptyList

class FinInstrumentIntegrationSpec extends IntegrationSpec {

    @Autowired
    private WebTestClient webTestClient

    private def apiVersion = "v1"

    def setupSpec() {
        IntegrationSpecConfig.setup()
    }

    def cleanupSpec() {
        IntegrationSpecConfig.cleanup()
    }

    def "should get empty instruments list when none was added"() {
        when:
            def exchange = webTestClient.get()
                    .uri("/$apiVersion/fin-instrument/")
                    .exchange()

        then:
            with(getResponseBody(exchange, TestPage<FinInstrumentResponse>.class)) {
                totalElements == 0
                content == emptyList()
            }
    }

    def "should create new instrument and get it by ID"() {
        given:
            def finInstrument = new FinInstrumentPayload("sample financial instrument")

        when:
            def exchange = webTestClient.post()
                    .uri("/$apiVersion/fin-instrument/")
                    .bodyValue(finInstrument)
                    .exchange()

        then:
            def response = getResponseBody(exchange, CreateResult.class)
            response.isOk()
    }
}
