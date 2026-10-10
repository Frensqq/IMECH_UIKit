package com.example.uikit.Cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Input.TimePicker
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

/**
 * Карточка с главного меню
 *
 * @param image - Картинка карточки
 * @param title - заголовок карточки
 * @param text - текст карточки
 * @param onClick - клик на иконку карточки
 *
 * ЛядовС 10.10.26
 */
@Composable
fun ScheduleCard(
    image: Painter,
    title: String,
    text: String,
    onClick: () -> Unit
){

    Box(
        modifier = Modifier.fillMaxWidth()
            .height(Dimension.Height.cardHeight)
            .clip(RoundedCornerShape(Dimension.Rounded.medium))
            .background(Brush.linearGradient(
                colors = listOf(
                    IMECHTheme.color.buttonGradientStart,
                    IMECHTheme.color.buttonGradientEnd
                )
            ))
    ){
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = Dimension.Padding.large , vertical = Dimension.Padding.largeP),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.xMediumVertical)) {

                Text(title ,
                    style = IMECHTheme.typography.titleLarge,
                    color = IMECHTheme.color.white
                )
                Text(text ,
                    style = IMECHTheme.typography.bodyLarge,
                    color = IMECHTheme.color.white
                )

            }

            Icon(painter = painterResource(R.drawable.forward_arrow)
                ,contentDescription = null, tint = IMECHTheme.color.white,
               modifier =  Modifier
                   .clickable{
                   onClick()
               }
            )


        }

        Box(modifier = Modifier.fillMaxSize()
            .padding(vertical = Dimension.Spacer.default, horizontal = Dimension.Spacer.small),
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                modifier = Modifier.fillMaxHeight().padding(top = Dimension.Spacer.medium),
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview
@Composable
fun PreviewScheduleCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        ScheduleCard(
            painterResource(R.drawable.testcardimg),
            "Message Players",
            "Found the profile of a player\n" +
                    "that interests you? Start a\n" +
                    "conversation",
            {}
        )
    }
}