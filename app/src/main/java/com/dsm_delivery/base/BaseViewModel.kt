package com.dsm_delivery.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsm_delivery.domain.exception.NeedSignInException
import kotlinx.coroutines.launch



abstract class BaseViewModel<T> : ViewModel() {

    private val _eventFlow = MutableEventFlow<T>()
    val eventFlow = _eventFlow.asEventFlow()

    protected suspend fun emitEvent(event: T) {
        _eventFlow.emit(event)
    }

    protected fun <V> processData(
        job: suspend () -> V,
        onSuccess: suspend (value: V) -> Unit,
        onFailure: suspend (t: Throwable) -> Unit
    ) = viewModelScope.launch {
        kotlin.runCatching { job() }
            .onSuccess { onSuccess(it) }
            .onFailure {
                if (it is NeedSignInException) throw it
                onFailure(it)
            }
    }
}