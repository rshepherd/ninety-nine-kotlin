import org.example.NinetyNineProblems
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class NinetyNineProblemsTest {

   private val ninetyNine = NinetyNineProblems()

   @Test fun `find last element of list`() {
     val l = listOf(1, 2, 3, 4, 5, 6, 7, 8)
     assertEquals(ninetyNine.last(l), 8)
     assertEquals(ninetyNine.lastRecursive(l), 8)
   }

   @Test fun `find the penultimate element of a list`() {
     assertEquals(ninetyNine.penultimate(listOf(1, 1, 2, 3, 5, 8)), 5)
   }

   @Test fun `find the Nth element of a list`() {
     assertEquals(ninetyNine.nth(listOf(1, 1, 2, 3, 5, 8), 5), 8)
   }

   @Test fun `find the number of elements of a list`() {
     assertEquals(ninetyNine.length(listOf(1, 1, 2, 3, 5, 8)), 6)
   }

   @Test fun `reverse a list`() {
     assertEquals(ninetyNine.reverse(listOf(1, 1, 2, 3, 5, 8)), listOf(8, 5, 3, 2, 1, 1))
   }

   @Test fun `find out whether a list is a palindrome`() {
     assertEquals(ninetyNine.palindrome(listOf(1)), true)
     assertEquals(ninetyNine.palindrome(listOf(1, 2)), false)
     assertEquals(ninetyNine.palindrome(listOf(1, 2, 1)), true)
     assertEquals(ninetyNine.palindrome(listOf(1, 2, 2, 1)), true)
     assertEquals(ninetyNine.palindrome(listOf(1, 2, 1, 1)), false)
   }

   @Test fun `flatten a nested list structure`() {
     assertEquals(ninetyNine.flatten(listOf(listOf(1))), listOf(1))
     assertEquals(
       ninetyNine.flatten(listOf(listOf(1, 1, 2), listOf(3, listOf(5, 8)))),
       listOf(1, 1, 2, 3, 5, 8)
     )
   }

   @Test fun `eliminate consecutive duplicates of list elements`() {
     assertEquals(ninetyNine.compress("".toList()), "".toList())
     assertEquals(ninetyNine.compress("abc".toList()), "abc".toList())
     assertEquals(ninetyNine.compress("aaa".toList()), "a".toList())
     assertEquals(ninetyNine.compress("aaaabccaadeeee".toList()), "abcade".toList())
   }

   @Test fun `pack consecutive duplicates of list elements into sublists`() {
     assertEquals(ninetyNine.pack("a".toList()), listOf("a".toList()))
     assertEquals(ninetyNine.pack("aaa".toList()), listOf("aaa".toList()))
     assertEquals(ninetyNine.pack("aaaabccaadeeee".toList()), listOf(
       "aaaa".toList(), "b".toList(), "cc".toList(), "aa".toList(), "d".toList(), "eeee".toList()
     ))
   }

   @Test fun `run-length encoding of a list`() {
     assertEquals(ninetyNine.encode("aaaabccaadeeee".toList()), listOf(
       Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
     ))
   }

   @Test fun `modified run-length encoding`() {
     assertEquals(ninetyNine.encodeModified("aaaabccaadeeee".toList()), listOf<Any>(
       Pair(4, 'a'), 'b', Pair(2, 'c'), Pair(2, 'a'), 'd', Pair(4, 'e')
     ))
   }

   @Test fun `decode a run-length encoded list`() {
     assertEquals(ninetyNine.decode(listOf(
       Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
     )), "aaaabccaadeeee".toList())
   }

   @Test fun `run-length encoding of a list (direct solution)`() {
     assertEquals(ninetyNine.encodeDirect("aaaabccaadeeee".toList()), listOf(
       Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e')
     ))
   }

   @Test fun `duplicate the elements of a list`() {
     assertEquals(ninetyNine.duplicate("abccd".toList()), "aabbccccdd".toList())
   }

   @Test fun `duplicate the elements of a list a given number of times`() {
     assertEquals(ninetyNine.duplicateN(3, "abccd".toList()), "aaabbbccccccddd".toList())
   }

   @Test fun `drop every Nth element from a list`() {
     assertEquals(ninetyNine.dropEvery(3, "abcdefghijk".toList()), "abdeghjk".toList())
   }

   @Test fun `split a list into two parts`() {
     assertEquals(ninetyNine.split(3, "abcdefghijk".toList()), Pair("abc".toList(), "defghijk".toList()))
   }

   @Test fun `extract a slice from a list`() {
     assertEquals(ninetyNine.slice(3, 7, "abcdefghijk".toList()), "defg".toList())
   }

   @Test fun `rotate a list N places to the left`() {
     assertEquals(ninetyNine.rotate(3, "abcdefghijk".toList()), "defghijkabc".toList())
     assertEquals(ninetyNine.rotate(-2, "abcdefghijk".toList()), "jkabcdefghi".toList())
   }
}