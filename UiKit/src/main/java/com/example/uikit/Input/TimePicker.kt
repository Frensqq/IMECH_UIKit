package com.example.uikit.Input

import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Dimension
import com.example.uikit.UI.IMECHTheme
import java.util.Calendar
import java.util.Locale

/**
 * Функция выбора времени
 *
 * @param time - выбранное время
 * @param onValueChange - изменение выбранного времени
 *
 *ЛядовС 09.10.26
 */
@Composable
fun TimePicker(
    time: String,
    onValueChange: (String) -> Unit
) {
    val context = LocalContext.current
    val calendar = remember { Calendar.getInstance() }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(Dimension.Spacer.default),
        modifier = Modifier.clickable {
            TimePickerDialog(
                context,
                { _, hour, minute ->
                    val stringFormat = String.format(
                        Locale.US,
                        "%02d:%02d %s",
                        if (hour % 12 == 0) 12 else hour % 12,
                        minute,
                        if (hour < 12) "AM" else "PM"
                        )
                    onValueChange(stringFormat)
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                false
            ).show()
        }
    ) {
        Text(time, style = IMECHTheme.typography.titleMedium)
        Icon(
            painterResource(R.drawable.dropdown),
            contentDescription = null,
            tint = IMECHTheme.color.accent
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewTimePicker() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        var time by remember { mutableStateOf("12:30 PM") }

        TimePicker(time) { time = it }
    }
}