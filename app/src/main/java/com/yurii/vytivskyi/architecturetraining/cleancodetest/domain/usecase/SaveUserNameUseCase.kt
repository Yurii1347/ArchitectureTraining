package com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.usecase

import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.models.SaveUserNameParam
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execution(param: SaveUserNameParam): Boolean{
        return userRepository.saveName(saveName = param)
    }

}