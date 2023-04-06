package com.dsm_delivery.domain

abstract class UseCase<I,O> {
    abstract suspend fun execute(data: I): O
}