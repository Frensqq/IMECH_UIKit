package com.example.uikit.TopBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Cards.TimeCard
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.Dimension.Spacer.mediumVertical
import com.example.uikit.UI.IMECHTheme

/**
 * Универсальное верхнее меню
 *
 * @param onClick - клик на иконку
 * @param title - заголовок
 * @param color - цвет элементов
 *
 * ЛядовС 10.10.26
 */
@Composable
fun UniversalTopBar(
    onClick: () -> Unit,
    title: String,
    color: Color = IMECHTheme.color.accent
){

    Column(
        Modifier.fillMaxWidth(Dimension.Float.medium),
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.large)
    ) {

        Icon(painterResource(R.drawable.back),
            contentDescription = null, tint = color
            , modifier = Modifier.clickable{
                onClick()
            }
        )


        Text(title,
            style = IMECHTheme.typography.displayMedium,
            color = color,
            modifier = Modifier.padding(horizontal = mediumVertical)
        )
    }

}


@Preview
@Composable
fun PreviewUniversalTopBar() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        UniversalTopBar({},
            "Combat Information"
        )
    }
}