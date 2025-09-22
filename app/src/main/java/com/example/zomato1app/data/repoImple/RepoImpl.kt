package com.example.zomato1app.data.repoImple

import com.example.zomato1app.common.ResultState
import com.example.zomato1app.common.USER_COLLECTION
import com.example.zomato1app.data.module.UserData
import com.example.zomato1app.domain.repo.Repo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject




class RepoImpl @Inject  constructor(
    var  firebaseAuth: FirebaseAuth,
    var  firebaseFirestore: FirebaseFirestore
) : Repo {
    override fun registerWithEmailAndPassword(userData: UserData): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)
            firebaseAuth.createUserWithEmailAndPassword(userData.email, userData.password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        firebaseFirestore.collection(USER_COLLECTION)

                            .document(it.result.user?.uid.toString()).set(userData)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    trySend(ResultState.Success("User Registered Successfully"))
                                } else {
                                    if (it.exception != null) {
                                        trySend(ResultState.Error(it.exception?.localizedMessage.toString()))
                                    }
                                }
                            }
                        trySend(ResultState.Success("User Registered Successfully"))
                    } else {
                        if (it.exception != null) {
                            trySend(ResultState.Error(it.exception?.localizedMessage.toString()))


                        }

                    }

                }
            awaitClose {
                close()
            }
        }


    override fun loginWithEmailAndPassword(userData: UserData): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)
            firebaseAuth.signInWithEmailAndPassword(userData.email, userData.password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        trySend(ResultState.Success("User Logged In Successfully"))
                    } else {
                        if (it.exception != null) {
                            trySend(ResultState.Error(it.exception?.localizedMessage.toString()))
                        }

                    }

                }
            awaitClose {
                close()
            }

        }
}