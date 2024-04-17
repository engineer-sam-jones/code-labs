package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}
@Composable
fun BusinessCardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        NameCard()
        ContactCard()
    }
}

@Composable
fun NameCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Logo()
        Name()
        Title()
    }
}

@Composable
fun Logo(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Box(
        modifier
            .fillMaxWidth(.5f)
            .background(Color.Black)
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.android_logo_content_description),
            contentScale = ContentScale.Fit,
            modifier = modifier.padding(bottom = 8.dp)
        )
    }
}

@Composable
fun Name(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.name_text),
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = modifier.padding(bottom = 8.dp)
    )
}

@Composable
fun Title() {
    Text(
        text = stringResource(R.string.title_text),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun ContactItem(
    icon: ImageVector,
    iconContentDescription: String,
    contactInfo: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = iconContentDescription
        )
        Spacer(modifier.width(8.dp))
        Text(
            text = contactInfo
        )
    }
}

@Composable
fun ContactCard(modifier: Modifier = Modifier) {
    Row {
        Spacer(modifier.weight(.5f))
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 24.dp)
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            ContactItem(
                icon = Icons.Filled.Phone,
                iconContentDescription = stringResource(R.string.phone_number_content_description),
                contactInfo = stringResource(R.string.phone_number_text)
            )
            ContactItem(
                icon = Icons.Filled.Share,
                iconContentDescription = stringResource(R.string.social_media_content_description),
                contactInfo = stringResource(R.string.social_media_text)
            )
            ContactItem(
                icon = Icons.Filled.Email,
                iconContentDescription = stringResource(R.string.email_content_description),
                contactInfo = stringResource(R.string.email_text)
            )
        }
        Spacer(modifier.weight(.5f))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}