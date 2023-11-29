package com.galataapplab.chatapp.di

import com.galataapplab.chatapp.domain.repository.LoginRepository
import com.galataapplab.chatapp.domain.use_case.CheckVerificationCode
import com.galataapplab.chatapp.domain.use_case.LoginUseCases
import com.galataapplab.chatapp.domain.use_case.SendPhoneNumberVerification
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideLoginUseCases(repository: LoginRepository) = LoginUseCases(
        sendPhoneNumberVerification = SendPhoneNumberVerification(repository),
        checkVerificationCode = CheckVerificationCode(repository)
    )
}