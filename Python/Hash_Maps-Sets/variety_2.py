def main():
    t = int(input())
    output = []
    
    for _ in range(t):
        n = int(input())
        arr = list(map(int, input().split()))
        
        # Edge cases
        if n == 1:
            output.append("1 1")
            continue
        if all(x == arr[0] for x in arr):  # If all elements are the same
            output.append("0")
            continue

        # Step 1: Compute first and last occurrence of each element
        first_occ = {}
        last_occ = {}
        for i, x in enumerate(arr, start=1):  # 1-based index
            if x not in first_occ:
                first_occ[x] = i
            last_occ[x] = i

        # Step 2: Iterate over all right boundaries `r`
        max_score = -float("inf")
        best_l, best_r = None, None
        unique_elements = set()
        freq = {}
        l = 1  # Pointer for left boundary
        
        for r in range(1, n + 1):
            x = arr[r - 1]  # Get the current element (1-based index)
            unique_elements.add(x)
            freq[x] = freq.get(x, 0) + 1
            
            # Step 3: Compute the number of completely removed elements
            while l <= r and freq[arr[l - 1]] > 1:
                freq[arr[l - 1]] -= 1
                if freq[arr[l - 1]] == 0:
                    unique_elements.remove(arr[l - 1])
                l += 1
            removed_unique_count = len(unique_elements)
            
            # Step 4: Compute the score
            removed_length = r - l + 1
            score = removed_unique_count - removed_length
            
            # Step 5: Update the best result
            if score > max_score or (score == max_score and removed_length > (best_r - best_l + 1 if best_l is not None else 0)):
                max_score = score
                best_l, best_r = l, r
        
        # Step 6: Output the best result
        if max_score <= 0:
            output.append("0")
        else:
            output.append(f"{best_l} {best_r}")
    
    print("\n".join(output))

if __name__ == "__main__":
    main()