package com.galataapplab.chatapp.di

import com.galataapplab.chatapp.data.repository.LoginRepositoryImpl
import com.galataapplab.chatapp.domain.repository.LoginRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesLoginRepository(auth: FirebaseAuth): LoginRepository {
        return LoginRepositoryImpl(auth)
    }

}