package net.kathir.mvi_kotlinflow.data.api

import net.kathir.mvi_kotlinflow.data.model.User

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper{

    override suspend fun getUsers(): List<User> {
        return apiService.getUsers();
    }
}