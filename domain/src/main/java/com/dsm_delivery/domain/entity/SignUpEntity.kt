package com.dsm_delivery.domain.entity

data class SignUpEntity(
    val account_id: String,
    val password: String,
    val name: String,
    val gender: String,
    val phone: String,
    val role: String
)