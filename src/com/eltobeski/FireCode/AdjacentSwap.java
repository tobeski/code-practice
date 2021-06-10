package com.eltobeski.FireCode;/*

Given a linked list, swap every two adjacent nodes and return its head.

empty ll => null
only one node => that node

odd number means tails can't be swapped
even number means a previoud node switches with tail

1 -> 2 -> 3 -> 4 ==> 2 -> 1 -> 4 -> 3

*
prevNext = 2.next

1.next = prevNext
2.next = 1

*
1.next
4.next
3.next


head
1.next = prevNext
2.next = 1


middle
1.next
4.next
3.next


1 -> 2' -> 3 -> 4' -> 5

node = head // 1

next = node.next // 2 ..

node.next = next.next // 1 -> 3..

next.next = node // 2 -> 1

node = node.next // 2


r_func(node, next, boolean shouldSwap)
  // even count
  if(next.next == null && shouldSwap){
    swap(node, next)
    return next;
  }
  
  // odd count
  if (next.next == null){
    return next;
  }
  

  
  // 1 - 2 - 4 - 3
  nextArg =  next.next
  next.next = null
  
  swap(node, next)
  
  list = r_func(next, nextArg, !isEven)
  
  node.next = list
  
  return next;


r_func(null, 1, false) => 1
2 - 1 - 4 - 3

r_func(1, nextNode, true) => 2 => r_func(1, 2, true)
  2 - 1
  list = 4 - 3
  
  2 - 1 - 4 - 3
  
  
r_func(2, nextNode, false) => 3
  list = 4 - 3

r_func(3, 4, true) => 4
  4 - 3



Use recursion :)


public class ListNode {
      public   int data;
      public   ListNode next;
      public   ListNode(int data) { this.data = data; }
}

*/
import java.util.*;

public class AdjacentSwap {
  
    private static List<Integer> sortRecursively(LinkedList<Integer> input, int currentIndex) {
      if (currentIndex >= input.size() || currentIndex == input.size() - 1) {
        return input;
      }

      int indexRightNow = currentIndex;
      int nextIndex = ++currentIndex;

      int currentItem = input.get(indexRightNow);
      int nextItem = input.get(nextIndex);

      input.set(indexRightNow, nextItem);
      input.set(nextIndex, currentItem);

      return sortRecursively(input, ++currentIndex);
  }
  
   public static void main( String args[] ) {
    System.out.println( "Practice makes Perfect!" );
    LinkedList<Integer> input = new LinkedList<>();
    input.add(1);
    input.add(2);
    input.add(3);
    input.add(4);
    input.add(5);

    List<Integer> result = sortRecursively(input, 0);

    System.out.println(result);
  }
  

}
