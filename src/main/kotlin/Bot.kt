import BotAdapter.Companion.waiter
import net.dv8tion.jda.api.JDABuilder

fun main() {
    val jda = JDABuilder("NjYyMjU2NDgwNjk0Njk3OTg0.Xk0pjA.o4dOhSavqY6ykGWddT7Hsi9p07s").addEventListeners(BotAdapter(), waiter).build().awaitReady()
}