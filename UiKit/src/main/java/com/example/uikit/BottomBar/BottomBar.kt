package com.example.uikit.BottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.R
import com.example.uikit.UI.Dimension

@Composable
fun BottomBar(
    onItemClick: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimension.Height.bottomBar)
            .drawBehind {
                val center = size.width / 2
                val top = Dimension.Cutout.top.toPx()
                val halfWidth = Dimension.Cutout.halfWidth.toPx()
                val smooth = Dimension.Cutout.smooth.toPx()

                val path = Path().apply {
                    moveTo(0f, top)
                    lineTo(center - halfWidth, top)

                    cubicTo(
                        center - halfWidth + smooth, top,
                        center - smooth, 0f,
                        center, 0f
                    )

                    cubicTo(
                        center + smooth, 0f,
                        center + halfWidth - smooth, top,
                        center + halfWidth, top
                    )

                    lineTo(size.width, top)
                    lineTo(size.width, size.height)
                    lineTo(0f, size.height)
                    close()
                }

                drawPath(
                    path = path,
                    color = Color(0xFFFF3267)
                )
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimension.Height.bottomBarRow)
                .align(Alignment.BottomCenter)
                .padding(bottom = Dimension.Padding.bottomBarBottom),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier.weight(Dimension.Float.default),
                contentAlignment = Alignment.Center
            ) {
                ItemBottomBar(
                    onClick = { onItemClick("Statistics") },
                    painter = painterResource(R.drawable.statistics),
                    title = "Statistics"
                )
            }

            Box(
                Modifier.weight(Dimension.Float.default),
                contentAlignment = Alignment.Center
            ) {
                ItemBottomBar(
                    onClick = { onItemClick("Discover") },
                    painter = painterResource(R.drawable.discover),
                    title = "Discover"
                )
            }

            // Место под центральную кнопку
            Spacer(Modifier.weight(Dimension.Float.default))

            Box(
                Modifier.weight(Dimension.Float.default),
                contentAlignment = Alignment.Center
            ) {
                ItemBottomBar(
                    onClick = { onItemClick("Chat") },
                    painter = painterResource(R.drawable.chat),
                    title = "Chat"
                )
            }

            Box(
                Modifier.weight(Dimension.Float.default),
                contentAlignment = Alignment.Center
            ) {
                ItemBottomBar(
                    onClick = { onItemClick("Profile") },
                    painter = painterResource(R.drawable.profile),
                    title = "Profile"
                )
            }
        }

        Box(
            modifier = Modifier
                .padding(vertical = Dimension.Padding.centerButtonVertical)
                .align(Alignment.TopCenter)
                .size(Dimension.Size.centerButtonOuter)
                .background(Color.White, CircleShape)
                .clickable { onItemClick("Calendar") },
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(Dimension.Size.centerButtonInner)
                    .background(
                        Color(0xFFFF3267),
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.calendar),
                    contentDescription = "Calendar",
                    tint = Color.White,
                    modifier = Modifier.size(Dimension.Size.centerButtonIcon)
                )
            }
        }
    }
}



@Preview
@Composable
fun PreviewBottomBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        BottomBar { title ->
            // обработка клика по title
        }
    }
}