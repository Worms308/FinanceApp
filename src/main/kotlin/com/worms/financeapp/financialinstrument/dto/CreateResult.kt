package com.worms.financeapp.financialinstrument.dto

import com.worms.financeapp.financialinstrument.dto.CreateResult.Status.*

data class CreateResult private constructor (
    val status: Status,
    val entityId: String? = null,
    val additionalInfo: String? = null
) {
    enum class Status {
        SUCCESS,
        CONFLICT,
        ERROR
    }

    fun isOk() = status == SUCCESS

    companion object {
        fun success(id: String) = CreateResult(SUCCESS, id)
        fun conflict(id: String) = CreateResult(CONFLICT, id)
        fun error(message: String?) = CreateResult(ERROR, null, message)
    }
}
