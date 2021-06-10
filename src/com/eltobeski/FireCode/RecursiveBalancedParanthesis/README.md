# Distance if a node from the root in a binary tree

1. Repeat the question in your own words 
   - Ensure that for every open paranthesis that there exists a closed one 
2. Ask clarifying questions
   - What are the characters that are accepted
   - Are other characters allowed
   - How is the distance being calculated i.e Does calculation start from the root being 0 distance or 1 distance.
3. Do you know the input and output
   - Input: TreeNode(Root) and an integer
   - Output: Minimum Distance to Node from root(Integer)
4. What edge cases have you thought about
   - If root is equal to the value return 1
5. What is your approach (the first solution that comes to mind) ⇒ Write out the pseudocode & time complexity
   Everytime theres an open paranthesis add it to a stack. If it's a closed one then compare it to what's in the stack and recurse.
6. What is your second approach, if available ⇒ Write out the pseudocode & time complexity
    1. can you come up with something more efficient?
    2. can you come up with a different way of solving the problem (doesn't have to be more efficient)?
7. Test the code
    1. Dry run
    2. Find the mistakes
8. Sometimes the time complexity is not trivial, so you may want to leave it for last. Write out the time complexity of your solution here, if you don't have it

##Here are the steps that went on in my mind for this question
