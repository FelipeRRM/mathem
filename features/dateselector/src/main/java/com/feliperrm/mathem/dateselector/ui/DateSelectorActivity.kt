package com.feliperrm.mathem.dateselector.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.feliperrm.mathem.theme.ui.MathemTheme
import getViewModel

class DateSelectorActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm: DateSelectorViewModel = getViewModel { DateSelectorViewModel() }
        setContent {
            MathemTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val uiState by vm.stateUi.collectAsState()
                    DateListScreen(uiState = uiState, onDateClick = { clickedDate -> })
                }
            }
        }
    }
}

@Composable
fun DateListScreen(uiState: DateListUiState, onDateClick: (String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (uiState) {
            is DateListUiState.Loading -> CircularProgressIndicator()
            is DateListUiState.Ui -> LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            ) {
                items(uiState.dates, key = { it }) {
                    DateListItem(date = it, onDateClick = onDateClick)
                }
            }
        }
    }
}

@Composable
fun DateListItem(date: String, onDateClick: (String) -> Unit) {
    MathemListItem {
        Column(
            modifier = Modifier
                .clickable { onDateClick(date) }
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = date)
            Spacer(modifier = Modifier.size(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MathemTheme {
        DateListScreen(uiState = DateListUiState.Loading, onDateClick = {})
    }
}
