package com.example.myapplication.ui.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.weather.backgroundPicture
import com.example.myapplication.ui.weather.degreeCircle
import com.example.myapplication.ui.weather.degreeRightNow
import com.example.myapplication.ui.weather.weatherApp
import com.example.myapplication.ui.weather.WeatherDayItem
import com.example.myapplication.ui.weather.WeatherWeekList
import com.example.myapplication.ui.weather.weatherWeekApp
import com.example.myapplication.ui.weather.WeatherHourItem
import com.example.myapplication.ui.weather.WeatherDayItem

@Composable
fun weatherApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Spacer(modifier = Modifier.height(400.dp)) // vi laver en spacer så vi kan lave noget mellemrum

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 8.dp)
        ) {
            Text(
                text = "Today",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = Color(0xFF3593BC))
                .padding(top = 12.dp) // vi kan justerer paddingen op toppen
        ) {
            items(24) { hour ->
                WeatherHourItem(hour, generateRandomTemperature())
            }
        }
    }
}

@Composable
fun WeatherHourItem(hour: Int, temperature: Int) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .background(Color(0xFF3593BC))
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "$hour:00", color = Color.White)
            Text(text = "$temperature°C")
        }
    }
}

fun generateRandomTemperature(): Int {
    return Random.nextInt(0, 30) // vi kan justerer temperatur forskellen her
}
