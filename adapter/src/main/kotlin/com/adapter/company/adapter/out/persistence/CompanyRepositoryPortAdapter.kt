package com.adapter.company.adapter.out.persistence

import com.adapter.company.adapter.out.persistence.entity.CompanyJpaRepository
import com.adapter.company.adapter.out.persistence.entity.CompanyMapper
import com.application.company.port.out.CompanyRepositoryPort

import com.core.domains.company.Company
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Repository
class CompanyRepositoryPortAdapter(
    private val companyMapper: CompanyMapper,
    private val companyJpaRepository: CompanyJpaRepository
) : CompanyRepositoryPort {

    @Transactional
    override fun save(company: Company): Company {
        val savedCompany = companyJpaRepository.save(companyMapper.toEntity(company))
        return companyMapper.toDomain(savedCompany)
    }

    @Transactional(readOnly = true)
    override fun findById(companyId: Long): Company? {
        return companyJpaRepository.findByIdOrNull(companyId)
            ?.let { companyMapper.toDomain(it) }
    }

    @Transactional
    override fun editCompany(companyId: Long, company: Company): Company {
        return companyJpaRepository.findById(companyId)
            .getOrNull()
            ?.update(company)
            ?.let { companyMapper.toDomain(it) }!!
    }

    @Transactional
    override fun deleteById(companyId: Long) {
        companyJpaRepository.deleteById(companyId)
    }
}