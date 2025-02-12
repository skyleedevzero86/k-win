package com.application.company

import com.application.company.port.`in`.CompanyUseCase
import com.application.company.port.out.CompanyRepositoryPort
import org.springframework.stereotype.Service

@Service
class CompanyService(
    private val companyRepositoryPort: CompanyRepositoryPort
) : CompanyUseCase {

}