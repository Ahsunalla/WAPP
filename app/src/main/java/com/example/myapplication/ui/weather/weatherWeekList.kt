package com.example.myapplication.ui.weather

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp


@Composable
fun WeatherWeekList() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
        val temperatures = listOf(20, 25, 18, 22, 28, 24, 21) // vi har nogle forudbestemt temperature

        items(daysOfWeek.zip(temperatures)) { (day, temperature) ->
            WeatherDayItem(day = day, temperature = temperature)
        }
    }
}