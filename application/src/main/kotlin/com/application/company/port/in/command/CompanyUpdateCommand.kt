package com.application.company.port.`in`.command


import com.core.domains.company.Company
import com.core.domains.company.vo.CompanyType

data class CompanyUpdateCommand(
    val companyId: Long,
    val name: String,
    val description: String,
    val address: String,
    val url: String,
    val companyType: CompanyType,
) {

    fun toCompany() = Company(
        id = companyId,
        name = name,
        description = description,
        address = address,
        url = url,
        companyType = companyType,
    )
}
