package com.worms.financeapp.financialinstrument.infrastructure.web

import com.worms.financeapp.financialinstrument.FinInstrumentFacade
import com.worms.financeapp.financialinstrument.dto.FinInstrumentResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fin-instrument")
internal class FinInstrumentController (
    private val finInstrumentFacade: FinInstrumentFacade
) {

    @GetMapping("/")
    fun getAllInstruments(@RequestParam(required = false) pageable: Pageable?): Page<FinInstrumentResponse> {
        return finInstrumentFacade.findAll(pageable)
    }

}