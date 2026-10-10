package com.example.uikit.Input

import android.app.DatePickerDialog
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
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * Функция выбора даты
 *
 * @param title - заголовок
 * @param value - выбранная дата
 * @param onValueChange - изменение выбранной даты
 *
 *ЛядовС 09.10.26
 */
@Composable
fun DatePicker(
    title: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    val context = LocalContext.current
    val calendar = remember { Calendar.getInstance() }

    Column(
        verticalArrangement = Arrangement.spacedBy(Dimension.Spacer.mediumVertical)
    ) {
        Text(
            title,
            style = IMECHTheme.typography.bodySmall.copy(
                fontFamily = FontFamily(Font(R.font.regular))
            ),
            color = IMECHTheme.color.accent
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimension.Spacer.default),
            modifier = Modifier.clickable {
                DatePickerDialog(
                    context,
                    { _, year, month, day ->
                        val selected = Calendar.getInstance().apply {
                            set(year, month, day)
                        }
                        val formatted = SimpleDateFormat(
                            "EEE, MMM d, yyyy",
                            Locale.US
                        ).format(selected.time).uppercase(Locale.US)

                        onValueChange(formatted) // ← вызываем ТОЛЬКО здесь
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        ) {
            Text(value, style = IMECHTheme.typography.titleMedium)
            Icon(
                painterResource(R.drawable.dropdown),
                contentDescription = null,
                tint = IMECHTheme.color.accent
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewDatePicker() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        var date by remember { mutableStateOf("MON, NOV 4, 2019") }

        DatePicker("FROM", date) { date = it }
    }
}