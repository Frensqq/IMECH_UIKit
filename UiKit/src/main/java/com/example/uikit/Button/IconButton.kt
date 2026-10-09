package com.example.uikit.Button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

/**
 * Кнопка из иконки и текста
 *
 * @param icon - иконка кнопки
 * @param text - текст кнопки
 * @param onClick - действие клика
 *
 * ЛядовС 09.10.26
 */
@Composable
fun IconButton(
    icon: Painter,
    text: String,
    onClick: ()-> Unit
){

    Row(
        modifier = Modifier.clickable{
            onClick()
        },
     verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimension.Spacer.medium)
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = IMECHTheme.color.accent,
        )

        Text(
            text,
            style = IMECHTheme.typography.headlineMedium
        )

    }
}


@Preview
@Composable
fun PreviewIconButton(){

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        IconButton(
            painterResource(R.drawable.logout),
            text = "Logout"
        ) { }



    }

}
