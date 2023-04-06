package com.dsm_delivery.domain.entity

data class TokenEntity(
    val access_token: String,
    val refresh_token: String,
    val authority: String,
    val expired_at: String
)
