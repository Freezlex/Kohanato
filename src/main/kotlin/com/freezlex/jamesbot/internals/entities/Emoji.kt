package com.freezlex.jamesbot.internals.entities

class Emoji(
    val name: String,
    val id: Long,
    val animated: Boolean
) {
    val url: String
        get() {
            val extension = if (animated) "gif" else "png"
            return "https://cdn.discordapp.com/emojis/$id.$extension"
        }
}