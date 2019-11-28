package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

//  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< CRUD style for Room

@Dao
public interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    void insertProjects(Project... projects);   //  <<<<<<  for Testing / CREATE

    @Query("SELECT * FROM projects")
    LiveData<List<Project>> getProjects();  //  <<<<<   to get projects from table / READ


    @Query("SELECT * FROM projects ")
    LiveData<List<Project>> getAllProjects();   //  (for TodocDatabase, ...)

}

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>