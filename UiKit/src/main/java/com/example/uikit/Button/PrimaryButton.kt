package com.example.uikit.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

@Composable
fun PrimaryButton(
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true
){


    Button(
        onClick= {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth(Dimension.Float.buttonWidth)
            .height(Dimension.Height.buttonHeight)
            .clip(CircleShape)
            .background(Brush.linearGradient(
                colors = listOf<Color>(
                    IMECHTheme.color.buttonGradientStart,
                    IMECHTheme.color.buttonGradientEnd
                )
            ))
        ,
        enabled = enabled,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            contentColor = IMECHTheme.color.white,
            disabledContentColor = IMECHTheme.color.white
        )

    ) {

        Text(text,
            style = IMECHTheme.typography.headlineSmall,)

    }
}


@Preview
@Composable
fun PreviewPrimaryButton(){

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        PrimaryButton({},
            "Let’s Combat!")

    }

}
