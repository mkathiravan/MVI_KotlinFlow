package net.kathir.mvi_kotlinflow.data.api

import net.kathir.mvi_kotlinflow.data.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers() : List<User>
}