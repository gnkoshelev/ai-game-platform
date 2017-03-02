package app.controllers

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



data class Game(val name: String)

@RestController
class GameController {

    @RequestMapping("/game/{gameName}/")
    fun gameMapping(@PathVariable("gameName") gameName: String) : Game {
        return  Game(gameName)
    }
}