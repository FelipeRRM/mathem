package com.feliperrm.mathem.dateselector.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.feliperrm.mathem.dateselector.ui.datesList.DateListScreen
import com.feliperrm.mathem.dateselector.ui.datesList.DateListScreenRoute
import com.feliperrm.mathem.dateselector.ui.deliveryConfirmation.DeliveryConfirmationScreen
import com.feliperrm.mathem.dateselector.ui.deliveryConfirmation.DeliveryConfirmationScreenRoute
import com.feliperrm.mathem.dateselector.ui.deliveryList.DeliveryListScreen
import com.feliperrm.mathem.dateselector.ui.deliveryList.DeliveryListScreenRoute
import com.feliperrm.mathem.dateselector.ui.deliverySuccess.DeliverySuccessScreen
import com.feliperrm.mathem.dateselector.ui.deliverySuccess.DeliverySuccessScreenRoute

@Composable
fun DateSelectorNavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DateListScreenRoute.route) {
        composable(DateListScreenRoute.route) { DateListScreen(onDateClick = { clickedDate -> navController.navigate(DeliveryListScreenRoute.builder(clickedDate)) }) }
        composable(DeliveryListScreenRoute.route) { backStackEntry ->
            DeliveryListScreen(
                backStackEntry.arguments!!.getString(DeliveryListScreenRoute.dateArgument)!!,
                onDeliverySlotClicked = { deliverySlotClicked -> navController.navigate(DeliveryConfirmationScreenRoute.builder(deliverySlotClicked.id)) })
        }
        composable(DeliveryConfirmationScreenRoute.route) { DeliveryConfirmationScreen { navController.navigate(DeliverySuccessScreenRoute.route) { popUpTo(0) } } }
        composable(DeliverySuccessScreenRoute.route) { DeliverySuccessScreen() }
    }

}
