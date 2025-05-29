Tower of Hanoi : iterative / recursive
Recursion: Permutations, Combinatorics, PowerSet(take not-take)
Time Complexity: iterative / recursive

Arrays: 
    - Contiguous
    - Fix size
    1. Insert: 
            first: O(n)
            last: O(1)
    2. Delete: 
            first: O(n)
            last: O(1)
    3. isEmpty(): O(1)
    4. length: O(1)
    5. Search: 
                - Sorted: O(logn)
                - Unsorted: O(n)

        2D Arrays:
                - Array of Arrays
                - Matrix Operations: 
                        - Add, Subtract
                        - Multiply
                        - Transpose
                        - Adjoint, Inverse

Linked List: 
    - Non-Contiguous
    - Node: data, next
    - Singly, Doubly, Circular
    1. Insert: 
            first: O(1)
            last: O(n)
    2. Delete: 
            first: O(1)
            last: O(n)
    3. isEmpty(): O(1)
    4. length: O(1)
    5. Reverse: O(n)

        Doubly Linked List:
                - head, tail
                - next, prev
                1. Insert: O(n)
                2. Delete: O(n)
                3. isEmpty: O(1)
                4. length: O(1)
                5. Reverse: O(n)
        
        Circular Linked List:
                - head
                - Used in operating systems to serve jobs in round-robin fashion (CPU scheduling)
                - Singly, Doubly

Stack:
    - LIFO
    - Implemented using Arrays and LL
    - Postfix, Infix, Prefix expressions
    1. Insert: O(1) : push()
    2. Delete: O(1) : pop()
    3. isEmpty(): O(1)
    4. length: O(1)

Queue:
    - FIFO 
    - Implemented using Arrays and LL
    1. Insert: O(1) : enqueue()
    2. Delete: O(1) : dequeue()
    3. isEmpty(): O(1)
    4. length: O(1)

Priority Queue:
    - Implemented as Array of Arrays, Array of Linked Lists, Linked List of Arrays, Linked List of Linked Lists
    1. Insert: O(n) : enqueue() 
    2. Delete: O(1) : dequeue()
                or 
    1. Insert: O(1) : enqueue() 
    2. Delete: O(n) : dequeue()
 
    3. isEmpty(): O(1)
    4. length: O(1)

Searching:
    - Linear: 
            - Best: O(1)
            - Avg: O(n) 
            - Worst: O(n)

    - Sorted Linear Search: 
            - Best: O(1)
            - Avg: O(n) 
            - Worst: O(n)
            // Only beneficial when element to be searched is not in array but is in the range of arrMin to arrMax

    - Binary Search:
            - Best: O(1)
            - Avg: O(log(n))
            - Worst: O(log(n))

Sorting: To make search operation easy 
// Based on comparisons: 

    1. Bubble Sort:
        - Time Complexity is due to 1. Compare consecutive elements 2. Swap if not in order
                - Best: O(n)
                - Avg: O(n^2) 
                - Worst: O(n^2)

    2. Selection Sort:
                - Best: O(n)
                - Avg: O(n^2) 
                - Worst: O(n^2)

    3. Insertion Sort:
        - Can be implemented recursively
                - Best: O(n)
                - Average: O(n^2)
                - Worst: O(n^2)
    4. Merge Sort: 
        - Divide and Conquer approach
        - O(n) to merge and O(nlogn) to divide
        - Recurrence Relation: T(n) = 2T(n - 1) + n
        - Space Complexity: O(n)
        - Recursion
                - Best: O(nlogn)
                - Average: O(nlogn)
                - Worst: O(nlogn)
    5. Quick Sort: 
        - Divide and Conquer approach
        - Space Complexity: O(1)
        - Recurrence Relation: T(n) = 2T(n - 1) + n
        - Invented by Tony Hoare (Turing Award)
        - Recursion 
                - Best: O(nlogn)
                - Average: O(nlogn)
                - Worst: O(n^2)


Hashing:
        - HashTable / HashMap 
        - Store elements as key-value pairs
        
    Trees:
            - Non linear Data Structure
            - Hierarchichal
            - Undirected Acyclic Connected Graph 
            - Node, Root, Path, Leaves, Ancestors, Level, Subtree, Height, Depth
            - Traversals: 
                    1. Depth First Traversal: O(n) 
                            - PreOrder: Root -> Left -> Right 
                            - Inorder: Left -> Root -> Right 
                            - PostOrder: Left -> Right -> Root
                    2. Breadth First Traversal: O(n)
                            - Level Order Traversal
                                    - Queue Data Structure is used (FIFO)

            - Binary Tree:
                    - Each parent has atmost 2 children
                    - Count Nodes: O(n)
                    - Sum of Nodes: O(n)
                    - Height of Tree: O(n)
                    - Diameter of Tree: O(n^2)
                    - Diameter of Tree using extra structure / class: O(n)
                    - SubTree of MainTree
    
            - Perfect Binary Tree
                    - Every node has exact 2 children
                    - Full Binary Tree with all leaf nodes at same height
            - Complete Binary Tree
                    - Perfect Binary Tree till height-1
                    - Addition of nodes takes place from left to right 
            - Full Binary Tree
                    - Every node has either 0 or 2 children
                    - Internal Nodes(I), Total Nodes(N), Leaf Nodes(L)
                            - N = 2I + 1
                            - L = I + 1
            
            - Binary Search Tree:
                    - Left < Root, Right > Root (No duplicates)
                    - Inorder Traversal -> Sorted Sequence
                    - insert(root, val) : Avg: O(h), Worst: O(n)
                    - search(root, val) : Avg: O(h), Worst: O(n)
                    - delete(root, val) : Avg: O(h), Worst: O(n)
                            - Leaf Node -> return null
                            - One Child -> return non null node
                            - Two Children -> return inorder successor (leftmost node in right subtree)
    
            - Adelson Velsky Landis:
                    - BST with |Hl - Hr| <= 1
                    - Insertion(4 Cases): 
                            - Left Rotation
                            - Right Rotation
                            - Left-Right Rotation
                            - Right-Left Rotation
                    
