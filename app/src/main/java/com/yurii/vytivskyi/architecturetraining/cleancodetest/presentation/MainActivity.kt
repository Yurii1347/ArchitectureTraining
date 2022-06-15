package com.yurii.vytivskyi.architecturetraining.cleancodetest.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yurii.vytivskyi.architecturetraining.cleancodetest.data.repository.UserRepositoryImpl
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.models.SaveUserNameParam
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.repository.UserRepository
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.usecase.GetUserNameUseCase
import com.yurii.vytivskyi.architecturetraining.cleancodetest.domain.usecase.SaveUserNameUseCase
import com.yurii.vytivskyi.architecturetraining.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    private val userRepository by lazy { UserRepositoryImpl(applicationContext) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameParam by lazy { SaveUserNameUseCase(userRepository) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btGetData.setOnClickListener {
                val text = getUserNameUseCase.execution().firstName+ " " +getUserNameUseCase.execution().lastName
                tvResult.text = text
            }
            btSaveData.setOnClickListener {
                val param = SaveUserNameParam(edSaveText.text.toString())
                val text = "Saving data = "+saveUserNameParam.execution(param = param)
                tvResult.text = text
            }
//Experemental branch (second)
        }

    }
}