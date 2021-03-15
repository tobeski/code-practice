# Insert a Node at specified position in a LinkedList

##Here are the steps that went on in my mind for this question
1. Firstly I thought of how to take care of null values.
2. That was taken care of by assigning the new node to the empty ListNode
3. Next I took care of the scenario that the first node was what was to be repositioned
4. After taking care of these two "Edge cases" I created an integer that was one step faster than the current position in order to know when to switch places with the new node;
5. Next was the while loop that ensured that the next value in our list node was not null
6. At the end of the day if we go through and find out the next value in the listNode is null and we still haven't inserted the new node, then we assign it to the current node just at the end of the ListNodes.

