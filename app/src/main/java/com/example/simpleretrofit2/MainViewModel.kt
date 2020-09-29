package com.example.simpleretrofit2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleretrofit2.repository.Repository
import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.simpleretrofit2.model.Post
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
}