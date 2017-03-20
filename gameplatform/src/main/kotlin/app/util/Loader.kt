package app.util

import java.io.File
import java.net.URL
import java.net.URLClassLoader

/**
 * Created by Igor on 20.03.2017.
 */
class Loader(urls : Array<out URL>) : URLClassLoader(urls) {

    fun loadDotClass(url: URL, fullClassName: String): Class<*>? {
        val bytes = File(url.toURI()).readBytes()
        return defineClass(fullClassName, bytes, 0, bytes.size)
    }

}