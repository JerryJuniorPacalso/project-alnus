package com.example.project_alnus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.project_alnus.ui.theme.ProjectalnusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectalnusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WelcomeScreen("Project-Alnus")
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(name: String, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    BottomAppBarActionButtons()
                }
            )
        },
    ) { innerPadding ->
        BackgroundImage(innerPadding)
    }
}

@Composable
fun BottomAppBarActionButtons(modifier: Modifier = Modifier){
    Box(modifier = Modifier.fillMaxSize()){
        Row (horizontalArrangement = Arrangement.SpaceAround,
             modifier = Modifier
                 .fillMaxSize()
                 .align(Alignment.BottomCenter)
        ){
            Button(onClick = { /* TODO: navigate to the log-in screen */ }) {
                Text(text = stringResource(R.string.log_in))
            }
            Button(onClick = { /*TODO: navigate to the sign-up screen */ }) {
                Text(text = stringResource(R.string.sign_up))
            }
        }
    }
}

@Composable
fun BackgroundImage(innerPadding: PaddingValues) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.alnus_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    ProjectalnusTheme {
        WelcomeScreen(stringResource(id = R.string.project_alnus))
    }
}