package com.worms.financeapp.financialinstrument


import com.worms.financeapp.IntegrationSpec
import com.worms.financeapp.TestPage
import com.worms.financeapp.IntegrationSpecConfig
import com.worms.financeapp.financialinstrument.dto.FinInstrumentResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.reactive.server.WebTestClient

import static java.util.Collections.emptyList

class FinInstrumentIntegrationSpec extends IntegrationSpec {

    @Autowired
    private WebTestClient webTestClient

    def setupSpec() {
        IntegrationSpecConfig.setup()
    }

    def cleanupSpec() {
        IntegrationSpecConfig.cleanup()
    }

    def "should get empty instruments list when none was added"() {
        when:
            def exchange = webTestClient.get()
                    .uri("/fin-instrument/")
                    .exchange()

        then:
            with(exchange) {
                with(expectBody(TestPage<FinInstrumentResponse>.class).returnResult().responseBody) {
                    totalElements == 0
                    content == emptyList()
                }
                expectStatus().isOk()
            }
    }

}