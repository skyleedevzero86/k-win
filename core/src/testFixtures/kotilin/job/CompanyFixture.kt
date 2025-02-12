package company

import com.core.domains.company.Company
import com.core.domains.company.vo.CompanyType

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
    }
}