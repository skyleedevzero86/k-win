package com.adapter.company.adapter

import com.adapter.company.adapter.`in`.CompanyApi
import com.adapter.company.adapter.`in`.request.CompanyCreateRequest
import com.application.company.port.`in`.CompanyUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RequestMapping("/companies")
@RestController
class CompanyController(
    private val companyUseCase: CompanyUseCase
) : CompanyApi {

    override fun createCompany(@RequestBody request: CompanyCreateRequest): ResponseEntity<Unit> {
        val createdCompanyId = companyUseCase.createCompany(request.toCommand())
            .id
        return ResponseEntity.created(URI.create("/companies/${createdCompanyId}"))
            .build()
    }
}
