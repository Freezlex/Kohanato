package com.freezlex.kohanato.core.commands.contextual

import com.freezlex.kohanato.core.KoListener
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent

interface SlashCommand: BaseCommand {

    suspend fun run(core: KoListener, event: SlashCommandInteractionEvent) {
        super.run(core, event)
    }
}
