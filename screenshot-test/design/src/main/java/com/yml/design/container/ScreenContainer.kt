package com.yml.design.container

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yml.core.constants.Resource
import com.yml.design.R
import com.yml.design.error.ErrorData
import com.yml.design.error.ErrorWidget
import com.yml.design.snackbar.SnackMessage
import com.yml.design.theme.HealthCareTheme
import com.yml.design.toolbar.HCToolBar

@Composable
fun HCToolBarScreen(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes
    headerImage: Int = Resource.NONE,
    @DrawableRes
    leftIcon: Int = Resource.NONE,
    @DrawableRes
    rightIcon: Int = Resource.NONE,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {},
    content: @Composable ColumnScope.(
        modifier: Modifier,
        snackMessage: (message: String) -> Unit
    ) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        HCToolBar(
            title = title,
            headerImage = headerImage,
            leftIcon = leftIcon,
            rightIcon = rightIcon,
            onLeftIconClick = onLeftIconClick,
            onRightIconClick = onRightIconClick
        )

        val state = remember { mutableStateOf("") }

        val hostState = remember { SnackbarHostState() }
        Box {
            Column {
                content(Modifier.padding(top = 6.dp)) {
                    state.value = it
                }
            }
            SnackbarHost(
                hostState = hostState,
                snackbar = { data ->
                    SnackMessage(
                        description = state.value
                    )
                }
            )
        }

        LaunchedEffect(key1 = state.value) {
            val message = state.value
            if (message.isNotEmpty()) {
                hostState.showSnackbar(message)
            }
        }
    }
}

//@Preview(
//    name = "toolbar-screen",
//    group = "container",
//    locale = "en"
//)
//@Composable
//fun PreviewFullScreen() {
//    HealthCareTheme {
//        HCToolBarScreen(
//            title = "Search",
//            leftIcon = R.drawable.ic_menu_burger
//        ) { modifier, _ ->
//            ErrorWidget(
//                modifier = modifier.fillMaxSize(),
//                data = ErrorData(
//                    title = stringResource(id = R.string.preview_error_title),
//                    description = stringResource(id = R.string.preview_error_description),
//                    button = stringResource(id = R.string.preview_retry),
//                    icon = R.drawable.ic_home
//                )
//            )
//        }
//    }
//}