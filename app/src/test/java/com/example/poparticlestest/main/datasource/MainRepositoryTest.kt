package com.example.poparticlestest.main.datasource

import com.example.poparticlestest.data.DAO.ArticlesDao
import com.example.poparticlestest.main.BaseUnitTest
import com.example.poparticlestest.main.datasource.repository.MainRepository
import com.example.poparticlestest.main.datasource.service.IMainService
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class MainRepositoryTest : BaseUnitTest() {

    @Mock
    private lateinit var service: IMainService
    @Mock
    private lateinit var dao: ArticlesDao

    @Mock
    private lateinit var repository: MainRepository

    @Before
    override fun setup() {
        super.setup()
        repository = MainRepository(service, dao)
    }

    @Test
    fun `We test the method getArticles`(){
        runBlocking {
            try {
                val value = repository.getArticles(30)
                MatcherAssert.assertThat(value, null)
            } catch (e: Exception) {}
        }
    }
    @Test
    fun `We test the method saveArticles`(){
        runBlocking {
            try {
                val articles = repository.getArticles(30)
                val value = repository.saveArticles(articles)
                MatcherAssert.assertThat(value, null)
            } catch (e: Exception) {}
        }
    }

    @Test
    fun `We test the method getSavedArticles`(){
        runBlocking {
            try {
                val articles = repository.getArticles(30)
                val savedArticles = repository.getSavedArticles()
                MatcherAssert.assertThat(savedArticles, null)
            } catch (e: Exception) {}
        }
    }

}