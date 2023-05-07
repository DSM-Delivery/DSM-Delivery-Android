package com.dsm_delivery.feature.signin

import com.dsm_delivery.base.BaseViewModel
import com.dsm_delivery.domain.entity.SignInEntity
import com.dsm_delivery.domain.exception.BadRequestException
import com.dsm_delivery.domain.exception.NotFoundException
import com.dsm_delivery.domain.exception.UnauthorizedException
import com.dsm_delivery.domain.usecase.SignInUseCase
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
): BaseViewModel<SignInViewModel.Event>(){

    fun signIn(signInEntity: SignInEntity) = processData(
        job = { signInUseCase.execute(signInEntity) },
        onSuccess = { emitEvent(Event.Success) },
        onFailure = {
            when(it){
                is BadRequestException -> emitEvent(Event.BadRequest)
                is NotFoundException -> emitEvent(Event.NotFound)
                is UnauthorizedException -> emitEvent(Event.Unauthorized)
            }
        }
    )





    sealed class Event {

        object Success : SignInViewModel.Event()

        object BadRequest : SignInViewModel.Event()

        object NotFound : SignInViewModel.Event()

        object Unauthorized : SignInViewModel.Event()
    }

}




