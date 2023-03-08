package domain.usecase.auth

import domain.entity.auth.SignInEntity
import domain.repository.AuthRepository
import domain.usecase.UseCase
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository
): UseCase<SignInEntity, Unit>() {

    override suspend fun execute(data: SignInEntity) =
        authRepository.signIn(data)
}
