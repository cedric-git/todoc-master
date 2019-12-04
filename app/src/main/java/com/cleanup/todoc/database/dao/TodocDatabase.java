package com.cleanup.todoc.database.dao;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

//  <<<<<<<<<<<<<<<<<<<<<<<<< Configure database and link interfaces/classes together

//  Create database and declare the tables
@Database(entities = {Project.class, Task.class}, version = 1, exportSchema = false)
public abstract class TodocDatabase extends RoomDatabase {

    //Singleton (to restrict instanciation to a single object)
    private static volatile TodocDatabase INSTANCE;

    //Field
    private static Project[] projects = Project.getAllProjects();   //  to delete

    //Instance
    public static TodocDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (TodocDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), // Build Instance
                            TodocDatabase.class,
                            "TodocDatabase.db")
                            .addCallback(prepopulateDatabase())
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback prepopulateDatabase() {
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);

                Project[] projects = Project.getAllProjects();
                for (Project project : projects) {
                    ContentValues contentValues = new ContentValues();  //  Populate
                    contentValues.put("name", project.getName());
                    contentValues.put("color", project.getColor());

                    db.insert("projects", OnConflictStrategy.IGNORE, contentValues);
                }
            }
        };
    }

    public abstract ProjectDao projectDao();

    public abstract TaskDao taskDao();

}

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>