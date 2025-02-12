package com.core.domains.company.vo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class CompanyTypeTest {

    @Test
    fun `타입_코드로_객체를_반환한다`() {
        // given
        val given = "01"

        // when
        val response = CompanyType.from(given)

        // then
        assertThat(response).isEqualTo(CompanyType.from("01"))
    }

    @Test
    fun `잘못된 타입을 입력하면 예외를 발생시킨다`() {
        // given
        val given = "123"

        // when
        val exception = assertThrows<CustomException> {
            CompanyType.from(given)
        }

        // then
        assertThat(exception.message).contains(CompanyExceptionType.COMPANY_TYPE_INVALID_EXCEPTION.message)
    }
}
