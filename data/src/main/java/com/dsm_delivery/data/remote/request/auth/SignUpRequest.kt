package com.dsm_delivery.data.remote.request.auth

import com.dsm_delivery.domain.entity.SignUpEntity
import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("account_id") val account_id: String,
    @SerializedName("password") val password: String,
    @SerializedName("name") val name: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("phone")  val phone: String,
    @SerializedName("role") val role: String
){

    fun SignUpEntity.toRequest() = SignUpRequest(
        account_id = account_id,
        password = password,
        name = name,
        gender = gender,
        phone = phone,
        role = role
    )
}