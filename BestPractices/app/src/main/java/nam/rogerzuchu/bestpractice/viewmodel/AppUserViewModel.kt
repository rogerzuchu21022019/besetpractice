package nam.rogerzuchu.bestpractice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import nam.rogerzuchu.bestpractice.appRepository.AppRepository
import nam.rogerzuchu.bestpractice.database.AppDatabase
import nam.rogerzuchu.bestpractice.database.entities.User

class AppUserViewModel(application: Application) :AndroidViewModel(application) {
    lateinit var appRepository: AppRepository
    lateinit var getAllInformation:LiveData<List<User>>
    init {
        val userDAO = AppDatabase.useAppDatabase(application).useUserDAO()
        appRepository = AppRepository(userDAO = userDAO)
        getAllInformation = appRepository.getAllInformationUser
    }
    fun insertNewUserInRecyclerView(user: User){
        viewModelScope.launch(Dispatchers.IO){
            appRepository.insertNewUserInRecyclerView(user=user)
        }
    }
     fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO){
            appRepository.deleteAll()
        }
    }
    val getAllInformationUser: LiveData<List<User>> = appRepository.getAllInformationUser
}