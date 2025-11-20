package com.naveen.testing

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.naveen.testing.ui.theme.TestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: MainViewModel = MainViewModel()) {
    val itemsList by viewModel.itemsList.collectAsStateWithLifecycle()
    val context = LocalContext.current // Obtain the context within a Composable
    var count by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
       viewModel.setDefaultValuesForList()
    }

    LazyColumn (modifier) {
        items(itemsList, key = {it.id}){ item ->
            RowUI(item, count.toString()){ screenEvents ->
                count++
                when(screenEvents){
                    is ScreenEvent.onClickItem -> {
                        Toast.makeText(
                            context,
                            "Selected: ".plus(screenEvents.person.name),
                            Toast.LENGTH_SHORT)
                            .show()
                    }
                    is ScreenEvent.onDeleteItem -> {
                        Toast.makeText(
                            context,
                            "Selected for delete: ".plus(screenEvents.person.name),
                            Toast.LENGTH_SHORT)
                            .show()
                        viewModel.deleteItem(screenEvents.person)
                    }
                    is ScreenEvent.onModifyItem -> {
                        Toast.makeText(
                            context,
                            "Selected for modification: ".plus(screenEvents.person.name),
                            Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            viewModel.restLaitToEmpty()
        }
    }
}

@Composable
fun RowUI(person: Person, count: String, onClickedRow:(ScreenEvent)-> Unit){
    /*
    implementation("io.coil-kt:coil-compose:2.6.0")
    <uses-permission android:name="android.permission.INTERNET" />
     */

    /*
       Button -> Increment count and navigate to another screen. Display increment count in row
       navigation
       add
       delete
       modify
     */

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClickedRow(ScreenEvent.onClickItem(person))
            }
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(person.userImage)
                .crossfade(true)
                .build(),
            contentDescription = "Photo",
            placeholder = painterResource(R.drawable.ic_launcher_foreground),
            error = painterResource(R.drawable.ic_launcher_background),
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )

        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(text = "Name: ".plus(person.name))
                Text(text = "City: ".plus(person.city))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Text(text = "Age: ".plus(person.age.toString()))
                Text(text = "Count: ".plus(count))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Button(
                    onClick = {
                        onClickedRow(ScreenEvent.onDeleteItem(person))
                    }
                ){
                    Text("Delete")
                }
                Button(
                    onClick = {
                        onClickedRow(ScreenEvent.onModifyItem(person))
                    }
                ){
                    Text("Modify")
                }
            }
        }

    }
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 2.dp,
        color = Color.Red
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingTheme {
        Greeting("Android")
    }
}