package com.dsm_delivery.data.local.preference

import org.threeten.bp.LocalDateTime

interface AuthPreference {

    suspend fun saveAccessToken(accessToken: String)

    suspend fun fetchAccessToken(): String

    suspend fun clearAccessToken()

    suspend fun saveRefreshToken(refreshToken: String)

    suspend fun fetchRefreshToken(): String

    suspend fun clearRefreshToken()

    suspend fun fetchAuthorityToken(): String

    suspend fun saveAuthorityToken(authority: String)

    suspend fun clearAuthorityToKen()

    suspend fun saveExpirationAt(expiredAt: LocalDateTime)

    suspend fun fetchExpirationAt(): LocalDateTime

    suspend fun clearExpirationAt()

    suspend fun saveUserId(userId: String)

    suspend fun fetchUserId(): String

    suspend fun clearUserId()
}
