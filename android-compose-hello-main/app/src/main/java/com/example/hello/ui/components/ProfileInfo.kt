package com.example.hello.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hello.data.User

/**
 * Отображает ФИО, статус и количество подписчиков.
 * @param user Данные пользователя.
 * @param fullName Имя для отображения; позволяет показывать отредактированное значение.
 * @param followers Актуальное количество подписчиков.
 * @param modifier Модификатор расположения компонента.
 */
@Composable
fun ProfileInfo(
    user: User,
    fullName: String = "${user.name} ${user.surname}",
    followers: Int = user.followers,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = fullName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )
        Text(
            text = user.status,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Подписчиков: $followers",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

/** Предпросмотр блока информации профиля. */
@Composable
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
fun ProfileInfoPreview() {
    ProfileInfo(user = User())
}
