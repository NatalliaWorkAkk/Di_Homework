package com.effectivemobile.faeture_home.data

import com.effectivemobile.core.di.Prod
import com.effectivemobile.core.di.Test
import com.effectivemobile.faeture_home.domain.NetworkRepository

import retrofit2.Retrofit
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    @Test
    private val testRetrofit: Retrofit,
    @Prod
    private val prodRetrofit: Retrofit
) : NetworkRepository {

    //    override suspend fun getNetworkResult() = withContext(Dispatchers.IO) {
//        val api = testRetrofit.create(Api::class.java)
//        api.getFakeNetworkResult()
//    }

    override suspend fun getTestNetworkResult(): String {
        return "result from test $testRetrofit"
    }

    override suspend fun getProdNetworkResult(): String {
        return "result from prod $prodRetrofit"
    }
}