package com.cleanup.todoc.database.dao;

//  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CRUD style for Room

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM tasks")
    LiveData<List<Task>> getTasks();//  to get projects from table (repository) / READ

    @Query("SELECT * FROM tasks ")
    LiveData<List<Task>> getAllTasks(); //  used in the test

    @Insert
    void insertTask(Task task); //  for test and repository / CREATE

    @Delete
    void deleteTask(Task task);//  for test and repository / DELETE
}

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>