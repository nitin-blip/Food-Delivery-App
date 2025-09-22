package com.example.zomato1app.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zomato1app.common.ResultState
import com.example.zomato1app.data.module.UserData
import com.example.zomato1app.domain.usesCases.CreateUserUseCase
import com.example.zomato1app.domain.usesCases.LoginUserUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject




@HiltViewModel
class ZomViewModel @Inject constructor(

    private val  createUserUseCase: CreateUserUseCase,
    private val loginUserUseCase: LoginUserUseCase

): ViewModel() {
    private val _singUpScreenState = MutableStateFlow(SingUpScreenState())
    val singUpScreenState = _singUpScreenState.asStateFlow()
    private val _loginScreenState = MutableStateFlow(LoginScreenState())
    val loginScreenState = _loginScreenState.asStateFlow()







    fun createUser(userData: UserData) {
        viewModelScope.launch {
            createUserUseCase.createUser(userData).collect {
                when (it) {
                    is ResultState.Error -> {
                        _singUpScreenState.value = _singUpScreenState.value.copy(
                            isLoading = false,
                            errorMessage = it.message
                        )

                    }

                    ResultState.Loading -> {
                        _singUpScreenState.value = _singUpScreenState.value.copy(
                            isLoading = true
                        )
                    }

                    is ResultState.Success -> {
                        _singUpScreenState.value = _singUpScreenState.value.copy(
                            isLoading = false,
                            userData = it.data
                        )
                    }
                }
            }
        }
    }

    fun loginUser (userData: UserData){
        viewModelScope.launch {
            loginUserUseCase.loginUser(userData).collect{
                when (it) {
                    is ResultState.Error -> {
                        _loginScreenState.value = _loginScreenState.value.copy(
                            isLoading = false,
                            errorMessage = it.message
                        )
                }
                    ResultState.Loading -> {
                        _loginScreenState.value = _loginScreenState.value.copy(
                            isLoading =   true
                        )
                }
                    is ResultState.Success -> {
                        _loginScreenState.value = _loginScreenState.value.copy(
                            isLoading = false,
                            userData = it.data
                        )
                    }
                }
            }

        }

    }





}



    data class SingUpScreenState(
        val isLoading: Boolean = false,
        val errorMessage: String? = null,
        val userData: String? = null
    )

    data class LoginScreenState(
        val isLoading: Boolean = false,
        val errorMessage: String? = null,
        val userData: String? = null
    )
