package net.kathir.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.kathir.mvi_kotlinflow.data.api.ApiHelper
import net.kathir.mvi_kotlinflow.data.repository.MainRepository
import net.kathir.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknow class name")
    }


}