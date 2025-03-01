package com.application.company.port.out

import com.core.domains.company.Company

interface CompanyRepositoryPort {

    fun save(company: Company): Company

    fun findById(companyId: Long): Company?

    fun editCompany(companyId: Long, company: Company): Company


    fun deleteById(companyId: Long)
}