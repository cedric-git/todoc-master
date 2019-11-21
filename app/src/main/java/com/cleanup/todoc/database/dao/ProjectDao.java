package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
//import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.cleanup.todoc.model.Project;

import java.util.List;

//  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

@Dao
public interface ProjectDao {


//    @Insert(onConflict = OnConflictStrategy.REPLACE)    //  *****************
//    void createProject(Project project);    //  *******************

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProjects(Project... projects);

    @Query("SELECT * FROM projects")
    LiveData<List<Project>> getProjects();

//    @Query("SELECT * FROM projects WHERE id = :projectId")   //  **********
//    LiveData<Project> getProject(long projectId);   //  ********

//    @Delete
//    void delete(Project project);

    @Query("SELECT * FROM projects ")   //  **********
    LiveData<List<Project>> getAllProjects();   //  **********

}

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>