package io.github.zohrevand.dialogue.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.github.zohrevand.dialogue.core.database.dao.ContactDao
import io.github.zohrevand.dialogue.core.database.model.ContactEntity
import io.github.zohrevand.dialogue.core.database.util.InstantConverter

@Database(
    entities = [
        ContactEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    InstantConverter::class,
)
abstract class DialogueDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}
