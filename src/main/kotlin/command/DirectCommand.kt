package command

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent

class DirectCommand {
    fun handle(event: GuildMessageReceivedEvent,mozi : String,count : Int){
        println("step 5 $count")
        for (i in 0..count){
            event.message.channel.sendMessage("$count your message is $mozi")
        }

    }
}