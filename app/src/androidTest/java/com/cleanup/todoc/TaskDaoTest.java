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

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class TaskDaoTest {

    private TaskDao mTaskDao;
    private ProjectDao mProjectDao;
    private TodocDatabase database;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();

        database = Room.inMemoryDatabaseBuilder(context, TodocDatabase.class).allowMainThreadQueries().build(); //  use Room
        mTaskDao = database.taskDao();
        mProjectDao = database.projectDao();
    }

    @Before
    public void addProject() {                                                  //  insert 1 project
        Project tartampion = new Project(1, "Tartampion", Color.RED);
        mProjectDao.insertProjects(tartampion);
    }

    @After
    public void closeDb() {
        database.close();
    }


    @Test
    public void insertAndGetTask() throws InterruptedException {    //  'GET TASK'

        Task task = new Task(1, "Task 0", 0000);  //  create task
        mTaskDao.insertTask(task);                                               //  insert task
        List<Task> tasks = LiveDataTestUtil.getValue(mTaskDao.getAllTasks());    //  list all tasks
        assertEquals(1, tasks.size());                                  //  check size is 1
        assertEquals(task.getName(), tasks.get(0).getName());                    //   check name is same
    }

    @Test
    public void deleteTask() throws InterruptedException {  //  'DELETE TASK'

        Task task = new Task(1, "Task 2", 2222);    //  create task
        mTaskDao.insertTask(task);                                                 //  insert task
        List<Task> tasks1 = LiveDataTestUtil.getValue (mTaskDao.getAllTasks());   //  list all tasks
        assertEquals("Task 2", tasks1.get(0).getName());                //   check name is same
        assertEquals(1, tasks1.size());                                 //  check size is 1

        task=tasks1.get(0);                                                     //  set task
        mTaskDao.deleteTask(task) ;                                             //  delete task
        List<Task> tasks2 = LiveDataTestUtil.getValue (mTaskDao.getAllTasks());//  list all tasks
        assertEquals(0, tasks2.size());                               //  check list size back to 0
    }
}
