package com.effectivemobile.faeture_home.domain

interface NetworkRepository {

    suspend fun getTestNetworkResult(): String

    suspend fun getProdNetworkResult(): String
}