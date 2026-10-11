package com.example.uikit.Cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.Avatar.UniversalIcon
import com.example.uikit.Button.BackGroundCard
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.Dimension.Size.avatarMediumP
import com.example.uikit.UI.IMECHTheme

@Composable
fun PlayerCard(
    playerName: String,
    statusPlayer: String,
    statePlayer: String,
    categories: String,
    painter: Painter = painterResource(R.drawable.icon)
){

    BackGroundCard {

        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimension.Spacer.mediumVertical),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UniversalIcon(
                painter = painter,
                stateBorder = false,
                size = avatarMediumP
            )

            Column() {

                Text(
                    playerName,
                    style = IMECHTheme.typography.labelLarge,
                    color = IMECHTheme.color.black
                )

                Row(horizontalArrangement = Arrangement.spacedBy(Dimension.Padding.small), verticalAlignment = Alignment.CenterVertically) {
                    val colorCurrent = if (statePlayer == "Gold Player") {
                        IMECHTheme.color.cardStroke
                    } else IMECHTheme.color.onSurfase
                    Icon(
                        painter = painterResource(R.drawable.crone), contentDescription = null,
                        tint = colorCurrent
                    )
                    Text(
                        statePlayer,
                        style = IMECHTheme.typography.labelLarge,
                        color = colorCurrent
                    )
                }
                Row() {
                    Text(
                        "Status: ",
                        style = IMECHTheme.typography.labelMedium,
                        color = IMECHTheme.color.black
                    )
                    Text(
                        statusPlayer,
                        style = IMECHTheme.typography.labelMedium,
                        color = if (statusPlayer == "Online") {
                            IMECHTheme.color.success
                        } else if (statusPlayer == "Away") {
                            IMECHTheme.color.cardStroke
                        } else {
                            IMECHTheme.color.onSurfase
                        }
                    )
                }
                Row() {
                    Text(
                        "Category’s: ",
                        style = IMECHTheme.typography.labelMedium,
                        color = IMECHTheme.color.black
                    )
                    Text(
                        categories,
                        style = IMECHTheme.typography.labelMedium,
                        color = IMECHTheme.color.accent
                    )
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPlayerCard() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        PlayerCard(
            "Scott Brown",
            "Online",
            "Gold Player",
            "Action, Soccer",

        )
    }
}
