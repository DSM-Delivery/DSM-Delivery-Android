package com.dsm_delivery.domain.usecase

import com.dsm_delivery.domain.UseCase
import com.dsm_delivery.domain.entity.SignUpEntity
import com.dsm_delivery.domain.repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) : UseCase<SignUpEntity, Unit>() {

    override suspend fun execute(data: SignUpEntity) =
        authRepository.signUp(data)
}