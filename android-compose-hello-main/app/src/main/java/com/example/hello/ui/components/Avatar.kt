package com.example.hello.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Круглый аватар пользователя с инициалами.
 * @param modifier Модификатор внешнего вида и расположения аватара.
 */
@Composable
fun Avatar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(120.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "КА",
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

/** Предпросмотр круглого аватара. */
@Composable
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
fun AvatarPreview() {
    Avatar()
}
