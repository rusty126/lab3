package com.example.hello.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.scale
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Набор кнопок управления подпиской и сбросом имени.
 * @param isSubscribed Текущее состояние подписки.
 * @param onSubscribeClick Обработчик нажатия на кнопку подписки.
 * @param onResetClick Обработчик сброса имени.
 * @param modifier Модификатор расположения кнопок.
 */
@Composable
fun ActionButtons(
    isSubscribed: Boolean,
    onSubscribeClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val buttonScale by animateFloatAsState(
        targetValue = if (isSubscribed) 1.04f else 1f,
        label = "subscriptionScale"
    )
    val buttonColor by animateColorAsState(
        targetValue = if (isSubscribed) Color(0xFF64748B) else Color(0xFF2563EB),
        label = "subscriptionColor"
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = onSubscribeClick,
            modifier = Modifier.weight(1f).scale(buttonScale),
            colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
        ) {
            Text(if (isSubscribed) "Отписаться" else "Подписаться")
        }
        OutlinedButton(
            onClick = onResetClick,
            modifier = Modifier.weight(1f)
        ) {
            Text("Сбросить")
        }
    }
}

/** Предпросмотр кнопок действий. */
@Composable
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
fun ActionButtonsPreview() {
    ActionButtons(isSubscribed = false, onSubscribeClick = {}, onResetClick = {})
}
