package com.dsm_delivery.domain.usecase

import com.dsm_delivery.domain.UseCase
import com.dsm_delivery.domain.entity.SignInEntity
import com.dsm_delivery.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor (
    private val authRepository: AuthRepository
): UseCase<SignInEntity, Unit>() {

    override suspend fun execute(data: SignInEntity) =
        authRepository.signIn(data)

}