package com.adapter.company.adapter.`in`

import com.adapter.company.adapter.`in`.request.CompanyCreateRequest
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import com.adapter.company.adapter.`in`.request.CompanyUpdateRequest
import com.adapter.company.adapter.`in`.response.CompanyResponse

@Tag(name = "Company API")
interface CompanyApi {

    @SecurityRequirement(name = "jwt")
    @Operation(summary = "회사 정보 등록")
    @PostMapping
    fun createCompany(
        @RequestBody request: CompanyCreateRequest
    ): ResponseEntity<Unit>
    @Operation(summary = "회사 정보 조회")
    @GetMapping("/{companyId}")
    fun findCompany(
        @PathVariable companyId: Long
    ): ResponseEntity<CompanyResponse>

    @SecurityRequirement(name = "jwt")
    @Operation(summary = "회사 정보 수정")
    @PatchMapping("/{companyId}")
    fun updateCompany(
        @PathVariable companyId: Long,
        @RequestBody request: CompanyUpdateRequest
    ): ResponseEntity<CompanyResponse>

    @SecurityRequirement(name = "jwt")
    @Operation(summary = "회사 정보 삭제")
    @DeleteMapping("/{companyId}")
    fun deleteCompany(@PathVariable companyId: Long): ResponseEntity<Unit>
}