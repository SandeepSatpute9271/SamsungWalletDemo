package com.example.samsungwallet

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samsungwallet.ui.theme.SamsungWalletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SamsungWalletTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Add To Samsung Wallet")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, context: Context = LocalContext.current) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp)) {
        Text(
            text = name,
            modifier = modifier
                .background(color = Color.Black)
                .padding(10.dp)
                .clickable {
                          addToSamsungWallet(context)
                },
            color = Color.White,
        )
    }
}

fun addToSamsungWallet(current: Context) {
    Toast.makeText(current, "Calling Samsung Wallet", Toast.LENGTH_SHORT).show()
    try {
        val cardId = ""
        val cData = ""
        val intent= Intent(Intent.ACTION_VIEW, Uri.parse(
            "https://a.swallet.link/atw/v1/${cardId}#Clip?cdata=${cData}"))
        current.startActivity(intent)
    }catch (ex: Exception){
        ex.message?.let { Log.e("EXCEPTION: ", it) }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    SamsungWalletTheme {
        Greeting("Add To Samsung Wallet")
    }
}