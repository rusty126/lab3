package com.example.hello.data

/**
 * Модель данных профиля пользователя.
 * @property name Имя и первая часть ФИО пользователя.
 * @property surname Фамилия или оставшаяся часть ФИО пользователя.
 * @property status Текст статуса пользователя.
 * @property followers Количество подписчиков.
 * @property isSubscribed Состояние подписки текущего пользователя.
 */
data class User(
    val name: String = "Кара Артем",
    val surname: String = "Валерьевич",
    val status: String = "Изучаю программирование мобильных устройств 📱",
    val followers: Int = 128,
    val isSubscribed: Boolean = false
)
