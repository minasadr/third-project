package a

fun operate(a: Int, b: Int, operator: (Int, Int) -> Int) {
    val r = operator(a, b)
    println(r)
}

fun main(args: Array<String>) {
    val sum = { a: Int, b: Int -> a + b }
    println(sum(2, 4))

    val sub = { a: Int, b: Int -> a - b }
    println(sub(2, 4))

    val power2 = { a: Int -> a * a }
    println(power2(3))

    operate(2, 3, sum)
    operate(2, 3, sub)

    operate(2, 3, { a: Int, b: Int -> a * b })  // we can directly define the lambda as function parameter
    operate(12, 3, { a, b -> a / b })  // we can ignore the types, because kotlin can inference it.

    operate(12, 3) { a, b -> a % b } // if the last parameter is a lambda, you can put it outside.

    operate(12, 3) { a, b ->
        val x = a % b
        println("i am doing something crazy here")
        println("i am doing something crazy here")
        x
    }

    //    val x: Array<Int> = Array(10, {a: Int -> 0})
    val x: Array<Int> = Array(10) { 0 }
    x.forEach { print("$it, ") }
    println()

    //    val y: Array<Int> = Array(10, {a: Int -> a})
    val y: Array<Int> = Array(10) { it }
    //    for (i in y) print("$i, ")
    y.forEach { i -> print("$i, ") }
    println()

    //    val z: Array<Int> = Array(10, { a: Int -> a * 2 })
    val z: Array<Int> = Array(10) { it * 2 }
    for (i in z) print("$i, ")
    println()
}