package com.freezlex.jamesbot.internals.models

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

data class MessageModel(
    val pattern: MatchResult?,
    val event: GuildMessageReceivedEvent,
    val guildCache: GuildCache,
    val argsString: String,
    val validateQueue: MutableList<String>,
    val parsed: MutableList<ArgumentModel> = mutableListOf())
