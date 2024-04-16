package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CompletedTaskScreen()
                }
            }
        }
    }
}
@Composable
fun CompletedTaskScreen(modifier: Modifier = Modifier) {
    Box(
       contentAlignment = Alignment.Center,
       modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CompletedImage()
            AllTasksCompleted()
            NiceWork()
        }
    }
}git

@Composable
fun CompletedImage(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Image(
        painter = image,
        contentDescription = null,
        alignment = Alignment.Center,
        modifier = modifier
    )
}

@Composable
fun AllTasksCompleted(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.all_tasks_completed_text),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
    )
}

@Composable
fun NiceWork(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.nice_work_text),
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        modifier = modifier
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        CompletedTaskScreen()
    }
}