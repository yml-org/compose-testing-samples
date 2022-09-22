package com.yml.design.bottomNavigation
//TODO https://www.flaticon.com/uicons
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yml.design.R
import com.yml.design.error.TestTag
import com.yml.design.theme.HealthCareTheme

/**
 * Reusable Bottom Tab, Can be used from any nav host
 */
@Composable
fun <T : BottomNavDestination> HealthCareBottomNavigation(
    isSelected: (T) -> Boolean,
    items: List<T>,
    navigateTo: (T) -> Unit
) {
    BottomNavigation(
        elevation = 5.dp,// TODO move the dimens to proper classes,
        backgroundColor = MaterialTheme.colors.let { if (it.isLight) it.surface else it.primary },
        contentColor = MaterialTheme.colors.primaryVariant
    ) {
        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon()),
                        contentDescription = "" //TODO CDS
                    )
                },
                selected = isSelected(it),
                alwaysShowLabel = false,
                onClick = {
                    navigateTo(it)
                    TestTag.ErrorScreenTitle
                }
            )
        }
    }
}

//@Preview(
//    name = "home_selected",
//    group = "bottom_bar"
//)
//@Composable
//fun BottomBarPreviewHomeSelection() {
//    val items = createMockBottomNavItems()
//    HealthCareTheme {
//        HealthCareBottomNavigation(
//            isSelected = { items.first() == it },
//            items = items,
//            navigateTo = {})
//    }
//}
//
//@Preview(
//    name = "search_selected",
//    group = "bottom_bar"
//)
//@Composable
//fun BottomBarPreviewSearchSelection() {
//    val items = createMockBottomNavItems()
//    HealthCareTheme {
//        HealthCareBottomNavigation(
//            isSelected = { items[1] == it },
//            items = items,
//            navigateTo = {})
//    }
//}
//
//@Preview(
//    name = "profile_selected",
//    group = "bottom_bar"
//)
//@Composable
//fun BottomBarPreviewProfileSelection() {
//    val items = createMockBottomNavItems()
//    HealthCareTheme {
//        HealthCareBottomNavigation(
//            isSelected = { items.last() == it },
//            items = items,
//            navigateTo = {})
//    }
//}

fun createMockBottomNavItems(): List<BottomNavDestination> {
    return mutableListOf<BottomNavDestination>().apply {
        add(object : BottomNavDestination {
            override fun icon() = R.drawable.ic_home
        })
        add(object : BottomNavDestination {
            override fun icon() = R.drawable.ic_search
        })
        add(object : BottomNavDestination {
            override fun icon() = R.drawable.ic_profile
        })
    }
}