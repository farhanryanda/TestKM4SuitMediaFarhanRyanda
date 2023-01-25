package com.farhanryanda.testkm4suitmediafarhanryanda.network

import com.farhanryanda.testkm4suitmediafarhanryanda.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestfulApi {
    @GET("/api/users")
    fun getUser(@Query("page") page: Int) : Call<UserResponse>
}