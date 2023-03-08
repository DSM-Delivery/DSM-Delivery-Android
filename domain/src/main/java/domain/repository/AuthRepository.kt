package domain.repository

import domain.entity.auth.SignInEntity
import domain.entity.auth.SignUpEntity

interface AuthRepository {

    suspend fun signIn(signInEntity: SignInEntity)

    suspend fun signUp(signUpEntity: SignUpEntity)

}