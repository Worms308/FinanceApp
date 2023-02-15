package com.worms.financeapp

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@TypeChecked
@SpringBootTest(classes = [FinanceAppApplication, IntegrationSpecConfig])
@ActiveProfiles(["integration"])
@AutoConfigureMockMvc
@Import(IntegrationSpecConfig)
@CompileStatic
class IntegrationSpec extends Specification {

}