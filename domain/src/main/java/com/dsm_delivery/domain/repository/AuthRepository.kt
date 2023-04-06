package com.dsm_delivery.domain.repository

import com.dsm_delivery.domain.entity.SignInEntity
import com.dsm_delivery.domain.entity.SignUpEntity

interface AuthRepository {

    suspend fun signIn(signInEntity: SignInEntity)

    suspend fun signUp(signUpEntity: SignUpEntity)

    suspend fun autoLogin()

    suspend fun logout()


}