package platform.app.util

import org.junit.Assert
import org.junit.Test
import platform.gamelib.IGame
import test.stuff.ForeignGreeter
import test.stuff.IGreeter
import kotlin.test.assertEquals


/**
 * Created by Igor on 20.03.2017.
 */

internal class LoaderTest {

    @Test fun usageTest() : Unit {
        val resource = javaClass.getResource("/ForeignGreeter.class")
        Assert.assertNotNull(resource)

        val loader = Loader(arrayOf())
        val loadedClass = loader.loadClassFromResource(resource, "test.stuff.ForeignGreeter")
        val newInstance = loadedClass!!.newInstance()

        if (newInstance is IGreeter) {
            val ktulhu = "Ktulhu"
            assertEquals(newInstance.greet(ktulhu), ForeignGreeter().greet(ktulhu))
        }
        else Assert.fail("$newInstance is not IGreeter!")
        println(".class loading checked!")
    }

    @Test fun jarLoadTest() : Unit {
        val resource = javaClass.getResource("/woh.jar")
        val loader  = Loader(arrayOf(resource.toURI().toURL()))
        val gameclass = loader.loadClass("game.Game")

        if (gameclass == null) {
            Assert.fail("Game not found.")
            return
        }

        val instance = gameclass.newInstance()
        if (instance is IGame) {
            println(instance.GetStatus())
        }
        else Assert.fail("$instance is not IGame")

        println(".jar loading checked!")

    }
}