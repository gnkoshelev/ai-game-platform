package game

import platform.common.Json
import platform.gamelib.AI
import platform.gamelib.IGame
import platform.gamelib.StatusCode

@Suppress("unused")
/**
 * Created by Igor on 23.03.2017.
 */

class Game: IGame {

    override fun LoadAi(ai: AI, id: Int): StatusCode {
        return StatusCode.OK
    }

    override fun GetStatus(): StatusCode {
        return StatusCode.OK
    }

    override fun GameInit(gameSettings: Json): StatusCode {
        return StatusCode.OK
    }

    override fun GetHelp(): Json {
        return Json()
    }

    override fun GetResults(): Json {
        return Json()
    }
}