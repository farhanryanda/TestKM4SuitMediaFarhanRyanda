package com.farhanryanda.testkm4suitmediafarhanryanda.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.farhanryanda.testkm4suitmediafarhanryanda.model.UserResponse
import com.farhanryanda.testkm4suitmediafarhanryanda.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {
    var userLiveData: MutableLiveData<UserResponse> = MutableLiveData()

    fun getUserData() : MutableLiveData<UserResponse> {
        return userLiveData
    }

    fun callUserData(page: Int) {
        RetrofitClient.apiInstance.getUser(page)
            .enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        userLiveData.postValue(response.body())
                    } else {
                        Log.d("Fetch Data User Failed", call.toString())
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Log.d("User Data Error", call.toString())
                }

            })
    }
}