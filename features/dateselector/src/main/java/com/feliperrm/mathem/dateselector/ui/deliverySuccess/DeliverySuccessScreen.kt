package com.feliperrm.mathem.dateselector.ui.deliverySuccess

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.feliperrm.mathem.dateselector.R
import com.feliperrm.mathem.theme.ui.MathemTheme

object DeliverySuccessScreenRoute {
    const val route = "Success"
}

@Composable
fun DeliverySuccessScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {

            Text(
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                text = "Congratulations! Your delivery has been booked!"
            )

            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_party))
            LottieAnimation(composition)

        }

    }
}

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    MathemTheme {
        DeliverySuccessScreen()
    }
}
