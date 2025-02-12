package com.core.domains.company.exception

import com.common.exceptions.CustomExceptionType
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode

enum class CompanyExceptionType(
    override val subject: String,
    override val message: String,
    override val httpStatusCode: HttpStatusCode
) : CustomExceptionType {

    COMPANY_TYPE_INVALID_EXCEPTION("Company Type Invalid", "회사 규모를 정확히 입력해주세요.", HttpStatus.BAD_REQUEST),
}