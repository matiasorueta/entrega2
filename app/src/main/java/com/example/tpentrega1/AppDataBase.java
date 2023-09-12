package com.example.tpentrega1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Usuario.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UsuarioDao usuarioDao();

    private static AppDataBase INSTANCE = null;
    public static AppDataBase getDatabase(Context contexto) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                INSTANCE = Room.databaseBuilder(
                                contexto.getApplicationContext(),
                                AppDataBase.class,
                                "base_app_usuarios"
                        )
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}
/*package com.example.tpentrega1

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
abstract fun usuarioDao(): UsuarioDao

        companion object {
@Volatile
private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
        val instance = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "base_app_usuarios"
        )
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()
        INSTANCE = instance
        instance
        }
        }
        }
        }
*/