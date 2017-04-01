package platform.app

import platform.app.GameSnapshot
import platform.app.GameState
import platform.app.controllers.Game
import platform.gamelib.AI


class GameArbitr(game: Game) {
    private var game : Game
    init {
        this.game = game
    }
    fun LoadAI(ai : AI, id: Int) {

    }
    fun CurrentState() : GameState {
        return GameState.NOT_LOADED
    }
    fun Start() {

    }
    fun GetSnapshot(id : Int) : GameSnapshot {
        return GameSnapshot("empty")
    }

}