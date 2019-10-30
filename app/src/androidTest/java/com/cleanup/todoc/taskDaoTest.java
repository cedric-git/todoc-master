package com.cleanup.todoc;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.cleanup.todoc.database.dao.TodocDatabase;
import com.cleanup.todoc.model.Task;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class taskDaoTest {

    // FOR DATA
    private TodocDatabase database;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void initDb() throws Exception {
        this.database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                TodocDatabase.class)
                .allowMainThreadQueries()
                .build();
    }

//    todo inserer 1 ou 2 projet

    @After
    public void closeDb() throws Exception {
        database.close();
    }

    // DATA SET FOR TEST
    private static int TASK_ID = 1;
    private static Task TASK_DEMO = new Task(TASK_ID, 1, "Task 1",12);


    @Test
    public void insertAndGetTask() throws InterruptedException {

        // BEFORE : Adding a new task
        this.database.taskDao().insertTask(TASK_DEMO);

        // TEST
        List<Task> tasks = LiveDataTestUtil.getValue(this.database.taskDao().getTasks()); //    <<<<<<<<<<<<

        assertTrue(tasks.get(TASK_ID).getName().equals(TASK_DEMO.getName()) && tasks.get(TASK_ID).getId() == TASK_ID);
    }
}