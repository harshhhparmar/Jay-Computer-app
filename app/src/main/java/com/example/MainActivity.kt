package com.example

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      var currentUrl by remember { mutableStateOf("https://jaycomputer.vercel.app/#home") }
      
      MyApplicationTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          topBar = {
            TopAppBar(
              title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                  Icon(
                    imageVector = Icons.Default.Computer,
                    contentDescription = "Logo",
                    tint = MaterialTheme.colorScheme.primary
                  )
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    "Jay Computer",
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                  )
                }
              },
              actions = {
                IconButton(onClick = { }) {
                  Icon(Icons.Default.Search, contentDescription = "Search")
                }
                IconButton(onClick = { }) {
                  Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                }
              },
              colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                scrolledContainerColor = MaterialTheme.colorScheme.background
              )
            )
          },
          bottomBar = {
            NavigationBar(
              containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ) {
              NavigationBarItem(
                icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                label = { Text("Home") },
                selected = currentUrl == "https://jaycomputer.vercel.app/#home",
                onClick = { currentUrl = "https://jaycomputer.vercel.app/#home" }
              )
              NavigationBarItem(
                icon = { Icon(Icons.Default.Build, contentDescription = "Services") },
                label = { Text("Services") },
                selected = currentUrl == "https://jaycomputer.vercel.app/#services",
                onClick = { currentUrl = "https://jaycomputer.vercel.app/#services" }
              )
              NavigationBarItem(
                icon = { Icon(Icons.Default.Email, contentDescription = "Inquiry") },
                label = { Text("Inquiry") },
                selected = currentUrl == "https://jaycomputer.vercel.app/#enquiry",
                onClick = { currentUrl = "https://jaycomputer.vercel.app/#enquiry" }
              )
              NavigationBarItem(
                icon = { Icon(Icons.Default.Info, contentDescription = "About us") },
                label = { Text("About us") },
                selected = currentUrl == "https://jaycomputer.vercel.app/#contact",
                onClick = { currentUrl = "https://jaycomputer.vercel.app/#contact" }
              )
            }
          }
        ) { innerPadding ->
          WebViewScreen(
            url = currentUrl,
            modifier = Modifier.padding(innerPadding).fillMaxSize()
          )
        }
      }
    }
  }
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewScreen(url: String, modifier: Modifier = Modifier) {
  var webView by remember { mutableStateOf<WebView?>(null) }
  var canGoBack by remember { mutableStateOf(false) }
  
  LaunchedEffect(url) {
    webView?.loadUrl(url)
  }

  BackHandler(enabled = canGoBack) {
    webView?.goBack()
  }

  AndroidView(
    modifier = modifier,
    factory = { context ->
      WebView(context).apply {
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = false
        
        webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return false // Open links within the WebView
            }
            override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
                super.doUpdateVisitedHistory(view, url, isReload)
                canGoBack = view?.canGoBack() == true
            }
        }
        webView = this
        loadUrl(url)
      }
    },
    update = { view ->
      // Handled by LaunchedEffect
    }
  )
}
