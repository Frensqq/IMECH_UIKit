package com.example.uikit.Cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.uikit.Avatar.UniversalIcon
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

@Composable
fun AvatarCard(
    name: String,
    status: String,
    painter: Painter = painterResource(R.drawable.icon)
){

    Row(horizontalArrangement = Arrangement.spacedBy(Dimension.Padding.dSmall)) {

        UniversalIcon(
            painter = painter,
        )


        Column{

            Text(name,
                style = IMECHTheme.typography.headlineLarge,
                color = IMECHTheme.color.accent
            )

            Text(status,
                modifier = Modifier.padding(horizontal = Dimension.Padding.dSmall),
                style = IMECHTheme.typography.bodyLarge,
                color = IMECHTheme.color.cardStroke
                )

        }

    }

}