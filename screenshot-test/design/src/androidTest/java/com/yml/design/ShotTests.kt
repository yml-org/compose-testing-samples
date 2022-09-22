package com.yml.design

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.airbnb.android.showkase.models.Showkase
import com.airbnb.android.showkase.models.ShowkaseBrowserComponent
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import com.karumi.shot.ScreenshotTest
import com.karumi.shot.compose.ComposeScreenshotRunner
import com.karumi.shot.compose.ScreenshotMetadata
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class ShotTests : ScreenshotTest {

    object Previews : TestParameter.TestParameterValuesProvider {
        override fun provideValues(): List<ComponentPreview> =
            Showkase.getMetadata().componentList.map(::ComponentPreview)
    }

    @get:Rule
    val composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<TestActivity>, TestActivity> =
        createAndroidComposeRule()


    @Test
    fun tests(
        @TestParameter(valuesProvider = Previews::class)
        componentPreview: ComponentPreview,
        @TestParameter(value = ["en"])
        locale: String,
        @TestParameter(value = ["light"])
        uiMode: String
    ) {

        TestActivity.locale = locale
        composeTestRule.activityRule.scenario.recreate()

        composeTestRule.setContent {
            CompositionLocalProvider(LocalConfiguration provides LocalConfiguration.current.apply {
                this.uiMode =
                    if (uiMode == "dark") Configuration.UI_MODE_NIGHT_YES
                    else Configuration.UI_MODE_NIGHT_NO
            }) {
                componentPreview.content()
            }
        }

        compareScreenshot(
            composeTestRule,
            screenshotName(componentPreview.toString(), locale, uiMode)
        )
    }

    private fun screenshotName(component: String, locale: String, uiMode: String): String {
        return "${component}_${locale}_$uiMode"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun compareScreenshot(node: SemanticsNodeInteraction, name: String?) {
        disableFlakyComponentsAndWaitForIdle()
        val testClassName = this::class.simpleName
        val screenshotName = "${testClassName}_$name"
        val data = ScreenshotMetadata(
            name = screenshotName,
            testClassName = testClassName ?: "",
            testName = name ?: ""
        )
        val composeScreenshot = ComposeScreenshotRunner.composeScreenshot
        if (composeScreenshot != null) {
            composeScreenshot.saveScreenshot(node, data)
        } else {
            throw IllegalStateException("Shot couldn't take the screenshot. Ensure your project uses ShotTestRunner as your instrumentation test runner.")
        }
    }
}

class ComponentPreview(
    private val skBrowser: ShowkaseBrowserComponent
) {
    val content: @Composable () -> Unit = skBrowser.component
    override fun toString(): String =
        skBrowser.group + "_" + skBrowser.componentName
}


