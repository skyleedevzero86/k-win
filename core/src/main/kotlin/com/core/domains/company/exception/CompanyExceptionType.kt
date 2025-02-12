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
    COMPANY_NOT_FOUND_EXCEPTION("Company Not Found", "회사를 찾을 수 없습니다. id를 정확히 확인해주세요.", HttpStatus.NOT_FOUND),
}