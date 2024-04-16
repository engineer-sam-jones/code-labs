package com.example.composequadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrants.ui.theme.ComposeQuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantScreen()
                }
            }
        }
    }
}

@Composable
fun QuadrantScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth()) {
        Row(modifier.weight(1f)) {
           QuadrantCard(
               title = stringResource(id = R.string.text_composable_title),
               body = stringResource(id = R.string.text_composable_body),
               color = colorResource(id = R.color.top_left_color),
               modifier = modifier.weight(1f)
           )
           QuadrantCard(
               title = stringResource(id = R.string.image_composable_title),
               body = stringResource(id = R.string.image_composable_body),
               color = colorResource(id = R.color.top_right_color),
               modifier = modifier.weight(1f)
           )
        }
        Row(modifier.weight(1f)) {
            QuadrantCard(
                title = stringResource(id = R.string.row_composable_title),
                body = stringResource(id = R.string.text_composable_body),
                color = colorResource(id = R.color.bottom_left_color),
                modifier = modifier.weight(1f)
            )
            QuadrantCard(
                title = stringResource(id = R.string.column_composable_title),
                body = stringResource(id = R.string.column_composable_body),
                color = colorResource(id = R.color.bottom_right_color),
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantCard(
    title: String,
    body: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        QuadrantTitle(title = title)
        QuadrantBody(body = body)
    }
}

@Composable
fun QuadrantTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun QuadrantBody(body: String, modifier: Modifier = Modifier) {
    Text(
        text = body,
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantsTheme {
        QuadrantScreen()
    }
}