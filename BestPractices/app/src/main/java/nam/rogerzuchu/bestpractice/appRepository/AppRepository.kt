package nam.rogerzuchu.bestpractice.appRepository

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import nam.rogerzuchu.bestpractice.database.DAO.AppDAO
import nam.rogerzuchu.bestpractice.database.entities.User

class AppRepository(val userDAO:AppDAO) {
    suspend fun insertNewUserInRecyclerView(user: User){
        userDAO.insertNewUserInRecyclerView(user=user)
    }
    suspend fun deleteAll(){
        userDAO.deleteAll()
    }
    val getAllInformationUser: LiveData<List<User>> = userDAO.getAllInformationUser()
}