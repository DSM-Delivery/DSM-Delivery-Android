package com.dsm_delivery.domain.usecase

import com.dsm_delivery.domain.UseCase
import com.dsm_delivery.domain.repository.AuthRepository
import javax.inject.Inject


class AutoLoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
): UseCase<Unit, Unit>() {

    override suspend fun execute(data: Unit) {
        authRepository.autoLogin()
    }
}