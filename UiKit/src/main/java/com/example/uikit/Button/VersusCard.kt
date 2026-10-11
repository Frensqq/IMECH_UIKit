package com.example.uikit.Button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.Avatar.AvatarName
import com.example.uikit.Avatar.AvatarNameRight
import com.example.uikit.Cards.AvatarCard
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.Dimension.Size.centerButtonOuter
import com.example.uikit.UI.IMECHTheme

@Composable
fun VersusCard(
    nameLeft: String,

    stateRight: String,
    nameRight: String,
    stateLeft: String,
    nameGame: String,
    statusGame: String,
    price: Int,
    countPerson: Int = 0,
    painterLeft: Painter = painterResource(R.drawable.icon),
    painterRight: Painter = painterResource(R.drawable.icon),
){

    BackGroundCard {
        Row(modifier = Modifier.fillMaxWidth().height(centerButtonOuter), horizontalArrangement = Arrangement.spacedBy(
            Dimension.Spacer.default) ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AvatarName(
                    stateLeft,
                    nameLeft,
                    stateBorder = false,
                    size = Dimension.Size.avatarMedium
                )

                Text(
                    "VS",
                    style = IMECHTheme.typography.displayMedium,
                    color = IMECHTheme.color.accent
                )

                AvatarNameRight(
                    stateRight,
                    nameRight,
                    stateBorder = false,
                    size = Dimension.Size.avatarMedium
                )

                if (countPerson != 0) {
                    Text(
                        "+$countPerson",
                        style = IMECHTheme.typography.bodyMedium,
                        color = IMECHTheme.color.accent
                    )

                }
            }



            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CardColumn(
                    "Game  Name:",
                    nameGame,
                )
                CardColumn(
                    "Status:",
                    statusGame,
                    if(statusGame == "Active") {IMECHTheme.color.success } else if(statusGame == "Open" || statusGame == "Processing") {
                        IMECHTheme.color.accent} else {IMECHTheme.color.onSurfase}
                )
                CardColumn(
                    "Winning Price:",
                    "$$price",
                    IMECHTheme.color.accent
                )

            }

        }
    }

}


@Composable
fun CardColumn(title: String, text: String, color: Color = IMECHTheme.color.accent){

    Column(
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.exSmall),
        horizontalAlignment = Alignment.CenterHorizontally ){

        Text(
            title,
            style = IMECHTheme.typography.labelMedium,
            color = IMECHTheme.color.black
        )

        Text( text,
            style = IMECHTheme.typography.labelLarge,
            color = color)

    }


}

@Preview(showBackground = true)
@Composable
fun PreviewVersusCard() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        VersusCard(
            "Oyibo Pepper",
            "Guest",
            "Shema Laset",
            "Host",
            "God Hand",
            "Active",
            1000,
            10
        )
    }
}