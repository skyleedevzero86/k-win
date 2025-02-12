package com.adapter.company.adapter.`in`.response

import com.core.domains.company.Company
import com.core.domains.company.vo.CompanyType
import io.swagger.v3.oas.annotations.media.Schema

data class CompanyResponse(
    @Schema(description = "회사 id", example = "1")
    val companyId: Long,

    @Schema(description = "회사명", example = "윈윈")
    val name: String,

    @Schema(description = "회사 소개", example = "채용 정보를 한 눈에 볼 수 있습니다.")
    val description: String,

    @Schema(description = "회사 주소", example = "역삼동 123-456")
    val address: String,

    @Schema(description = "회사 url", example = "https://example.com")
    val url: String,

    @Schema(description = "회사 규모 (01: 대기업, 02: 중견기업, 03: 중소기업, 04: 스타트업, 05: 외국계 기업)", example = "01")
    val companyType: CompanyType,
) {

    companion object {
        fun from(company: Company): CompanyResponse = CompanyResponse(
            companyId = company.id,
            name = company.name,
            description = company.description,
            address = company.address,
            url = company.url,
            companyType = company.companyType,
        )
    }
}
