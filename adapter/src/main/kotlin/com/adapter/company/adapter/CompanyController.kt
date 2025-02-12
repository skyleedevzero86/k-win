package com.adapter.company.adapter

import com.adapter.company.adapter.`in`.CompanyApi
import com.adapter.company.adapter.`in`.request.CompanyCreateRequest
import com.application.company.port.`in`.CompanyUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI
import com.adapter.company.adapter.`in`.request.CompanyUpdateRequest
import com.adapter.company.adapter.`in`.response.CompanyResponse
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@RequestMapping("/companies")
@RestController
class CompanyController(
    private val companyUseCase: CompanyUseCase
) : CompanyApi {

    @PostMapping
    override fun createCompany(@RequestBody request: CompanyCreateRequest): ResponseEntity<Unit> {
        val createdCompanyId = companyUseCase.createCompany(request.toCommand())
            .id
        return ResponseEntity.created(URI.create("/companies/${createdCompanyId}"))
            .build()
    }
    @GetMapping("/{companyId}")
    override fun findCompany(@PathVariable companyId: Long): ResponseEntity<CompanyResponse> {
        val company = companyUseCase.findCompanyById(companyId)
        return ResponseEntity.ok(CompanyResponse.from(company));
    }

    @PatchMapping("/{companyId}")
    override fun updateCompany(
        @PathVariable companyId: Long,
        @RequestBody request: CompanyUpdateRequest
    ): ResponseEntity<CompanyResponse> {
        val updateCompany = companyUseCase.updateCompany(request.toCommand(companyId))
        return ResponseEntity.ok(CompanyResponse.from(updateCompany))
    }

    @DeleteMapping("/{companyId}")
    override fun deleteCompany(@PathVariable companyId: Long): ResponseEntity<Unit> {
        companyUseCase.deleteCompanyById(companyId)
        return ResponseEntity.noContent()
            .build()
    }
}
