package app.util

import org.junit.Assert
import org.junit.Test
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

        val loader = Loader(arrayOf(resource.toURI().toURL()))
        val loadedClass = loader.loadDotClass(resource, "test.stuff.ForeignGreeter")
        val newInstance = loadedClass!!.newInstance()

        if (newInstance is IGreeter) {
            val ktulhu = "Ktulhu"
            assertEquals(newInstance.greet(ktulhu), ForeignGreeter().greet(ktulhu))
        }
        else Assert.fail("$newInstance is not IGreeter!")
    }
}