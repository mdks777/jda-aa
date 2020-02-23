package command

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

interface Command {
    val name : String
    fun handle(event : GuildMessageReceivedEvent){}

}