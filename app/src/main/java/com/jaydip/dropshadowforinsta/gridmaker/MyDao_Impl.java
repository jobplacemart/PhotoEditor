package com.jaydip.dropshadowforinsta.gridmaker;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class MyDao_Impl implements MyDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfMyArrByte;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public MyDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfMyArrByte = new EntityInsertionAdapter<MyArrByte>(roomDatabase) {
            /* class com.jaydip.storymakerforinsta.gridmaker.MyDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `MyArrByte`(`bytes`,`id`) VALUES (?,nullif(?, 0))";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, MyArrByte myArrByte) {
                if (myArrByte.getBytes() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindBlob(1, myArrByte.getBytes());
                }
                supportSQLiteStatement.bindLong(2, (long) myArrByte.id);
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            /* class com.jaydip.storymakerforinsta.gridmaker.MyDao_Impl.AnonymousClass2 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM MyArrByte";
            }
        };
    }

    @Override // com.jaydip.storymakerforinsta.gridmaker.MyDao
    public void insert(MyArrByte myArrByte) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMyArrByte.insert(myArrByte);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.jaydip.storymakerforinsta.gridmaker.MyDao
    public void deleteAll() {
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    @Override
    public List<MyArrByte> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM MyArrByte", 0);
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("bytes");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("id");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                MyArrByte myArrByte = new MyArrByte();
                myArrByte.setBytes(query.getBlob(columnIndexOrThrow));
                myArrByte.id = query.getInt(columnIndexOrThrow2);
                arrayList.add(myArrByte);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
