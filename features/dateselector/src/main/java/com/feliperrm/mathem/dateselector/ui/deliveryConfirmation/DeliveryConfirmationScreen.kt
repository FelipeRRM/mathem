package com.feliperrm.mathem.dateselector.ui.deliveryConfirmation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
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

object DeliveryConfirmationScreenRoute {
    const val deliverySlotIdArgument = "deliverySlotId"
    const val route = "Confirmation/{$deliverySlotIdArgument}"
    fun builder(deliveryId: String) = "Confirmation/$deliveryId"
}

@Composable
fun DeliveryConfirmationScreen(onConfirmClicked: (LocalDeliveryDateModel) -> Unit) {
    val vm: DeliveryConfirmationViewModel = hiltViewModel()
    val uiState by vm.stateUi.collectAsState()
    DeliveryConfirmationScreen(uiState, onConfirmClicked)
}

@Composable
private fun DeliveryConfirmationScreen(uiState: DeliveryConfirmationUiState, onDeliveryClicked: (LocalDeliveryDateModel) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        when (uiState) {
            is DeliveryConfirmationUiState.Loading -> CircularProgressIndicator()
            is DeliveryConfirmationUiState.Ui -> Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {

                Text(
                    modifier = Modifier.padding(16.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = "You are about to book the following delivery. Please double-check before confirming."
                )

                DeliveryConfirmationItem(deliveryTime = uiState.selectedDelivery)

                Button(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    onClick = { onDeliveryClicked.invoke(uiState.selectedDelivery) }) {
                    Text(text = "Confirm & Book Delivery")
                }

            }
        }
    }
}

@Composable
fun DeliveryConfirmationItem(deliveryTime: LocalDeliveryDateModel) {
    MathemListItem {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Date: ${deliveryTime.date}\nStart Time: ${deliveryTime.startTime}\nStop Time: ${deliveryTime.stopTime}\nHome Delivery: ${deliveryTime.inHomeAvailable}",
                fontSize = 17.sp
            )
            Spacer(modifier = Modifier.size(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MathemTheme {
        DeliveryConfirmationScreen(uiState = DeliveryConfirmationUiState.Loading, onDeliveryClicked = {})
    }
}
