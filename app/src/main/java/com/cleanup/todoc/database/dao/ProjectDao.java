package com.cleanup.todoc.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.content.ClipData;

import com.cleanup.todoc.model.Project;

import java.util.List;

//  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

@Dao
public interface ProjectDao {
    @Query("SELECT * FROM projects")
    LiveData<List<Project>> getProjects();
//    LiveData<List<Item>> getItems(long userId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProjects(Project projects);

//    @Update
//    int updateProjects(ClipData.Item item);  // Clip Data ???

//    @Query("DELETE FROM projects WHERE id = :id")
//    int deleteProjects(long id);
}

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>