package nam.rogerzuchu.bestpractice.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import nam.rogerzuchu.bestpractice.database.DAO.AppDAO
import nam.rogerzuchu.bestpractice.database.entities.User

@Database(entities = [User::class],exportSchema = false,version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun useUserDAO():AppDAO
    companion object{
        val DB_NAME = "User Database"
        @Volatile
        var INSTANCE:AppDatabase?=null
        fun useAppDatabase(context:Context):AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,AppDatabase::class.java, DB_NAME
                ).build()
                INSTANCE  = instance
                return instance
            }
        }
    }
}