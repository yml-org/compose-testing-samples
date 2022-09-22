package com.yml.healthcare.home.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.yml.healthcare.home.domain.model.Article
import org.junit.*

class ArticleListScreenKtTest {

    private val PERCENT_DIFFERENCE = 90.0

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = PERCENT_DIFFERENCE,
        deviceConfig = DeviceConfig.PIXEL_XL
    )

    @Before
    fun before() {

    }

    @Test
    fun `verify article list loaded`() {
        paparazzi.snapshot("articles_loaded") {
            ArticleListScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                data = mockArticleList(),
                userIntent = {}
            )
        }
    }

    @After
    fun after() {

    }
}

private fun mockArticleList(): List<Article> {
    val mock = mutableListOf<Article>()
    for (i in 0..10) {
        mock.add(
            Article(
                title = "Lower Costs on market place coverage $i",
                description = "Still need Hearlh Insurance?\nYou can get health coverage for the rest of the year if....",
                url = "",
                tags = if (i % 2 == 0) listOf("Blog", "Insurance") else listOf()
            )
        )
    }
    return mock
}