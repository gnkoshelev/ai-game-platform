package test.stuff

class ForeignGreeter : IGreeter {

    override fun greet(who: String): String {
        return "Hello, $who!"
    }

}