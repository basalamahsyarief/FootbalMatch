package com.basalamah.muhammadsyarif.myfootballmatch

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import org.jetbrains.anko.db.*

class MyDatabaseOpenHelper(ctx:Context):ManagedSQLiteOpenHelper(ctx,"DetailPresenter.db",null,1) {

    companion object {
        private var instance: MyDatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabaseOpenHelper {
            if (instance == null) {
                instance = MyDatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as MyDatabaseOpenHelper
        }
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable("TABLE_FAV",true,
                EventResponse.ID to INTEGER+ PRIMARY_KEY+ AUTOINCREMENT,
                EventResponse.EVENT_ID to TEXT+ UNIQUE,
                EventResponse.EVENT_DATE to TEXT,
                EventResponse.HOME_TEAM to TEXT,
                EventResponse.AWAY_TEAM to TEXT,
                EventResponse.SCORE_HOME to TEXT,
                EventResponse.SCORE_AWAY to TEXT,
                EventResponse.HOME_YELLOW to TEXT,
                EventResponse.AWAY_YELLOW to TEXT,
                EventResponse.HOME_RED to TEXT,
                EventResponse.AWAY_RED to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(EventResponse.TABLE,true)
    }
}
val Context.database : MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)
