package com.example.uikit.Input

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme

/**
 * Элемент ввода элементов
 *
 * @param value - текущее значение
 * @param placeholder - подсказка ввода
 * @param onValueChange - действие ввода значения
 * @param isPass - состояние пароля
 * ЛядовС 09.10.26
 */
@Composable
fun InputText(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    isPass: Boolean = false
) {
    var open by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimension.Height.inputHeight),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.weight(Dimension.Float.default),
                singleLine = true,
                textStyle = IMECHTheme.typography.titleMedium,
                visualTransformation = if (isPass && !open)
                    PasswordVisualTransformation()
                else
                    VisualTransformation.None,
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = IMECHTheme.typography.titleMedium,
                            color = Color.Black
                        )
                    }
                    innerTextField()
                }
            )

            if (isPass) {
                Icon(
                    painter = painterResource(R.drawable.eye),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(horizontal = Dimension.Padding.small)
                        .clickable { open = !open },
                    tint = Color.Black
                )
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(Dimension.Stroke.small)
                .background(IMECHTheme.color.accent)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInputs() {
    var value by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        InputText(
            value = value,
            placeholder = "Full Name",
            onValueChange = { value = it }
        )

        Spacer(Modifier.height(8.dp))

        InputText(
            value = value,
            placeholder = "Password",
            onValueChange = { value = it },
            isPass = true
        )
    }
}




