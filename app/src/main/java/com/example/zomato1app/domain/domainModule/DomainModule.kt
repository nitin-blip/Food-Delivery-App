package com.example.zomato1app.domain.domainModule


import com.example.zomato1app.data.repoImple.RepoImpl
import com.example.zomato1app.domain.repo.Repo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent



@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides

    fun  provideRepo(firebaseAuth: FirebaseAuth, firebaseFirestore: FirebaseFirestore): Repo {
        return RepoImpl(firebaseAuth, firebaseFirestore)

    }


}