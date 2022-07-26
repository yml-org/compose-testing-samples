package com.yml.healthcare.home.ui.viewmodel.articles

import com.yml.design.error.ErrorData
import com.yml.healthcare.home.domain.model.Article

sealed class ArticlesViewState(val screenTitle: String = "Articles") {
    class UnInitialized : ArticlesViewState()
    class InitialLoading : ArticlesViewState()
    class Loaded(val data: List<Article>) : ArticlesViewState()
    class Error(val error: ErrorData) : ArticlesViewState()
}

sealed class ArticleUserIntent {
    class NavigateToDetails(val url: String) : ArticleUserIntent()
    object FetchArticles : ArticleUserIntent()
}

sealed class ArticlesNavEffect {
    class NavigateToArticleDetail(val url: String) : ArticlesNavEffect()

    class SnackMessage(val message: String) : ArticlesNavEffect()
}