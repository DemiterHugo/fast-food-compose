package com.example.recipes

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


class ExampleInstrumentedTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext(): Unit {
        composeTestRule.setContent {

            var text by remember{ mutableStateOf("Init text")}
            Button(onClick = { text = "Final text" }) {
                Text(text = text)
            }
        }
        composeTestRule.onNodeWithText("Init text").performClick()
        composeTestRule.onNodeWithText("Final text")

    }
}