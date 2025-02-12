package company

import com.core.domains.company.Company
import com.core.domains.company.vo.CompanyType
import com.application.company.port.`in`.command.CompanyCreateCommand
import com.application.company.port.`in`.command.CompanyUpdateCommand
class CompanyFixture {

    companion object {
        fun 회사_정상_생성(id: Long = 0, name: String = "winwin"): Company {
            return Company(
                id = id,
                name = name,
                description = "this is winwin",
                address = "역삼동 123-123",
                url = "http://localhost:8080",
                companyType = CompanyType.LARGE_COMPANY,
                isHiring = false,
            )
        }
        fun 회사_수정_커맨드_생성(companyId: Long?): CompanyUpdateCommand {
            return CompanyUpdateCommand(
                companyId ?: 0L,
                name = "edit",
                description = "this is k-win",
                address = "역삼동 123-123",
                url = "http://localhost:8080",
                companyType = CompanyType.LARGE_COMPANY,
                isHiring = false,
            )
        }
    }
}