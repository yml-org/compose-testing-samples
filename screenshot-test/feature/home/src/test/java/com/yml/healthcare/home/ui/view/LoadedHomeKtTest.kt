package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.cash.paparazzi.Paparazzi
import com.yml.healthcare.home.domain.model.Article
import com.yml.healthcare.home.domain.model.Blog
import com.yml.healthcare.home.domain.model.HomeDataModel
import org.junit.*

@Ignore
class LoadedHomeKtTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @Before
    fun before() {

    }

    @Test
    fun `verify home screen with only articles`() {
        paparazzi.snapshot("home_articles") {
            LoadedHomeScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                data = HomeDataModel(displayArticles = mockArticleList()),
                userIntent = {}
            )
        }
    }

    @Test
    fun `verify home screen with only blogs`() {
        paparazzi.snapshot("home_blogs") {
            LoadedHomeScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                data = HomeDataModel(displayBlogs = mockBlogList()),
                userIntent = {}
            )
        }
    }

    @Test
    fun `verify home screen with articles and blogs`() {
        paparazzi.snapshot("home_fully_loaded") {
            LoadedHomeScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                data = HomeDataModel(
                    displayArticles = mockArticleList(),
                    displayBlogs = mockBlogList()
                ),
                userIntent = {}
            )
        }
    }

    @After
    fun after() {

    }
}

private fun mockBlogList(): List<Blog> {
    val mock = mutableListOf<Blog>()
    for (i in 0..4) {
        mock.add(
            Blog(
                title = "Lower Costs on market place coverage $i",
                description = "Still need Hearlh Insurance?\nYou can get health coverage for the rest of the year if....",
                url = "",
                tags = listOf("Blog", "Insurance")
            )
        )
    }
    return mock
}

private fun mockArticleList(): List<Article> {
    val mock = mutableListOf<Article>()
    for (i in 0..10) {
        mock.add(
            Article(
                title = "Lower Costs on market place coverage $i",
                description = "Still need Hearlh Insurance?\nYou can get health coverage for the rest of the year if....",
                url = "",
                tags =/* if (i % 2 == 0) listOf("Blog", "Insurance") else*/ listOf()
            )
        )
    }
    return mock
}