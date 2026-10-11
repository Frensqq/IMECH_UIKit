package com.example.uikit.Button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

@Composable
fun BackGroundCard(
    content: @Composable () -> Unit
){


    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(Dimension.Rounded.medium))
            .border(BorderStroke(Dimension.Stroke.small, IMECHTheme.color.accent),
                RoundedCornerShape(Dimension.Rounded.medium))
            .padding(Dimension.Padding.cardPadding)
    ) {

        content()

    }
}