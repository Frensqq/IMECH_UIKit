package com.example.uikit.Input

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.IconButton
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

@Composable
fun Selects(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    listValue: List<String> = listOf("testCategory1", "testCategory2", "testCategory3")

){

    var dropDown by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.small)) {
        Column(verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.small)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {


                Text( if(!value.isNullOrEmpty()) value else placeholder, style = IMECHTheme.typography.titleMedium)


                Icon(
                    painterResource(R.drawable.dropdown),
                    contentDescription = null,
                    modifier = Modifier.padding(
                        vertical = Dimension.Padding.xSmall,
                        horizontal = Dimension.Padding.small
                    ).clickable {
                        dropDown = !dropDown
                    },
                    tint = IMECHTheme.color.accent
                )

            }

            Box(
                modifier = Modifier.fillMaxWidth().height(Dimension.Stroke.small)
                    .background(IMECHTheme.color.accent)
            )
        }

        DropdownMenu(dropDown, onDismissRequest = {dropDown}, modifier = Modifier.fillMaxWidth()) {
            listValue.forEach {it->
                DropdownMenuItem(
                    text = {Text(it)}, onClick =
                        {
                            onValueChange(it)
                            dropDown = false
                        },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewSelects(){

    Column(modifier = Modifier.fillMaxSize().padding(Dimension.Padding.defaultScreen),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        var value by remember { mutableStateOf("") }


        Selects(
            value,
            "Category",
            {value = it}
        )



    }

}



