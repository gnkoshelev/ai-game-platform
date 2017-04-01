package platform.gamelib

import platform.gamelib.AI
import platform.common.Json


/**
 * Created by Igor on 23.03.2017.
 */

interface IGame {

    fun LoadAi(ai: AI, id: Int) : StatusCode
//    fun NextStep(turn: PlayerTurn): GameTurn
    fun GetStatus() : StatusCode
    fun GameInit(gameSettings : Json) : StatusCode
    fun GetHelp() : Json
    fun GetResults() : Json
}

