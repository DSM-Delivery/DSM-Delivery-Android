package com.dsm_delivery.data.repository

import com.dsm_delivery.data.local.datasource.AuthLocalDataSource
import com.dsm_delivery.data.local.preference.AuthPreference
import com.dsm_delivery.data.remote.datasource.AuthRemoteDataSource
import com.dsm_delivery.domain.entity.SignInEntity
import com.dsm_delivery.domain.entity.SignUpEntity
import com.dsm_delivery.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource,
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authPreference: AuthPreference
): AuthRepository {


    override suspend fun signIn(signInEntity: SignInEntity) {
        val token = authRemoteDataSource.signIn(signInEntity)
        val userId = signInEntity.account_id
        authLocalDataSource.saveToken(token)
        authPreference.saveUserId(userId)
    }

    override suspend fun signUp(signUpEntity: SignUpEntity) =
        authRemoteDataSource.signUp(signUpEntity)

    override suspend fun autoLogin() {
        val refreshToken = authLocalDataSource.fetchToken().refresh_token
        val token = authRemoteDataSource.tokenRefresh("Bearer $refreshToken")
        authLocalDataSource.saveToken(token)
    }

    override suspend fun logout() {
        authPreference.clearAccessToken()
        authPreference.clearExpirationAt()
        authPreference.clearUserId()
        authPreference.clearAuthorityToKen()
        authPreference.clearRefreshToken()
    }
}