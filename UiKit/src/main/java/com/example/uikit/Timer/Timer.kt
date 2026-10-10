package com.example.uikit.Timer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.Navigation.Points
import com.example.uikit.TopBar.NavigationTopBar
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

@Composable
fun Timer(hours: String, min: String){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimension.Height.timerHeight)
            .clip(RoundedCornerShape(Dimension.Rounded.medium))
            .background(Brush.linearGradient(
                colors = listOf(
                    IMECHTheme.color.buttonGradientStart,
                    IMECHTheme.color.buttonGradientEnd
                )
            ))
            .padding(Dimension.Padding.smallP)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.xMediumVertical)
    )
    {
        Text("Timer",
            style = IMECHTheme.typography.titleMedium,
            color = IMECHTheme.color.white
        )

        Text("$hours:$min",
            style = IMECHTheme.typography.displayLarge,
            color = IMECHTheme.color.white
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTimer() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Timer("00","00")

        NavigationTopBar("Stone Stellar", {})
    }
}