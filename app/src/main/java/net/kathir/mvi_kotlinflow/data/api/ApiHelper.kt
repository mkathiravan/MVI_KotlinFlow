package net.kathir.mvi_kotlinflow.data.api

import net.kathir.mvi_kotlinflow.data.model.User

interface ApiHelper {

    suspend fun getUsers() : List<User>
}