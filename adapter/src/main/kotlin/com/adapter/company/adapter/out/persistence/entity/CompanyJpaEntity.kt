package com.adapter.company.adapter.out.persistence.entity


import com.core.domains.company.Company
import com.core.domains.company.vo.CompanyType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "company")
class CompanyJpaEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var description: String,

    @Column(nullable = false)
    var address: String,

    @Column(nullable = false)
    var url: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "company_type", nullable = false)
    var companyType: CompanyType,

    @Column(name = "is_hiring", nullable = false)
    var isHiring: Boolean
) {

    fun update(domain: Company): CompanyJpaEntity {
        this.name = domain.name
        this.description = domain.description
        this.address = domain.address
        this.url = domain.url
        this.companyType = domain.companyType
        this.isHiring = domain.isHiring
        return this
    }
}
