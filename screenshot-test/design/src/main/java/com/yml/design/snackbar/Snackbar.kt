package com.yml.design.snackbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.yml.design.R
import com.yml.design.elements.Description
import com.yml.design.theme.HealthCareTheme

@Composable
fun SnackMessage(
    description: String,
    bgColor: Color = MaterialTheme.colors.primary
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        backgroundColor = bgColor,
        elevation = 3.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        Description(
            text = description,
            modifier = Modifier.padding(8.dp),
            textColor = LocalContentColor.current
        )
    }
}


//@Preview
//@Composable
//@ShowkaseComposable("success", "snack")
//fun SnackSuccessPreview() = HealthCareTheme {
//    SnackMessage(description = stringResource(id = R.string.preview_snack_success))
//}
//
//
//@Composable
//@Preview(
//    name = "error",
//    group = "snack"
//)
//fun SnackErrorPreview() = HealthCareTheme {
//    SnackMessage(
//        description = stringResource(id = R.string.preview_snack_error),
//        bgColor = MaterialTheme.colors.error
//    )
//}

class ThemeProvider : PreviewParameterProvider<Boolean> {
    override val count: Int
        get() = super.count
    override val values: Sequence<Boolean>
        get() = sequenceOf(
            true, false
        )
}