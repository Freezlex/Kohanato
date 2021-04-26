package com.freezlex.jamesbot.internals.commands

import com.freezlex.jamesbot.implementation.commands.PingCommand
import org.reflections.Reflections
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * The command registry for the bot.
 * Here we can get/get all/register/register multiple commands
 */
@Component
class CommandsRegistry{

    @Autowired
    lateinit var pingCommand: PingCommand

    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    init{
        this.logger.info("Loading automatically all commands");
    }

    /**
     * Let's automatically load all the commands with Reflection from the commands.implementation package
     */
    fun loadCommands() {
        commands.addAll(listOf(
            pingCommand
        ))
        this.logger.info("${getCommands().size} commands loaded");
    }

    companion object{
        private val commands = mutableListOf<Command>();

        /**
         * Register a new single command
         * @param cmd The command that we want to register
         * @return If the command has been registered or not
         */
        fun registerCommand(cmd: Command): Boolean = commands.add(cmd);

        /**
         * Get a command with the name/alias
         * @param name The name of the command that we want to find
         * @return The found command or null
         */
        fun getCommandByName(name: String): Command? = commands.find { it.name == name || it.alias?.contains(name) == true }

        /**
         * Get all the commands registered in the CommandRegistry
         * @return The command list contained in the CommandsRegistry
         */
        fun getCommands(): MutableList<Command> = commands;
    }
}
