package com.yml.design.error

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yml.core.constants.Resource
import com.yml.core.utils.isPresent
import com.yml.design.R
import com.yml.design.elements.Description
import com.yml.design.elements.HCButton
import com.yml.design.elements.SubHeading
import com.yml.design.theme.HealthCareTheme

internal object TestTag {
    const val ErrorScreenButton = "error_screen_button"
    const val ErrorScreenTitle = "error_screen_title"
    const val ErrorScreenDesc = "error_screen_description"
    const val ErrorScreenImg = "error_screen_img"
}

@Composable
fun ErrorWidget(
    modifier: Modifier,
    data: ErrorData,
    ctaClick: () -> Unit = {} // optional click action
) {
    Column(
        modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (Resource.NONE != data.icon) {
            Icon(
                modifier = Modifier.testTag(TestTag.ErrorScreenImg),
                painter = painterResource(id = data.icon),
                contentDescription = stringResource(R.string.cd_error_screen_image)
            )
        }
        SubHeading(
            text = data.title,
            Modifier
                .padding(top = 10.dp)
                .testTag(TestTag.ErrorScreenTitle),
            color = MaterialTheme.colors.primary
        )

        Description(
            text = data.description,
            Modifier
                .testTag(TestTag.ErrorScreenDesc)
                .padding(top = 10.dp)
        )

        if (data.button.isPresent()) {
            HCButton(
                title = data.button!!, onClick = ctaClick, modifier = Modifier
                    .testTag(TestTag.ErrorScreenButton)
                    .padding(top = 10.dp)
            )
        }
    }
}

//@Preview(
//    group = "error",
//    name = "error-screen",
//    showSystemUi = true,
//    showBackground = true,
//    device = Devices.PIXEL_4_XL,
//    uiMode = UI_MODE_NIGHT_YES
//)
//@Composable
//fun ErrorWidgetPreview() {
//
//    HealthCareTheme {
//        ErrorWidget(
//            modifier = Modifier.fillMaxWidth(), data = ErrorData(
//                title = stringResource(id = R.string.preview_error_title),
//                description = stringResource(id = R.string.preview_error_description),
//                button = stringResource(id = R.string.preview_retry),
//                icon = R.drawable.ic_home
//            )
//        )
//    }
//}