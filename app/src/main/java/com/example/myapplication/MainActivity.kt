package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.weather.backgroundPicture
import com.example.myapplication.ui.weather.degreeCircle
import com.example.myapplication.ui.weather.degreeRightNow
import com.example.myapplication.ui.weather.weatherApp
import com.example.myapplication.ui.weather.weatherWeekApp




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // surface der bruger vores baggrundsfarve
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                )
                {
                    backgroundContent()
                    backgroundPicture()
                    degreeCircle()
                    degreeRightNow()
                    weatherApp()
                    weatherWeekApp()
                }
            }
        }
    }
}

@Composable
private fun backgroundContent(
    modifier: Modifier = Modifier
){

    val gradientColorList = listOf(
        Color(0xFF384853),
        Color(0xFFFFE2E5),
        Color(0xFFDDA1BC),
        Color(0xFF114759),
        Color(0xFF0C2A33)
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = GradientBackground(
                    isVerticalGradient = true,
                    colors = gradientColorList
                )
            ),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "",
            color = androidx.compose.ui.graphics.Color.Black,
            fontSize = 24.sp,
            modifier = modifier.align(Alignment.Center)
        )
    }
}




@Composable
private fun GradientBackground(
    isVerticalGradient: Boolean,
    colors: List<androidx.compose.ui.graphics.Color>
): Brush {

    val endOffset = if (isVerticalGradient) {
        Offset(0f, Float.POSITIVE_INFINITY)
    } else{
        Offset(Float.POSITIVE_INFINITY, 0f)
    }

    return Brush.linearGradient(
        colors = colors,
        start = Offset.Zero,
        end = endOffset,
    )
}

@Composable
fun centeredPicture() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Gray)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            // Replace R.drawable.your_image with the actual image resource
            Image(
                painter = painterResource(id = R.drawable.cloud),
                contentDescription = "Centered Picture",
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.White)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}



@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    MyApplicationTheme {
        backgroundContent()
        backgroundPicture()
        degreeCircle()
        degreeRightNow()
        weatherApp()
        weatherWeekApp()
    }
}

