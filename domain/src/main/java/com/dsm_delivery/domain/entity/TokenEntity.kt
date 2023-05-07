package com.dsm_delivery.domain.entity

import org.threeten.bp.LocalDateTime

data class TokenEntity(
    val access_token: String,
    val refresh_token: String,
    val authority: String,
    val expired_at: LocalDateTime
)
