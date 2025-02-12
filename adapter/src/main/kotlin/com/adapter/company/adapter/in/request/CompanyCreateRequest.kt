package com.adapter.company.adapter.`in`.request

import com.core.domains.company.vo.CompanyType
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

data class CompanyCreateRequest(
    @Schema(description = "회사명", example = "윈윈")
    @NotBlank
    val name: String,

    @Schema(description = "회사 소개", example = "채용 정보를 한 눈에 볼 수 있습니다.")
    @NotBlank
    val description: String,

    @Schema(description = "회사 주소", example = "역삼동 123-456")
    @NotBlank
    val address: String,

    @Schema(description = "회사 url", example = "https://example.com")
    @NotBlank
    val url: String,

    @Schema(description = "회사 규모 (01: 대기업, 02: 중견기업, 03: 중소기업, 04: 스타트업, 05: 외국계 기업)", example = "01")
    @NotBlank
    val companyType: CompanyType,
) {
}