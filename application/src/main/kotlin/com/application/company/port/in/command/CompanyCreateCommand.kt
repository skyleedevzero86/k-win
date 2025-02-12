package com.application.company.port.`in`.command

import com.core.domains.company.Company
import com.core.domains.company.vo.CompanyType

data class CompanyCreateCommand(
    val name: String,
    val description: String,
    val address: String,
    val url: String,
    val companyType: CompanyType,
) {

    fun toDomain(): Company {
        return Company(
            name = name,
            description = description,
            address = address,
            url = url,
            companyType = companyType,
        )
    }
}