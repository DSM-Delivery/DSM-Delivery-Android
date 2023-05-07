package com.dsm_delivery.data.remote.request.auth

import com.dsm_delivery.domain.entity.SignInEntity
import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("account_id") val account_id: String,
    @SerializedName("password") val password: String
) {

    fun SignInEntity.toRequest() = SignInRequest(
        account_id = account_id,
        password = password,
    )
}