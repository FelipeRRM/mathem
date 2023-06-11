package com.feliperrm.mathem.dateselector.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.feliperrm.mathem.theme.ui.MathemTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DateSelectorActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MathemTheme {
                DateSelectorNavGraph()
            }
        }
    }
}
