package a


class Person(val name: String, val id: Int, val cpg: Double) {
    override fun toString() = "[$name, $id, $cpg]"
}

interface Comparator {
    /**
     * compares the first person with the second one.
     * @param first the first person to compare
     * @param second the second person to compare with
     * @return 1 if the first person is bigger than the second one
     *        -1 if the first person is less than the second one
     *         0 if both person are equal
     */
    fun compare(first: Person, second: Person): Int
}

class IdComparator : Comparator {
    override fun compare(first: Person, second: Person): Int {
        return when {
            first.id > second.id -> 1
            first.id < second.id -> -1
            else -> 0
        }
    }
}

class NameComparator : Comparator {
    override fun compare(first: Person, second: Person): Int {
        return when {
            first.name > second.name -> 1
            first.name < second.name -> -1
            else -> 0
        }
    }
}

class CpgComparator : Comparator {
    override fun compare(first: Person, second: Person): Int {
        return when {
            first.cpg > second.cpg -> 1
            first.cpg < second.cpg -> -1
            else -> 0
        }
    }
}

fun sort(persons: Array<Person>, comparator: Comparator) {
    for (n in 0..persons.size - 2) {
        for (m in n + 1..persons.size - 1) {
            if (comparator.compare(persons[m], persons[n]) == -1) {
                val z = persons[n]
                persons[n] = persons[m]
                persons[m] = z
            }
        }
    }
}


fun sort(persons: Array<Person>, compare: (Person, Person) -> Int) {
    for (n in 0..persons.size - 2) {
        for (m in n + 1..persons.size - 1) {
            if (compare(persons[m], persons[n]) == -1) {
                val z = persons[n]
                persons[n] = persons[m]
                persons[m] = z
            }
        }
    }
}

fun main(args: Array<String>) {
    val persons = arrayOf(Person("n", 12, 3.5), Person("o", 11, 3.2), Person("m", 13, 3.1))
    println("original array")
    for (n in persons) {
        println(n)
    }

    sort(persons, NameComparator())
    println("sorted by name")
    for (n in persons) {
        println(n)
    }

    println()
    sort(persons) { first, second ->
        when {
            first.name > second.name -> 1
            first.name < second.name -> -1
            else -> 0
        }
    }

    persons.forEach { println(it) }
    sort(persons, IdComparator())
    println("sorted by Id")
    for (n in persons) {
        println(n)
    }

    println()
    sort(persons) { first, second ->
        when {
            first.id > second.id -> 1
            first.id < second.id -> -1
            else -> 0
        }
    }
    persons.forEach { println(it) }

    sort(persons, CpgComparator())
    println("sorted by CGP")
    for (n in persons) {
        println(n)
    }

    println()
    sort(persons) { first, second ->
        when {
            first.cpg > second.cpg -> 1
            first.cpg < second.cpg -> -1
            else -> 0
        }
    }
    persons.forEach { println(it) }
}
