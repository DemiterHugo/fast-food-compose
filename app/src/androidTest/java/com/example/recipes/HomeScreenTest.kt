package com.example.recipes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import arrow.core.Either
import arrow.core.right
import coil.annotation.ExperimentalCoilApi
import com.example.recipes.data.entities.Nutrition
import com.example.recipes.data.entities.Pizza
import com.example.recipes.data.entities.Sushi
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.network.entities.pizzas.CaloricBreakdown
import com.example.recipes.data.network.entities.pizzas.Nutrient
import com.example.recipes.ui.screens.common.ITEM_CLICK
import com.example.recipes.ui.screens.common.ItemsListScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoilApi
@ExperimentalFoundationApi
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val ctx = InstrumentationRegistry.getInstrumentation().targetContext

    val sushis: List<Sushi> = (0..9).map {
        Sushi(
            id = it,
            price = "$it €",
            title = "title $it",
            image = "image $it",
            restaurantChain = "restaurantChain $it",
            servingSize = "servingSize $it",
            nutrition = Nutrition(
                caloricBreakdown = CaloricBreakdown(
                    percentCarbs = it.toDouble(),
                    percentFat = it.toDouble(),
                    percentProtein = it.toDouble()
                ),
                calories = 1.0,
                carbs = "carbs $it",
                fat = "fat $it",
                nutrients = emptyList<Nutrient>(),
                protein = "protein $it"
            )
        )
    }
    @ExperimentalMaterialApi
    @Before
    fun Setup(){
        composeTestRule.setContent {
            ItemsListScreen(items = Either.Right(sushis), onClicked1 = {} )
        }
    }

    @Test
    fun navigateTo9(): Unit = with(composeTestRule){
        onNode(hasScrollToIndexAction()).performScrollToIndex(4)
       Thread.sleep(2000)
    }

    @Test
    fun navigateTo9AndShowsBottomSheet(): Unit = with(composeTestRule){
        onNode(hasScrollToIndexAction()).performScrollToIndex(4)
        onNode(hasParent(hasText("title 9")) and
                hasContentDescription(ctx.getString(R.string.more_options))
        ).performClick()

        onNode(hasAnySibling(hasText(ctx.getString(R.string.go_to_detail))) and
                hasText("title 9")
        ).assertExists()
        Thread.sleep(2000)
    }

    @Test
    fun clickItem9():Unit = with(composeTestRule){

        onNode(hasScrollToIndexAction()).performScrollToIndex(4).performClick()

        Thread.sleep(2000)



    }
}