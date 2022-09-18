package com.kursatkumsuz.marsrealestate.room

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.kursatkumsuz.marsrealestate.getOrAwaitValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@SmallTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
class MarsDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("testDatabase")
    lateinit var database: MarsDatabase

    private lateinit var dao: MarsDao

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.marsDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertTesting() = runBlockingTest {
        val exampleData = MarsEntity(4574, "4544", "buy", "www.test.com", 1)
        dao.insert(exampleData)

        val list = dao.getMars().getOrAwaitValue()
        assertThat(list).contains(exampleData)
    }

    @Test
    fun deleteTesting() = runBlockingTest {
        val exampleData = MarsEntity(4574, "4544", "buy", "www.test.com", 1)
        dao.insert(exampleData)
        dao.delete(exampleData)

        val list = dao.getMars().getOrAwaitValue()
        assertThat(list).doesNotContain(exampleData)
    }

    @Test
    fun deleteAllDataTesting() = runBlockingTest {
        val exampleData = MarsEntity(4574, "4544", "buy", "www.test.com", 1)
        dao.insert(exampleData)
        dao.deleteAllData()

        val list = dao.getMars().getOrAwaitValue()
        assertThat(list).doesNotContain(exampleData)
    }
}