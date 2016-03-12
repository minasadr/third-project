package a

import java.util.*

interface Matcher {
    /**
     * matches if the given person has a certain condition
     * @param person the person to match against
     * @return true if person has the condition
     *         false if the person has not the condition
     */
    fun match(person: Person): Boolean
}

class Bigger(val cpg: Double) : Matcher {
    override fun match(person: Person): Boolean = person.cpg > cpg
}

class Lower(val cpg: Double) : Matcher {
    override fun match(person: Person): Boolean = person.cpg < cpg
}

fun find(persons: List<Person>, matcher: Matcher): List<Person> {
    val result = ArrayList<Person>()
    for (person in persons) {
        if (matcher.match(person)) {
            result.add(person)
        }
    }
    return result
}



fun main(args: Array<String>) {
    val persons = listOf(Person("n", 12, 3.5), Person("o", 11, 3.6), Person("m", 13, 3.1))
    val result = find(persons, Bigger(3.4))
    for (n in result) {
        println(n)
    }

    println("lower CPG")
    val resultLower = find(persons, Lower(3.4))
    for (n in resultLower) {
        println(n)
    }
}

