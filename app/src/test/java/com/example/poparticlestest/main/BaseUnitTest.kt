package com.example.poparticlestest.main

import android.app.Application
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.io.File

@RunWith(MockitoJUnitRunner.Silent::class)
abstract class BaseUnitTest {


    protected val testDispatcher = TestCoroutineDispatcher()



    @Mock
    protected lateinit var mockAplication: Application



    @Before
    open fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(testDispatcher)
    }


    @After
    open fun tearDown() {
        testDispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()

    }

    fun getJson(path : String) : String {
        val uri = javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)

        return String(file.readBytes())
    }

}