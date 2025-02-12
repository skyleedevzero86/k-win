package com.adapter.company.adapter.`in`

import com.adapter.company.adapter.`in`.request.CompanyCreateRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "Company API")
interface CompanyApi {

    @SecurityRequirement(name = "jwt")
    @Operation(summary = "회사 정보 등록")
    @PostMapping
    fun createCompany(
        @RequestBody request: CompanyCreateRequest
    ): ResponseEntity<Unit>
}