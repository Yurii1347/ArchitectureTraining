package com.yurii.vytivskyi.architecturetraining.cleancodetest.data.repository

import android.content.Context
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.models.SaveUserNameParam
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.models.UserName
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRS_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_LAST_NAME = "Lastname"

class UserRepositoryImpl(context: Context) : UserRepository {

private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveName: SaveUserNameParam):Boolean{
        sharedPreferences.edit().putString(KEY_FIRS_NAME, saveName.name).apply()
        return true
    }

    override fun getName():UserName{
        val firstName = sharedPreferences.getString(KEY_FIRS_NAME, "Name") ?: "Name"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return UserName(firstName = firstName, lastName = lastName)
    }

}