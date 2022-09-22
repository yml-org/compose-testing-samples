package com.yml.launcher

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test

/**
 * Note paparazi is not available in android test
 */
class SplashDestinationKtTest {

    private val PERCENT_DIFFERENCE = 0.9

    @get:Rule
    val paparazzi = Paparazzi(
        maxPercentDifference = PERCENT_DIFFERENCE,
        deviceConfig = DeviceConfig.PIXEL_XL
    )


    @Test
    @Ignore
    fun `record splash screen and verify`() {
        paparazzi.snapshot("splash") {
            SplashDestination {

            }
        }
    }
}