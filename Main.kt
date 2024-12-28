fun lol (args: Array<Int>) {
    for (i in args) {
        println(i * 2)
    }
}

fun main() {
    lol(args = arrayOf(1, 2, 3, 4, 5))
}