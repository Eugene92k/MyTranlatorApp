package com.example.mytranlatorapp.presenter.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mytranlatorapp.data.model.Resource
import com.example.mytranlatorapp.domain.repository.TranslateRepositoryImpl
import com.example.mytranlatorapp.domain.repository.TranslatorRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TranslatorViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TranslatorRepository =
        TranslateRepositoryImpl(application.applicationContext)

    private val _translateResult = MutableLiveData("")
    val translateResult: LiveData<String> = _translateResult

    fun getTranslate(text: String, to: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getTranslate(text, to)
            _translateResult.postValue(response)
        }
    }
}