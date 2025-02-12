package com.core.domains.company

import com.core.domains.company.vo.CompanyType

class Company(
    val id: Long? = 0L,
    val name: String,
    val description: String,
    val address: String,
    val url: String?,
    val companyType: CompanyType,
    val isHiring: Boolean? = false,
) {
}