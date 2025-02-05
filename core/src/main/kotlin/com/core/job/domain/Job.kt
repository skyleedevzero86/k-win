package com.core.job.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Job(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    var id: Long = 0L,
) {
}