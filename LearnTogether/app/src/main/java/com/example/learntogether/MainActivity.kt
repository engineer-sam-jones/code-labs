package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Tutorial()
                }
            }
        }
    }
}

@Composable
fun Tutorial() {
    Column {
        ImageBanner(Modifier.fillMaxWidth())
        TutorialTitle(Modifier.padding(16.dp))
        TutorialDefinition(Modifier.padding(start = 16.dp, end = 16.dp))
        TutorialDescription(Modifier.padding(16.dp))
    }
}

@Composable
fun ImageBanner(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun TutorialTitle(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.tutorial_title_text),
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
fun TutorialDefinition(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.tutorial_definition_text),
        fontSize = 16.sp,
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}

@Composable
fun TutorialDescription(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.tutorial_description_text),
        fontSize = 16.sp,
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnTogetherTheme {
        Tutorial()
    }
}