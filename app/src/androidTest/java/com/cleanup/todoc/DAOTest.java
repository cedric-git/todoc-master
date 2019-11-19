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
import com.cleanup.todoc.model.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class DAOTest {

    private TaskDao mTaskDao;
    private ProjectDao mProjectDao;
    private TodocDatabase database;


    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        database = Room.inMemoryDatabaseBuilder(context, TodocDatabase.class).build();
        mTaskDao = database.taskDao();
        mProjectDao = database.projectDao();
    }

    public void initDatabase() {
        this.database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), TodocDatabase.class)
            .allowMainThreadQueries()
            .build();
}

    @Before
    public void addProject() {
        Project tartampion = new Project(1, "Tartampion", Color.RED);
        mProjectDao.insertProjects(tartampion);
    }

    @After
    public void closeDb() throws IOException {
        database.close();
    }

    @Test
    public void getProjects() {
//
//        List<Project> projects = mProjectDao.getAllProjects();
//        assertEquals("Tartampion", projects.get(0).getName());
    }

    @Test
    public void insertTask() {
//
//        Task task = new Task(1, "Task 1", 1111);
//        mTaskDao.insertTask(task);
//        List<Task> tasks = mTaskDao.getAllTasks();
//        assertEquals(1, tasks.size());
    }

    @Test
    public void deleteTask(){
//
//        Task task = new Task(1, "Task 2", 2222);
//        mTaskDao.insertTask(task);
//        List<Task> tasks1 = mTaskDao.getAllTasks();
//        assertEquals("test", tasks1.get(0).getName());
//
//        mTaskDao.deleteTask(task);
//        List<Task> tasks2 = mTaskDao.getAllTasks();
//        assertEquals(0, tasks2.size());
    }
}
