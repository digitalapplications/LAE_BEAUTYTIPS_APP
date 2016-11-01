package example.itsme.beautytipsproject;

import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

/**
 * Created by itsme on 10/15/2016.
 */

public class beautyOpenHelper extends SQLiteOpenHelper {


    SQLiteDatabase database;
    beautyDataSource dataSource;

    public static final String LOGTAG = "EXPLORECA";

    public static final String DATABASE_NAME = "beautydb";
    public static final String TABLE_NAME = "tours_table";

    public static final String COL_ID = "ID";
    public static final String COL_TITLE = "TITLE";
    public static final String COL_TYPE = "TYPE";
    public static final String COL_DESC1 = "DESCRIPTION_FIRST";
    public static final String COL_DESC2 = "DESCRIPTION_MID";
    public static final String COL_DESC3 = "DESCRIPTION_LAST";
    public static final String COL_IMAGE1 = "IMAGE_FIRST";
    public static final String COL_IMAGE2 = "IMAGE_MID";
    public static final String COL_IMAGE3= "IMAGE_LAST";



    public beautyOpenHelper(Context context) {super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,TITLE TEXT,TYPE TEXT,DESCRIPTION_FIRST TEXT,DESCRIPTION_MID TEXT,DESCRIPTION_LAST TEXT,IMAGE_FIRST TEXT,IMAGE_MID TEXT,IMAGE_LAST TEXT)");
        Log.i(LOGTAG,"table has been created");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

/////////////////////////// Delete Data From SQlite DataBase //////////////////////////////////////


}
