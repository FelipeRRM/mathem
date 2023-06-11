package com.feliperrm.mathem.dateselector.ui.datesList

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
import com.feliperrm.mathem.dateselector.ui.MathemListItem
import com.feliperrm.mathem.theme.ui.MathemTheme

object DateListScreenRoute {
    const val route = "DateListScreen"
}

@Composable
fun DateListScreen(onDateClick: (String) -> Unit) {
    val vm: DateSelectorViewModel = hiltViewModel()
    val uiState by vm.stateUi.collectAsState()
    DateListScreen(uiState, onDateClick)
}

@Composable
private fun DateListScreen(uiState: DateListUiState, onDateClick: (String) -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (uiState) {
            is DateListUiState.Loading -> CircularProgressIndicator()
            is DateListUiState.Ui -> LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            ) {
                item {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Select a date for your delivery"
                    )
                }
                items(uiState.dates, key = { it.date }) {
                    DateListItem(date = it.date, onDateClick = onDateClick)
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
private fun DefaultPreview() {
    MathemTheme {
        DateListScreen(uiState = DateListUiState.Loading, onDateClick = {})
    }
}
