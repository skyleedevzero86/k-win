package com.application.company

import com.application.company.port.`in`.command.CompanyCreateCommand
import com.application.company.port.`in`.command.CompanyEditCommand
import com.core.domains.company.vo.CompanyType

class CompanyApplicationFixture {

    companion object {
        fun 회사_생성_커맨드_생성(): CompanyCreateCommand {
            return CompanyCreateCommand(
                name = "winwin",
                description = "this is winwin",
                address = "역삼동 123-123",
                url = "http://localhost:8080",
                companyType = CompanyType.LARGE_COMPANY,
            )
        }

        fun 회사_수정_커맨드_생성(companyId: Long?): CompanyEditCommand {
            return CompanyEditCommand(
                companyId ?: 0L,
                name = "edit",
                description = "this is winwin",
                address = "역삼동 123-123",
                url = "http://localhost:8080",
                companyType = CompanyType.LARGE_COMPANY,
            )
        }
    }
}
