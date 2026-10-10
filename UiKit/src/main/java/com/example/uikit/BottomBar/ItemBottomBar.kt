package com.example.uikit.BottomBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

/**
 * Объект нижнего меню
 *
 * @param onClick - клик
 * @param painter - иконка
 * @param title - текст
 *
 * ЛядовС 10.10.26
 */
@Composable
fun ItemBottomBar(
    onClick: () -> Unit,
    painter: Painter,
    title: String
){

    Column(
        modifier = Modifier.height(Dimension.Height.bottomBarItemHeight)
            .clickable{
            onClick()
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            painter = painter,
            contentDescription = null,
            tint = IMECHTheme.color.white
        )

        Text(
            title,
            style = IMECHTheme.typography.bodyLarge,
            color = IMECHTheme.color.white
        )

    }

}