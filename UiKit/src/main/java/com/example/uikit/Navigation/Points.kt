package com.example.uikit.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Input.TimePicker
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

@Composable
fun Points(state: Int){
    Row(horizontalArrangement = Arrangement.spacedBy(Dimension.Spacer.mediumVertical)){
    for (item in 1..3){
        Box(Modifier
            .size(Dimension.Size.sizeSmallBox)
            .clip(CircleShape)
            .background(if(item==state)IMECHTheme.color.accent else IMECHTheme.color.accentInactive)
        )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPoints() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        Points(2)
        Points(3)
        Points(1)
    }
}