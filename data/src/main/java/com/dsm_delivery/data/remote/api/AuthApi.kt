package com.dsm_delivery.data.remote.api

import com.dsm_delivery.data.remote.request.auth.SignInRequest
import com.dsm_delivery.data.remote.request.auth.SignUpRequest
import com.dsm_delivery.data.remote.response.auth.TokenResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthApi {

    @POST("/user/auth")
    suspend fun signIn(
        @Body signInRequest: SignInRequest
    ): TokenResponse

    @POST("/user/register")
    suspend fun signUp(
        @Body signUpRequest: SignUpRequest
    )

    @PUT("/user/token")
    suspend fun tokenRefresh(
        @Header("REFRESH-TOKEN") refreshToken: String
    ): TokenResponse

}