package com.core.domains.company.vo

import com.common.exceptions.CustomException
import com.core.domains.company.exception.CompanyExceptionType.COMPANY_TYPE_INVALID_EXCEPTION
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue

enum class CompanyType(
    @JsonValue val code: String
) {

    LARGE_COMPANY("01"),          // 대기업
    MID_COMPANY("02"),            // 중견기업
    SMALL_COMPANY("03"),          // 중소기업
    STARTUP("04"),                // 스타트업
    FOREIGN_COMPANY("05")         // 외국계 기업
    ;

    companion object {
        @JsonCreator
        @JvmStatic
        fun from(value: String): CompanyType {
            return entries.find { it.code == value }
                ?: throw CustomException(COMPANY_TYPE_INVALID_EXCEPTION)
        }
    }
}