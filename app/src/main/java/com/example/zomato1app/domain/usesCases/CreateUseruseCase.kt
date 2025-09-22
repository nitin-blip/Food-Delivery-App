package com.example.zomato1app.domain.usesCases

import com.example.zomato1app.common.ResultState
import com.example.zomato1app.data.module.UserData
import com.example.zomato1app.domain.repo.Repo
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow


class CreateUserUseCase @Inject constructor (val repo: Repo){
    fun  createUser(userData: UserData): Flow<ResultState<String>>{
        return repo.registerWithEmailAndPassword(userData)
    }


}