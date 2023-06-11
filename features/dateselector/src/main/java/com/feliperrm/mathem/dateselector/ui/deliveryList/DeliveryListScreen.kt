package com.feliperrm.mathem.dateselector.ui.deliveryList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.feliperrm.mathem.datedatabase.data.LocalDeliveryDateModel
import com.feliperrm.mathem.dateselector.ui.MathemListItem
import com.feliperrm.mathem.theme.ui.MathemTheme

object DeliveryListScreenRoute {
    const val dateArgument = "dateString"
    const val route = "DeliveryListScreen/{$dateArgument}"
    fun builder(date: String) = "DeliveryListScreen/$date"
}


@Composable
fun DeliveryListScreen(date: String, onDeliverySlotClicked: (LocalDeliveryDateModel) -> Unit) {
    val vm: DeliverySelectorViewModel = hiltViewModel()
    val uiState by vm.stateUi.collectAsState()
    DeliveryListScreen(date, uiState, { isHomeDeliveryOnlyChecked -> vm.isHomeDeliveryChanged(isHomeDeliveryOnlyChecked) }, { onDeliverySlotClicked.invoke(it) })
}

@Composable
private fun DeliveryListScreen(date: String, uiState: DeliveryListUiState, onHomeDeliveryOnlyCheckChanged: (Boolean) -> Unit, onDeliveryClicked: (LocalDeliveryDateModel) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        when (uiState) {
            is DeliveryListUiState.Loading -> CircularProgressIndicator()
            is DeliveryListUiState.Ui -> LazyColumn(
                modifier = Modifier
                    .fillMaxSize()

            ) {

                item {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Showing Deliveries For Date $date"
                    )
                }

                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = uiState.isHomeDeliveryChecked, onCheckedChange = { onHomeDeliveryOnlyCheckChanged(it) })
                        Text(text = "Show only in-home deliveries")
                    }
                }

                items(uiState.deliverySlots, key = { it.id }) {
                    DeliveryListItem(deliveryTime = it, onDeliverySlotClicked = onDeliveryClicked)
                }
            }
        }
    }
}

@Composable
fun DeliveryListItem(deliveryTime: LocalDeliveryDateModel, onDeliverySlotClicked: (LocalDeliveryDateModel) -> Unit) {
    MathemListItem {
        Column(
            modifier = Modifier
                .clickable { onDeliverySlotClicked(deliveryTime) }
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Date: ${deliveryTime.date}\nStart Time: ${deliveryTime.startTime}\nStop Time: ${deliveryTime.stopTime}\nHome Delivery: ${deliveryTime.inHomeAvailable}")
            Spacer(modifier = Modifier.size(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MathemTheme {
        DeliveryListScreen("123", uiState = DeliveryListUiState.Loading, onHomeDeliveryOnlyCheckChanged = {}, onDeliveryClicked = {})
    }
}
