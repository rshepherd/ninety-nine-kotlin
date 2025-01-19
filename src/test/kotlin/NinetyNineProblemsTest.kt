package org.example

import org.example.NinetyNineProblems
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NinetyNineProblemsTest {

   private val nn = NinetyNineProblems()

   @Test fun `find last element of list`() {
     val l = listOf(1, 2, 3, 4, 5, 6, 7, 8)
     assertEquals(nn.last(l), 8)
     assertEquals(nn.lastRecursive(l), 8)
   }

   @Test fun `find the penultimate element of a list`() {
     assertEquals(nn.penultimate(listOf(1, 1, 2, 3, 5, 8)), 5)
   }

   @Test fun `find the Nth element of a list`() {
     assertEquals(nn.nth(listOf(1, 1, 2, 3, 5, 8), 5), 8)
   }

   @Test fun `find the number of elements of a list`() {
     assertEquals(nn.length(listOf(1, 1, 2, 3, 5, 8)), 6)
   }

   @Test fun `reverse a list`() {
     assertEquals(nn.reverse(listOf(1, 1, 2, 3, 5, 8)), listOf(8, 5, 3, 2, 1, 1))
   }

   @Test fun `find out whether a list is a palindrome`() {
     assertEquals(nn.palindrome(listOf(1)), true)
     assertEquals(nn.palindrome(listOf(1, 2)), false)
     assertEquals(nn.palindrome(listOf(1, 2, 1)), true)
     assertEquals(nn.palindrome(listOf(1, 2, 2, 1)), true)
     assertEquals(nn.palindrome(listOf(1, 2, 1, 1)), false)
   }

   @Test fun `flatten a nested list structure`() {
     assertEquals(nn.flatten(listOf(listOf(1))), listOf(1))
     assertEquals(
       nn.flatten(listOf(listOf(1, 1, 2), listOf(3, listOf(5, 8)))),
       listOf(1, 1, 2, 3, 5, 8)
     )
   }

   @Test fun `eliminate consecutive duplicates of list elements`() {
     assertEquals(nn.compress("".toList()), "".toList())
     assertEquals(nn.compress("abc".toList()), "abc".toList())
     assertEquals(nn.compress("aaa".toList()), "a".toList())
     assertEquals(nn.compress("aaaabccaadeeee".toList()), "abcade".toList())
   }

   @Test fun `pack consecutive duplicates of list elements into sublists`() {
     assertEquals(nn.pack("a".toList()), listOf("a".toList()))
     assertEquals(nn.pack("aaa".toList()), listOf("aaa".toList()))
     assertEquals(nn.pack("aaaabccaadeeee".toList()), listOf(
       "aaaa".toList(), "b".toList(), "cc".toList(), "aa".toList(), "d".toList(), "eeee".toList()
     ))
   }

   @Test fun `run-length encoding of a list`() {
     assertEquals(nn.encode("aaaabccaadeeee".toList()), listOf(
       Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
     ))
   }

   @Test fun `modified run-length encoding`() {
     assertEquals(nn.encodeModified("aaaabccaadeeee".toList()), listOf<Any>(
       Pair(4, 'a'), 'b', Pair(2, 'c'), Pair(2, 'a'), 'd', Pair(4, 'e')
     ))
   }

   @Test fun `decode a run-length encoded list`() {
     assertEquals(nn.decode(listOf(
       Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
     )), "aaaabccaadeeee".toList())
   }

   @Test fun `run-length encoding of a list (direct solution)`() {
     assertEquals(nn.encodeDirect("aaaabccaadeeee".toList()), listOf(
       Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
     ))
   }

   @Test fun `duplicate the elements of a list`() {
     assertEquals(nn.duplicate("abccd".toList()), "aabbccccdd".toList())
   }

   @Test fun `duplicate the elements of a list a given number of times`() {
     assertEquals(nn.duplicateN(3, "abccd".toList()), "aaabbbccccccddd".toList())
   }

   @Test fun `drop every Nth element from a list`() {
     assertEquals(nn.dropEvery(3, "abcdefghijk".toList()), "abdeghjk".toList())
   }

   @Test fun `split a list into two parts`() {
     assertEquals(nn.split(3, "abcdefghijk".toList()), Pair("abc".toList(), "defghijk".toList()))
   }

   @Test fun `extract a slice from a list`() {
     assertEquals(nn.slice(3, 7, "abcdefghijk".toList()), "defg".toList())
   }

   @Test fun `rotate a list N places to the left`() {
     assertEquals(nn.rotate(3, "abcdefghijk".toList()), "defghijkabc".toList())
     assertEquals(nn.rotate(-2, "abcdefghijk".toList()), "jkabcdefghi".toList())
   }

   @Test fun `remove the Kth element from a list`() {
     assertEquals(nn.removeAt(1, "abcd".toList()), Pair(listOf('a', 'c', 'd'), 'b'))
   }

   @Test fun `insert an element at a given position into a list`() {
     assertEquals(nn.insertAt('X', 1, "abcd".toList()), "aXbcd".toList())
   }

   @Test fun `create a list containing all integers within a given range`() {
     assertEquals(nn.range(4, 9), listOf(4, 5, 6, 7, 8, 9))
   }
}