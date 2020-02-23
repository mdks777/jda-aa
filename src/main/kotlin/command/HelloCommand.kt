package command

import BotAdapter.Companion.waiter
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import java.util.concurrent.TimeUnit

class HelloCommand : Command{
    override val name = "h"

    override fun handle(event: GuildMessageReceivedEvent) {
        val direct = DirectCommand()
        event.message.channel.sendMessage(event.message.contentRaw).queue()
        println("step 2 ${event.message.contentRaw}")
        Thread.sleep(1000)
        val count = waitString(event)
        Thread.sleep(1000)
        println("count is $count")
        //direct.handle(event,waitString(event),count)

        println("何故見える")
    }
}

fun waitString(event: GuildMessageReceivedEvent) : String{
    var receivedString = ""
    waiter.waitForEvent(
        GuildMessageReceivedEvent::class.java,
        {
            it.author == event.author &&
                    it.message != event.message &&
                    it.channel == event.channel
        },
        {
            receivedString = it.message.contentRaw
        },
        10, TimeUnit.SECONDS, { event.channel.sendMessage("time2").queue()}
    )
    return receivedString
}