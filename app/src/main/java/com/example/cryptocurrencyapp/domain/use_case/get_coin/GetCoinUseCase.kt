package com.example.cryptocurrencyapp.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.toCoin
import com.example.cryptocurrencyapp.data.remote.dto.toCoinDetails
import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.model.CoinDetails
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    val repository: CoinRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    operator fun invoke(coinId:String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coin=repository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success(coin))
        }catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?:"an excepted error occurred"))
        }catch (e:IOException){
            emit(Resource.Error("can't reach server check you Internet Connection"))
        }
    }
}