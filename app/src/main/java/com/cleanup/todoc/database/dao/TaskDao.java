package com.cleanup.todoc.database.dao;

//  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

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
    LiveData<List<Task>> getTasks();

    @Query("SELECT * FROM tasks ")
    LiveData<List<Task>> getAllTasks();

//    @Query("SELECT * FROM tasks ")
//    LiveData<List<Task>> clearAllTasks();

//    @Query("DELETE FROM tasks WHERE id = :taskId")
//    void deleteTaskById(int taskId);

    @Insert
    void insertTask(Task task);

    @Delete
    void deleteTask(Task task);
}

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>