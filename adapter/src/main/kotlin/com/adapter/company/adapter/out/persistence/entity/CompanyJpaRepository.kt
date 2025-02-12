package com.adapter.company.adapter.out.persistence.entity

import org.springframework.data.repository.CrudRepository

interface CompanyJpaRepository : CrudRepository<CompanyJpaEntity, Long> {
}