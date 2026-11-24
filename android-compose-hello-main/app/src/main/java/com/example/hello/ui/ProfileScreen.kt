package com.example.hello.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.hello.data.User
import com.example.hello.ui.components.ActionButtons
import com.example.hello.ui.components.Avatar
import com.example.hello.ui.components.ProfileInfo

/**
 * Главный интерактивный экран профиля пользователя.
 * @param user Исходные данные профиля.
 * @param modifier Модификатор внешнего расположения экрана.
 * @param onThemeChange Колбэк изменения темы приложения.
 */
@Composable
fun ProfileScreen(
    user: User = User(),
    modifier: Modifier = Modifier,
    onThemeChange: (Boolean) -> Unit = {}
) {
    var fullName by remember { mutableStateOf("${user.name} ${user.surname}") }
    var isSubscribed by remember { mutableStateOf(user.isSubscribed) }
    var followers by remember { mutableIntStateOf(user.followers) }
    var clicks by remember { mutableIntStateOf(0) }
    var isDarkTheme by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text("Тёмная тема", color = MaterialTheme.colorScheme.onSurface)
            Spacer(Modifier.width(8.dp))
            Switch(
                checked = isDarkTheme,
                onCheckedChange = {
                    isDarkTheme = it
                    onThemeChange(it)
                }
            )
        }

        Spacer(Modifier.height(4.dp))
        Avatar()
        ProfileInfo(user = user, fullName = fullName, followers = followers)

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text("Имя и фамилия") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        HorizontalDivider()

        ActionButtons(
            isSubscribed = isSubscribed,
            onSubscribeClick = {
                isSubscribed = !isSubscribed
                followers += if (isSubscribed) 1 else -1
            },
            onResetClick = { fullName = "${user.name} ${user.surname}" }
        )

        Text(
            text = "Количество нажатий: $clicks",
            color = MaterialTheme.colorScheme.onSurface
        )
        Button(onClick = { clicks++ }) {
            Text("+")
        }
    }
}

/** Предпросмотр полного экрана профиля. */
@Composable
@androidx.compose.ui.tooling.preview.Preview(showBackground = true, showSystemUi = true)
fun ProfileScreenPreview() {
    ProfileScreen()
}
