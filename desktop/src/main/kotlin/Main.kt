// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.ResourceLoader
import androidx.compose.ui.res.loadSvgPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.*

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

fun main() = application {
    val state = rememberWindowState();


    Window(
        onCloseRequest = ::exitApplication,
        title = "Pilot Launcher",
        state = WindowState(
            position = WindowPosition.Aligned(
                Alignment.Center
            ),
            // 650, 537
            size = DpSize(Dp(500.0f), Dp(537.0f))
        ),
        undecorated = true,
        resizable =  false
    ) {
        MaterialTheme {
            Box(Modifier.fillMaxSize()) {

                Image(painter = painterResource("pilot.jpg"), contentDescription = null, contentScale =  ContentScale.Fit)

                Text(
                    // TODO implement common resources
                    "Pilot Launcher",
                    Modifier.align(Alignment.Center),
                    color = Color(3, 211, 252, 255),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 50.sp,
                    )
            }


        }
    }
}
