package org.example

import arrow.core.*

// https://github.com/dkandalov/kotlin-99
class NinetyNineProblems() {

    // P01 (*) Find the last element of a list.
    fun <T> last(l: List<T>): T = l[l.lastIndex]

    tailrec fun <T> lastRecursive(l: List<T>): T =
        if (l.size == 1) l[0] else lastRecursive(l.subList(1, l.size))

    // P02 (*) Find the last but one element of a list.
    fun <T> penultimate(l: List<T>): T = l[l.lastIndex - 1]

    // P03 (*) Find the Nth element of a list. (first element is the '0th' element)
    tailrec fun <T> nth(l: List<T>, n: Int): T =
        if (n == 0) l[0] else nth(l.drop(1), n - 1)

    // P04 (*) Find the number of elements of a list.
    fun <T> length(l: List<T>): Int {
        tailrec fun <T> length(l: List<T>, length: Int): Int =
            if (l.isEmpty()) length else length(l.drop(1), length + 1)
        return length(l, 0)
    }

    // P05 (*) Reverse a list.
    fun <T> reverse(l: List<T>): List<T> =
        if (l.size == 1) l else reverse(l.drop(1)).plus(l[0])

    // P06 (*) Find out whether a list is a palindrome.
    fun <T> palindrome(l: List<T>): Boolean =
        l.zip(reverse(l)).fold(true) { acc, (a, b) -> a == b && acc }

    // P07 (*) Flatten a nested list structure.
    @Suppress("UNCHECKED_CAST")
    fun flatten(l: List<Any>): List<Any> = l.flatMap {
        if (it is List<*>) flatten(it as List<Any>) else listOf(it)
    }

    // P08 (*) Eliminate consecutive duplicates of list elements.
    fun <T> compress(l: List<T>): List<T> = l.fold(emptyList<T>()) { acc, t ->
        if (acc.isNotEmpty() && acc.first() == t) acc
        else listOf(t) + acc
    }.reversed()

    // P09 (*) Pack consecutive duplicates of list elements into sub-lists.
    fun <T> pack(l: List<T>): List<List<T>> =
        if (l.isEmpty()) emptyList()
        else {
            val packed = l.takeWhile { it == l.first() }
            listOf(packed) + pack(l.drop(packed.size))
        }

    // P10 (*) Run-length encoding of a list.
    fun <T> encode(l: List<T>): List<Pair<Int, T>> =
        pack(l).map { Pair(it.size, it.first()) }

    // P11 (*) Modified run-length encoding.
    fun <T> encodeModified(l: List<T>): List<Any?> =
        pack(l).map {
            if (it.size == 1) it.first()
            else Pair(it.size, it.first())
        }

    // P12 (*) Decode a run-length encoded list.
    fun <T> decode(l: List<Pair<Int, T>>): List<T> = l.fold(emptyList<T>()) { acc, pair ->
        acc + (1..pair.first).map { pair.second }
    }

    // P13 (*) Run-length encoding of a list (direct solution).
    fun <T> encodeDirect(l: List<T>): List<Pair<Int, T>> =
        if (l.isEmpty()) {
            emptyList()
        } else {
            val packed = l.takeWhile { it == l.first() }
            val pair = Pair(packed.size, packed.first())
            listOf(pair) + encodeDirect(l.drop(packed.size))
        }

    // P14 (*) Duplicate the elements of a list.
    fun <T> duplicate(l: List<T>): List<T> = l.fold(emptyList<T>()) { acc, e ->
        acc + e + e
    }

    // P15 (*) Duplicate the elements of a list a given number of times.
    tailrec fun <T> duplicateN(n: Int, l: List<T>, acc: List<T> = emptyList()): List<T> =
        if (l.isEmpty()) acc else duplicateN(n, l.drop(1), acc + (1..n).map { l.first() })

    // P16 (*) Drop every Nth element from a list.
    fun <T> dropEvery(n: Int, l: List<T>): List<T> = l.zip(1..l.size).fold(emptyList()) { acc, pair ->
        if (pair.second % n == 0) acc else acc + pair.first
    }

    // P17 (*) Split a list into two parts.
    fun <T> split(n: Int, l: List<T>): Pair<List<T>, List<T>> = Pair(l.take(n), l.drop(n))

    // P18 (*) Extract a slice from a list.
    fun <T> slice(s: Int, e: Int, l: List<T>): List<T> = l.zip(l.indices).fold(emptyList()) { acc, pair ->
        if (pair.second in s..<e) acc + pair.first else acc
    }

    // P19 (*) Rotate a list N places to the left.
    fun <T> rotate(n: Int, l: List<T>): List<T> =
        if(n != 0) {
            val rotation = if (n > 0) n % l.size else n % l.size + l.size
            slice(rotation, l.size, l) + slice(0, rotation, l)
        } else l



}
