package nam.rogerzuchu.bestpractice.database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import nam.rogerzuchu.bestpractice.database.entities.User

@Dao
interface AppDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewUserInRecyclerView(user:User)
    @Query("delete from `Table User`")
    suspend fun deleteAll()
    @Query("select * from `Table User`")
    fun getAllInformationUser():LiveData<List<User>>
}