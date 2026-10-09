package com.example.uikit.Input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

@Composable
fun CheckBoxes(
    value: Boolean,
    onChangeValue: (Boolean) -> Unit
){

    Box(
        modifier = Modifier.size(Dimension.Size.sizeBox)
            .border(
                BorderStroke(
                    Dimension.Stroke.small,
                    IMECHTheme.color.accent
                ), RoundedCornerShape(Dimension.Rounded.xSmall)
            ).clickable{
                onChangeValue(!value)
            }, contentAlignment = Alignment.Center

    ) {

        if (value){
            Icon(painterResource(R.drawable.checkmark),
                contentDescription = null, tint = IMECHTheme.color.accent)
        }

    }

}


@Preview(showBackground = true)
@Composable
fun PreviewCheckBoxes() {
    var value by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        CheckBoxes(value){
            value = it
        }
    }
}
