package com.example.uikit.Avatar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

/**
 * Универсальный аватар
 *
 * @param stateBorder - состояние рамки аватара
 * @param size - размер аватара
 * @param painter - иконка аватара или по умолчанию
 *
 */
@Composable
fun UniversalIcon(
    stateBorder: Boolean = true,
    size: Dp = Dimension.Size.avatarDefault,
    painter: Painter = painterResource(R.drawable.icon)
    ){

    Box(modifier = Modifier.size(
        size
    ).clip(CircleShape)
        .border(BorderStroke(
            Dimension.Stroke.medium,
            color = if (stateBorder) IMECHTheme.color.accent else Color.Transparent),
            CircleShape)
    ){
        Image(
            painter,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

}