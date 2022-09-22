package com.yml.design.progress

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.yml.design.theme.HealthCareTheme

@Composable
fun HCProgressBar() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.Center),
            strokeWidth = 2.dp
        )
    }
}

//// Skipped right now, as screenshot will be blank
//@ShowkaseComposable(skip = true)
//@Preview(
//    name = "progress",
//    group = "elements"
//)
//@Composable
//fun PreviewProgressBar() {
//    HealthCareTheme {
//        HCProgressBar()
//    }
//}
