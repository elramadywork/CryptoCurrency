package com.example.cryptocurrencyapp.presentation.coin_detail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Constants.PARAM_COIN_ID
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase:GetCoinUseCase,
     savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state= mutableStateOf(CoinDetailsState())
    val state:State<CoinDetailsState> = _state


    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let {coinId->
            getCoin(coinId)
        }
    }

    private fun getCoin(coidId:String){
        getCoinUseCase(coidId).onEach {result->
            when(result){
                is Resource.Success -> {
                    _state.value= CoinDetailsState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value= CoinDetailsState(error =result.message?:"An expected Error occured" )
                }
                is Resource.Loading -> {
                    _state.value= CoinDetailsState(isLoading =true)
                }

            }
        }.launchIn(viewModelScope)
    }

}