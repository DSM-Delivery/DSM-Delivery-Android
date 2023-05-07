package com.dsm_delivery.data.remote.response.auth

import com.dsm_delivery.domain.entity.TokenEntity
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class TokenResponse(
    @SerializedName("access_token") val access_token: String,
    @SerializedName("refresh_token") val refresh_token: String,
    @SerializedName("authority") val authority: String,
    @SerializedName("expire_at") val expiration_at: String
) {

    fun TokenResponse.toEntity() = TokenEntity(
        access_token = access_token,
        refresh_token = refresh_token,
        authority = authority,
        expired_at = LocalDateTime.parse(expiration_at)
    )

}