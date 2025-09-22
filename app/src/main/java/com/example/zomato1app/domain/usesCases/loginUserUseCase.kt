package com.example.zomato1app.domain.usesCases

import com.example.zomato1app.common.ResultState
import com.example.zomato1app.data.module.UserData
import com.example.zomato1app.domain.repo.Repo

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class LoginUserUseCase @Inject constructor (val repo: Repo){
    fun  loginUser(userData: UserData): Flow<ResultState<String>>{
        return repo.loginWithEmailAndPassword(userData)
    }


}