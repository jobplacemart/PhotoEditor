package com.jaydip.dropshadowforinsta.gridmaker;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract MyDao arrByteDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = (AppDatabase) Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, Conts.DATABASE_NAME).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
