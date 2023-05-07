package com.dsm_delivery.data.local.datasource

import com.dsm_delivery.domain.entity.TokenEntity

interface AuthLocalDataSource {

    suspend fun fetchToken(): TokenEntity

    suspend fun saveToken(tokenEntity: TokenEntity)

    suspend fun clearToken()
}