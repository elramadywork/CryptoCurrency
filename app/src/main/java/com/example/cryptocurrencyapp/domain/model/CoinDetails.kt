package com.example.cryptocurrencyapp.domain.model

import com.example.cryptocurrencyapp.data.remote.dto.TeamMembers

data class CoinDetails(
    val coidId:String,
    val name:String,
    val description:String,
    val symbol:String,
    val rank:Int,
    val isActive:Boolean,
    val tags:List<String>,
    val team:List<TeamMembers>
)
