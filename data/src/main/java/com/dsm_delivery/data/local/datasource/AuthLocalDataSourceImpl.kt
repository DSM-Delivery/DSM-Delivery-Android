package com.dsm_delivery.data.local.datasource

import com.dsm_delivery.data.local.preference.AuthPreference
import com.dsm_delivery.domain.entity.TokenEntity
import javax.inject.Inject

class AuthLocalDataSourceImpl @Inject constructor(
    private val authPreference: AuthPreference
): AuthLocalDataSource {

    override suspend fun fetchToken(): TokenEntity =
        with(authPreference){
            TokenEntity(
                access_token = fetchAccessToken(),
                refresh_token = fetchRefreshToken(),
                authority = fetchAuthorityToken(),
                expired_at = fetchExpirationAt()
            )
        }

    override suspend fun saveToken(tokenEntity: Unit) =
        with(authPreference){
            saveAccessToken(tokenEntity.access_token)
            saveExpirationAt(tokenEntity.expired_at)
            saveRefreshToken(tokenEntity.refresh_token)
            saveAuthorityToken(tokenEntity.authority)
        }

    override suspend fun clearToken() =
        with(authPreference) {
            clearAccessToken()
            clearExpirationAt()
            clearRefreshToken()
            clearAuthorityToKen()
        }

}