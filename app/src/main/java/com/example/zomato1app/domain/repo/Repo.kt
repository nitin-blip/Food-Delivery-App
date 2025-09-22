package com.example.zomato1app.domain.repo

import com.example.zomato1app.common.ResultState
import com.example.zomato1app.data.module.UserData
import kotlinx.coroutines.flow.Flow

interface Repo {
    fun  loginWithEmailAndPassword(userData: UserData): Flow<ResultState<String>>
    fun  registerWithEmailAndPassword(userData: UserData): Flow<ResultState<String>>
}