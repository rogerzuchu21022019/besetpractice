package nam.rogerzuchu.bestpractice.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Table User")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "STT")
    val stt: Int,
    @ColumnInfo(name = "Account")
    val account: String,
    @ColumnInfo(name = "Password")
    val password: String
)