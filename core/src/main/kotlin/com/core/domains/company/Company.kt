package com.core.domains.company

import com.core.domains.company.vo.CompanyType

class Company(
    val id: Long = 0L,
    val name: String,
    val description: String,
    val address: String,
    val url: String,
    val companyType: CompanyType,
    val isHiring: Boolean = false,
) {
    fun edit(editedCompany: Company): Company {
        return Company(
            id = editedCompany.id,
            name = editedCompany.name,
            description = editedCompany.description,
            address = editedCompany.address,
            url = editedCompany.url,
            companyType = editedCompany.companyType,
            isHiring = editedCompany.isHiring,
        )
    }
}