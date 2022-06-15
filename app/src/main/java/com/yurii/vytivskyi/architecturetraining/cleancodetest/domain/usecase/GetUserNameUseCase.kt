package com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.usecase

import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.models.UserName
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository){

    fun execution(): UserName {
        return userRepository.getName()
    }

}