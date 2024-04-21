package com.inigo.frontpage

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.inigo.frontpage.ui.theme.FrontPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FrontPageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = getString(R.string.fitquest),
                        by = getString(R.string.by_atmr),
                        modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, modifier: Modifier = Modifier, by: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier) {

            Text(
                text = message,
                fontSize = 100.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = by,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.End)
            )

    }
}

@Composable
fun GreetingImage(message: String, by: String, modifier: Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            by = by,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun FrontPagePreview() {
    FrontPageTheme {
        GreetingImage(message = "FitQuest", by = "ATMR", modifier = Modifier)
    }
}