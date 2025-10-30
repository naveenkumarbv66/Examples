package com.naveen.testing

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naveen.testing.ui.theme.TestingTheme
import kotlinx.parcelize.Parcelize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api

val items = listOf(
    rowData("1 Naveen","1 Bangalore", "description"),
    rowData("2 Naveen","2 Bangalore", "description"),
    rowData("3 Naveen","3 Bangalore", "description"),
    rowData("4 Naveen","4 Bangalore", "description")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyListScreen( modifier = Modifier.padding(innerPadding))
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    val myList = listOf(
        rowData("1 Naveen","1 Bangalore", "description"),
        rowData("2 Naveen","2 Bangalore", "description"),
        rowData("3 Naveen","3 Bangalore", "description"),
        rowData("4 Naveen","4 Bangalore", "description")
    )


    LazyColumn {
        items(myList){ item ->
            LzyColumRow(item){
                rowData ->
               println("Selected: ".plus(rowData.name))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestingTheme {
        Greeting("Android")
    }
}

@Composable
fun LzyColumRow(data: rowData, onItemClick: (rowData) -> Unit){
    Card(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        onClick = {onItemClick(data)}
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Text(data.name)
            Text(data.location)
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp,
            color = Color.Blue
        )
    }
}


@Composable
fun DisplayFullInformation(data: rowData, modifier: Modifier){
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Title: ${data.name}")
        Text(text = "Description: ${data.description}")
        // Add more details as required
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyListScreen(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "itemList") {
        composable("itemList") {
            LazyColumn(
                modifier = modifier
            ) {
                items(
                    items = items,
                    key = {item -> item.name}
                ){ item ->
                    LzyColumRow(item){ rowData ->
                        println("Selected: ".plus(rowData.name))
                        navController.currentBackStackEntry?.savedStateHandle?.set("item", item)
                        navController.navigate("itemDetail")
                    }
                }
            }
        }
        composable("itemDetail") { backStackEntry ->
            val selectedItem = navController.previousBackStackEntry?.savedStateHandle?.get<rowData>("item")
            selectedItem?.let { item ->
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(item.name) },
                            navigationIcon = {
                                IconButton(onClick = { navController.navigateUp() }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                        contentDescription = "Back"
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    DisplayFullInformation(item, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/*
backStackEntry.arguments is for forward navigation arguments to the current destination.
navController.previousBackStackEntry?.savedStateHandle is for passing data backwards (results) from a destination that is being popped off the back stack to the previous destination.
*/

@Parcelize
data class rowData(var name: String, var location: String, val description: String) : Parcelable