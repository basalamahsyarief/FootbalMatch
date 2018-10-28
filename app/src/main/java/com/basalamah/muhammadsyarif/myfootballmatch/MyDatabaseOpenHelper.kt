package com.basalamah.muhammadsyarif.myfootballmatch

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.basalamah.muhammadsyarif.myfootballmatch.models.EventResponse
import com.basalamah.muhammadsyarif.myfootballmatch.models.TeamResponse
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
        db?.createTable(EventResponse.TABLE,true,
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
        db?.createTable(TeamResponse.TABLE,true,
                TeamResponse.ID to INTEGER+ PRIMARY_KEY+ AUTOINCREMENT,
                TeamResponse.ID_TEAM to TEXT+ UNIQUE,
                TeamResponse.INT_FORMED_YEAR to TEXT,
                TeamResponse.STR_COUNTRY to TEXT,
                TeamResponse.STR_DESC_EN to TEXT,
                TeamResponse.STR_STADIUM to TEXT,
                TeamResponse.STR_TEAM to TEXT,
                TeamResponse.STR_TEAM_BADGE to TEXT,
                TeamResponse.STR_TEAM_BANNER to TEXT,
                TeamResponse.STR_TEAM_LOGO to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(EventResponse.TABLE,true)
        db?.dropTable(TeamResponse.TABLE,true)
    }
}
val Context.database : MyDatabaseOpenHelper
    get() = MyDatabaseOpenHelper.getInstance(applicationContext)
