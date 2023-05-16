package com.worms.financeapp.financialinstrument.infrastructure.web

import com.worms.financeapp.financialinstrument.FinInstrumentFacade
import com.worms.financeapp.financialinstrument.dto.CreateResult
import com.worms.financeapp.financialinstrument.dto.FinInstrumentPayload
import com.worms.financeapp.financialinstrument.dto.FinInstrumentResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/fin-instrument")
internal class FinInstrumentController (
    private val finInstrumentFacade: FinInstrumentFacade
) {

    @GetMapping("/", produces = ["application/json"])
    fun getAllInstruments(@RequestParam(required = false) pageable: Pageable?): Page<FinInstrumentResponse> {
        return finInstrumentFacade.findAll(pageable)
    }

    @PostMapping("/", consumes = ["application/json"], produces = ["application/json"])
    fun createInstrument(@RequestBody payload: FinInstrumentPayload): CreateResult {
        return finInstrumentFacade.create(payload)
    }

}