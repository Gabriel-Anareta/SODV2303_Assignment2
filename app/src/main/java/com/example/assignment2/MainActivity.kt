package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.artmodel.Art
import com.example.assignment2.data.datasource
import com.example.assignment2.ui.theme.Assignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtGalleryApp()
                }
            }
        }
    }
}

@Composable
fun ArtGalleryApp(modifier: Modifier = Modifier) {
    val artList: List<Art> = datasource().loadArtSources()
    ArtGalleryLayout(artList)
}

@Composable
fun ArtGalleryLayout(artList: List<Art>, modifier: Modifier = Modifier) {
    var current by remember { mutableIntStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(20.dp, 20.dp)
                .weight(8f)
        ) {
            Image(
                painter = painterResource(id = artList[current].artId),
                contentDescription = stringResource(id = artList[current].titleID),
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .padding(16.dp)
                    .border(16.dp, color = Color.White)
                    .shadow(10.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(60.dp, 20.dp)
                    .background(color = Color(0xFFEAEAEA))
            ) {
                Text(
                    text = stringResource(id = artList[current].titleID),
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 20.dp)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(start = 20.dp)
                ) {
                    Text(
                        text = stringResource(id = artList[current].authorID),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    val year = stringResource(id = artList[current].yearID)
                    Text(
                        text = "($year)"
                    )
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(30.dp, 0.dp)
                .weight(1f)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { current = setPrevious(current, artList.lastIndex) },
                modifier = Modifier.width(140.dp)
            ) {
                Text(
                    text = "Previous"
                )
            }

            Button(
                onClick = { current = setNext(current, artList.lastIndex) },
                modifier = Modifier.width(140.dp)
            ) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}

fun setPrevious(current: Int, last: Int): Int {
    if (current == 0) { return last }
    return (current - 1)
}

fun setNext(current: Int, last: Int): Int {
    if (current == last) { return 0 }
    return (current + 1)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2Theme {
        ArtGalleryApp()
    }
}