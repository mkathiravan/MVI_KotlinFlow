package net.kathir.mvi_kotlinflow.data.repository

import net.kathir.mvi_kotlinflow.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers();
}