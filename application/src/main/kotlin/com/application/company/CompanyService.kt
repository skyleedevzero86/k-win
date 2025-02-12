package com.application.company

import com.application.company.port.`in`.CompanyUseCase
import com.application.company.port.`in`.command.CompanyCreateCommand
import com.application.company.port.`in`.command.CompanyEditCommand
import com.application.company.port.out.CompanyRepositoryPort
import com.common.exceptions.CustomException
import com.common.global.exceptions.CustomException
import com.core.domains.company.Company
import com.core.domains.company.exception.CompanyExceptionType
import org.springframework.stereotype.Service

@Service
class CompanyService(
    private val companyRepositoryPort: CompanyRepositoryPort
) : CompanyUseCase {

    override fun createCompany(command: CompanyCreateCommand): Company {
        val company = command.toDomain()
        return companyRepositoryPort.save(company)
    }

    override fun findCompanyById(companyId: Long): Company? {
        return findCompany(companyId)
    }

    private fun findCompany(companyId: Long) = companyRepositoryPort.findById(companyId)
        ?: throw CustomException(CompanyExceptionType.COMPANY_NOT_FOUND_EXCEPTION)

    override fun editCompany(command: CompanyEditCommand): Company {
        val editedCompany = findCompany(command.companyId)
            .edit(command.toCompany())
        return companyRepositoryPort.editCompany(
            companyId = command.companyId,
            company = editedCompany
        )
    }

    override fun deleteCompanyById(companyId: Long) {
        companyRepositoryPort.deleteById(companyId)
    }
}
