package com.example.android.retrofittcall.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.android.retrofittcall.model.Post
import com.example.android.retrofittcall.repositary.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(application: Application): AndroidViewModel(application) {



    //val myResponse: MutableLiveData<Post> = MutableLiveData()

     private val _myResponse = MutableLiveData<Response<Post>>()
    val myResponse: LiveData<Response<Post>>
    get() = _myResponse

    private val _myResponse2 = MutableLiveData<Response<Post>>()
    val myResponse2: LiveData<Response<Post>>
        get() = _myResponse2

    private val _myCustomResponse = MutableLiveData<Response<List<Post>>>()
    val myCustomResponse : LiveData<Response<List<Post>>>
    get() = _myCustomResponse

    private val _myCustomResponse2 = MutableLiveData<Response<List<Post>>>()
    val myCustomResponse2 : LiveData<Response<List<Post>>>
    get() = _myCustomResponse2

     private val repository: Repository = Repository()


    fun getPost(){
        viewModelScope.launch {
            val response = repository.getPost()
            _myResponse.value =response
        }
     }
    fun getPost2(number: Int){
        viewModelScope.launch {
            val response2 = repository.getPost2(number)
            _myResponse2.value =response2

        }
    }


    fun getMyCustomResponse(userId : Int){
        viewModelScope.launch {
            val response3 = repository.myCustomPost(userId)
            _myCustomResponse.value = response3
        }
    }


    fun getMyCustomResponse2(userId: Int, option: Map<String, String>){
        viewModelScope.launch {
            val response4 = repository.myCustomPost2(userId,option)
            _myCustomResponse2.value =response4
        }
    }






}