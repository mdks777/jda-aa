import com.jagrosh.jdautilities.commons.waiter.EventWaiter
import command.Command
import command.HelloCommand
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class BotAdapter : ListenerAdapter() {
    companion object {
        val waiter = EventWaiter()
    }

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (!event.message.contentRaw.startsWith(";")) return
        if (event.message.author == event.jda.selfUser) return

        val commandMap = mapOf<String, Command>(
            HelloCommand().name to HelloCommand()
        )

        println("step 1")

        val command = commandMap[event.message.contentRaw.split(" ")[0].substring(1)]?: kotlin.run {
            println("command not found")
            return
        }
        command.handle(event)
    }
}