package eu.roggstar.contractlister;

import android.database.sqlite.SQLiteDatabase;

abstract class DBHelper {

    public DBHelper(){

    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS contract(" +
                        "id integer primary key autoincrement," +
                        "title text not null," +
                        "company text not null," +
                        "customerNumber text," +
                        "contractNumber text," +
                        "startDate text," +
                        "endDate text," +
                        "resignDate text," +
                        "active integer(1) not null default 1" +
                        ")"
        );

        db.execSQL("INSERT INTO contract(title,company,customerNumber,contractNumber,startDate,endDate,resignDate,active) VALUES('Phils Vertrag','Mobilcom-Schwebischall','CustomerNr','ContractNr','0000-00-00','0000-00-00','0000-00-00',1);");
    }
}
