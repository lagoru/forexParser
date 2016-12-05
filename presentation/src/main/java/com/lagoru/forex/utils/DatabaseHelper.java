package com.lagoru.forex.utils;

/**
 * Created by lagoru on 17.08.16.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import org.androidannotations.annotations.EBean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
@EBean(scope = EBean.Scope.Singleton)
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "helloAndroid.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    Map<Class, Dao> daoMap = new HashMap<>();
    Map<Class, RuntimeExceptionDao> daoRuntimeMap = new HashMap<>();

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Information.class);
            TableUtils.createTable(connectionSource, InformationAttribute.class);
            TableUtils.createTable(connectionSource, SameInformationFamily.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

        /*// here we try inserting data in the on-create as a test
        RuntimeExceptionDao<Information, String> dao = getSimpleDataDao();
        long millis = System.currentTimeMillis();
        // create some entries in the onCreate
        SimpleData simple = new SimpleData(millis);
        dao.create(simple);
        simple = new SimpleData(millis + 1);
        dao.create(simple);
        Log.i(DatabaseHelper.class.getName(), "created new entries in onCreate: " + millis);*/
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Information.class, true);
            TableUtils.dropTable(connectionSource, InformationAttribute.class, true);
            TableUtils.dropTable(connectionSource, SameInformationFamily.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the Database Access Object (DAO) for our classes. It will create it
     */
    public <A, B> Dao<A, B> getDaoObject(Class<A> clazz) throws SQLException {
        if (!daoMap.containsKey(clazz)) {
            daoMap.put(clazz, getDaoObject(clazz));
        }
        return daoMap.get(clazz);
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public <A, B> RuntimeExceptionDao<A, B> getDaoRuntimeExceptionObject(Class<A> clazz) {
        if (!daoRuntimeMap.containsKey(clazz)) {
            daoRuntimeMap.put(clazz, getRuntimeExceptionDao(clazz));
        }
        return daoRuntimeMap.get(clazz);
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        daoMap.clear();
        daoRuntimeMap.clear();
    }
}