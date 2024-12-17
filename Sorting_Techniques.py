## Bubble Sort
def Bubble_Sort(L):
    n = len(L)
    if n <= 1:
        return L
    for i in range(n - 1):
        for j in range(n - 1):
            if L[j] > L[j + 1]:
                L[j], L[j + 1] = L[j + 1], L[j]
    return L
## Time Complexity: O(n^2) 

## Selection Sort
def Selection_Sort(L):
    n = len(L)
    
    if n <= 1:
        return L
    
    for i in range(n):
        # Assume L[:i] is sorted
        mpos = i
        # mpos : position of minimum in L[i:]
        for j in range(i + 1, n):
            if L[j] < L[mpos]:
                mpos = j
            
        # L[mpos] : smallest value in L[i:]
        # Exchange L[mpos] and L[i]
        (L[i], L[mpos]) = (L[mpos], L[i])
        
        # Now L[:i+1] is sorted
    return (L)
## Time Complexity: O(n^2)

##Insertion Sort
def Insertion_Sort(L):
    n = len(L)
    if n <= 1:
        return L
    for i in range(n):
        # Assume L[:i] is sorted
        # Move L[i] to correct position in L
        j = i
        while(j > 0 and L[j] < L[j - 1]):
            (L[j], L[j - 1]) = (L[j - 1], L[j])
            j = j - 1
        # Now L[:i + 1] is sorted
    return (L)
## Time Complexity: O(n^2)

# New list created in recursive insertion sort
## Recursive Insertion Sort
def Insert(L, v):
    n = len(L)
    if n == 0:
        return [v]
    if v >= L[-1]:
        return (L + [v])
    else:
        return Insert(L[:-1], v) + L[-1:]

def ISort(L):
    n = len(L)
    if n <= 1:
        return (L)
    L = Insert(ISort(L[:-1]), L[-1])
    return (L)
## Time Complexity: O(n^2)

## Merge Sort
def Merge(A, B):
    (m, n) = (len(A), len(B))
    (C, i, j, k) = ([], 0, 0, 0)
    while k < m + n:
        if i == m:
            C.extend(B[j:])
            break
        elif j == n:
            C.extend(A[i:])
            break
        elif A[i] < B[j]:
            C.append(A[i])
            (i, k) = (i + 1, k + 1)
        else: 
            C.append(B[j])
            (j, k) = (j + 1, k + 1)
    return (C)

def Merge_Sort(L):
    n = len(L)
    
    if n <= 1:
        return (L)
    
    mid = n // 2
    L1 = Merge_Sort(L[:mid])
    L2 = Merge_Sort(L[mid:])
    sorted_L = Merge(L1, L2)
    
    return sorted_L
## Time Complexity: O(nlog(n))

## Quick Sort
def Quick_Sort(L, l, r):
    if (r - l <= 1):
        return L
    
    (pivot, lower, upper) = (L[l], l + 1, l + 1)
    for i in range(l + 1, r):
        if L[i] > pivot:
            upper += 1
        else: 
            (L[i], L[lower]) = (L[lower], L[i])
            (lower, upper) = (lower + 1, upper + 1)
    
    (L[l], L[lower - 1]) = (L[lower - 1], L[l])
    lower -= 1
    
    Quick_Sort(L, l, lower)
    Quick_Sort(L, lower + 1, upper)
    return L

L = [1, 2, 8, 9, 0, 3]

# print(Selection_Sort(L))
# print(Insertion_Sort(L))  
# print(ISort(L))  
# print(Merge_Sort([1, 2, 0, 8, -1, 9]))
# print(Bubble_Sort(L))
# print(Quick_Sort(L, 0, len(L)))