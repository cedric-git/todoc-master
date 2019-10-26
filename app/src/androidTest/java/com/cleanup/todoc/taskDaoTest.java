//package com.cleanup.todoc;
//
//import android.arch.core.executor.testing.InstantTaskExecutorRule;
//import android.arch.persistence.room.Room;
//import android.support.test.InstrumentationRegistry;
//import android.support.test.runner.AndroidJUnit4;
//
//import com.cleanup.todoc.database.dao.TodocDatabase;
//import com.cleanup.todoc.model.Task;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static org.junit.Assert.assertTrue;
//
//
//@RunWith(AndroidJUnit4.class)
//public class taskDaoTest {
//
//    // FOR DATA
//    private TodocDatabase database;
//
//    @Rule
//    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
//
//    @Before
//    public void initDb() throws Exception {
//        this.database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
//                TodocDatabase.class)
//                .allowMainThreadQueries()
//                .build();
//    }
//
//    @After
//    public void closeDb() throws Exception {
//        database.close();
//    }
//
//    // DATA SET FOR TEST
//    private static long USER_ID = 1;
//    private static Task USER_DEMO = new Task(USER_ID, "Philippe", "https://www.google.fr, ");
//
//
//    @Test
//    public void insertAndGetUser() throws InterruptedException {
//        // BEFORE : Adding a new user
//        this.database.taskDao().insertTask(USER_DEMO);
//        // TEST
//        User user = LiveDataTestUtil.getValue(this.database.userDao().getUser(USER_ID));
//        assertTrue(user.getUsername().equals(USER_DEMO.getUsername()) && user.getId() == USER_ID);
//    }
//
//    @Test
//    public void insertAndGetUser() throws InterruptedException {
//        // BEFORE : Adding a new user
//        this.database.userDao().createUser(USER_DEMO);
//        // TEST
//        User user = LiveDataTestUtil.getValue(this.database.userDao().getUser(USER_ID));
//        assertTrue(user.getUsername().equals(USER_DEMO.getUsername()) && user.getId() == USER_ID);
//    }
//}