package app.controllers

import com.fasterxml.jackson.annotation.JacksonAnnotation
import com.mongodb.client.MongoCollection
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.litote.kmongo.* //NEEDED! import KMongo extensions
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.bson.codecs.configuration.CodecRegistry


data class Game(val name: String)

@RestController
class GameController {

    @RequestMapping("/game/{gameName}/")
    fun gameMapping(@PathVariable("gameName") gameName: String) : String {
        val client = KMongo.createClient()
        val database = client.getDatabase("test")
        val collection = database.getCollection<Game>()
        val game = Game(gameName)
        collection.save(game)
        return collection.find().map({game:Game -> game.name}).joinToString()
    }
}