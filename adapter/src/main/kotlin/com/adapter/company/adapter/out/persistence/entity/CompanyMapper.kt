package com.adapter.company.adapter.out.persistence.entity

import com.core.domains.company.Company
import org.springframework.stereotype.Component

@Component
class CompanyMapper {

    fun toEntity(domain: Company): CompanyJpaEntity {
        return CompanyJpaEntity(
            id = domain.id,
            name = domain.name,
            description = domain.description,
            url = domain.url,
            isHiring = domain.isHiring,
            address = domain.address,
            companyType = domain.companyType,
        )
    }

    fun toDomain(entity: CompanyJpaEntity): Company {
        return Company(
            id = entity.id,
            name = entity.name,
            description = entity.description,
            url = entity.url,
            isHiring = entity.isHiring,
            address = entity.address,
            companyType = entity.companyType,
        )
    }
}
