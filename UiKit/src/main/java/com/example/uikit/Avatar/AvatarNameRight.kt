package com.example.uikit.Avatar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.uikit.R
import com.example.uikit.Timer.Timer
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

/**
 * Универсальный аватар c именем
 *
 * @param name - имя пользователя
 * @param stateBorder - состояние рамки аватара
 * @param size - размер аватара
 * @param painter - иконка аватара или по умолчанию
 *
 */
@Composable
fun AvatarNameRight(
    state: String,
    name: String,
    stateBorder: Boolean = true,
    size: Dp = Dimension.Size.avatarDefault,
    painter: Painter = painterResource(R.drawable.icon)
    ) {


    Box(
        contentAlignment = Alignment.TopEnd
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.small),
            modifier = Modifier
                .padding(end = Dimension.Padding.dSmall, top = Dimension.Padding.smallP)
        ) {
            Box(
                modifier = Modifier
                    .size(
                        size
                    ).clip(CircleShape)
                    .border(
                        BorderStroke(
                            Dimension.Stroke.medium,
                            color = if (stateBorder) IMECHTheme.color.accent else Color.Transparent
                        ),
                        CircleShape
                    )
            ) {
                Image(
                    painter,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                name,
                style = IMECHTheme.typography.bodySmall,
                color = IMECHTheme.color.black
            )
        }

        Box(
            modifier = Modifier.height(Dimension.Height.avatarDesc). clip(CircleShape)
                .background(Brush.linearGradient(
                    colors = listOf(
                        IMECHTheme.color.buttonGradientStart,
                        IMECHTheme.color.buttonGradientEnd
                    )
                )).padding(horizontal = Dimension.Padding.small),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text =  state,
                style = IMECHTheme.typography.labelLarge,
                color = IMECHTheme.color.white
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAvatarNameRight() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AvatarNameRight("Guest", "Shema Laset", stateBorder = false);
    }
}