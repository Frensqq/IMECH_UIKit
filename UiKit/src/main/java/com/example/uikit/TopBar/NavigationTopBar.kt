package com.example.uikit.TopBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.uikit.Avatar.UniversalIcon
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

/**
 * Верхнее меню навигации
 *
 * @param name - имя пользователя
 * @param onClick - клик на иконку
 * @param painter - аватар если не по умолчанию
 *
 * ЛядовС 10.10.26
 */
@Composable
fun NavigationTopBar(
    name: String,
    onClick: () -> Unit,
    painter: Painter = painterResource(R.drawable.icon)
){

    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        Icon(painter = painterResource(R.drawable.burger),
             modifier =  Modifier.clickable{
                onClick()
            },
            contentDescription = null , tint = IMECHTheme.color.accent)

        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimension.Spacer.exSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {

            UniversalIcon(
                painter = painter,
                size = Dimension.Size.avatarSmall
            )

            Text(name,
                style = IMECHTheme.typography.bodyLarge,
                color = IMECHTheme.color.black
            )

        }

    }


}