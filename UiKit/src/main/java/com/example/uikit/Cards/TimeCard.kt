package com.example.uikit.Cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Input.TimePicker
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme
import java.nio.file.WatchEvent

/**
 * Карточка временные интервалы
 *
 * @param dateFrom - дата от
 * @param dateTo - дата до
 * @param timeFrom - время от
 * @param timeTo - время до
 *
 * ЛядовС 10.10.26
 */
@Composable
fun TimeCard(
    dateFrom: String,
    dateTo: String,
    timeFrom: String,
    timeTo: String
){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimension.Height.timeCardHeight)
            .clip(RoundedCornerShape(Dimension.Rounded.medium))
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        IMECHTheme.color.buttonGradientStart,
                        IMECHTheme.color.buttonGradientEnd
                    )
                )
            )
            .padding(
                horizontal = Dimension.Padding.defaultScreen,
                vertical = Dimension.Spacer.medium
            ),
        verticalArrangement = Arrangement.SpaceBetween

    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimension.Padding.small),
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                painter = painterResource(R.drawable.time_icon),
                contentDescription = null, tint = IMECHTheme.color.white
            )

            Text(
                "TIME INTERVAL",
                style = IMECHTheme.typography.titleSmall,
                color = IMECHTheme.color.white
            )
        }


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.xMediumVertical)
            ) {


                ColumnTimeCard("FROM", dateFrom)

                ColumnTimeCard("TO", dateTo)

            }

            Column(
                verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.xMediumVertical)
            ) {
                ColumnTimeCard("FROM", timeFrom)
                ColumnTimeCard("TO", timeTo)
            }
        }
    }
}

@Composable
fun ColumnTimeCard(
    title: String,
    time: String
){
    Column(verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.small)) {

        Text(title, style = IMECHTheme.typography.labelLarge, color = IMECHTheme.color.white)

        Text(time, style = IMECHTheme.typography.bodyLarge, color = IMECHTheme.color.white)

    }
}

@Preview
@Composable
fun PreviewTimeCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        TimeCard(
            "MON, NOV 4,2019",
            "MON, NOV 4,2019",
            "12:30 AM",
            "3:30 AM",
        )
    }
}