package com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.repository

import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.models.SaveUserNameParam
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.models.UserName

interface UserRepository {

    fun saveName(saveName: SaveUserNameParam):Boolean

    fun getName(): UserName

}