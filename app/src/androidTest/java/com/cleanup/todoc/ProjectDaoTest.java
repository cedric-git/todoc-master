package com.cleanup.todoc;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.graphics.Color;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.database.dao.TaskDao;
import com.cleanup.todoc.database.dao.TodocDatabase;
import com.cleanup.todoc.model.Project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ProjectDaoTest {

    private TaskDao mTaskDao;
    private ProjectDao mProjectDao;
    private TodocDatabase database;


    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();

        database = Room.inMemoryDatabaseBuilder(context, TodocDatabase.class).allowMainThreadQueries().build();
        mTaskDao = database.taskDao();
        mProjectDao = database.projectDao();
    }

    @After
    public void closeDb() {
        database.close();
    }

    @Test
    public void getProjects() throws InterruptedException{
        //  insert
        List<Project> projects ;

        Project tartampion = new Project(1, "Tartampion", Color.RED);
        mProjectDao.insertProjects(tartampion);

        projects = LiveDataTestUtil.getValue(this.database.projectDao().getProjects());
        assertEquals(tartampion.getName(), projects.get(0).getName());
        assertEquals(tartampion.getId(), projects.get(0).getId());
        assertEquals(tartampion.getColor(), projects.get(0).getColor());

        //  get
        assertEquals("Tartampion", projects.get(0).getName());
    }

}
