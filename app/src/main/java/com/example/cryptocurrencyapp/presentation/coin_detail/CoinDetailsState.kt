package com.example.cryptocurrencyapp.presentation.coin_detail

import com.example.cryptocurrencyapp.domain.model.Coin
import com.example.cryptocurrencyapp.domain.model.CoinDetails

data class CoinDetailsState(
    val isLoading:Boolean=false,
    val coin:CoinDetails ?= null,
    val error:String=""
)
