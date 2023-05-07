package com.dsm_delivery.data.remote.datasource

import com.dsm_delivery.domain.entity.SignInEntity
import com.dsm_delivery.domain.entity.SignUpEntity
import com.dsm_delivery.domain.entity.TokenEntity

interface AuthRemoteDataSource {

    suspend fun signIn(signInEntity: SignInEntity): TokenEntity

    suspend fun signUp(signUpEntity: SignUpEntity)

    suspend fun tokenRefresh(refreshToken: String): TokenEntity
}