from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        l, r = 0, n - 1
        
        # 1. Find the Point of Inflection (Smallest Element)
        # This is the standard, crash-proof way to find the minimum index
        while l < r:
            mid = (l + r) // 2
            if nums[mid] > nums[r]:
                l = mid + 1
            else:
                r = mid
        
        poi = l  # This is the index of the smallest element

        # 2. Helper: Standard Binary Search
        def binSearch(l, r):
            if l > r:
                return -1
            mid = (l + r) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                return binSearch(l, mid - 1)
            else:
                return binSearch(mid + 1, r)

        # 3. Decide which side to search
        # If POI is 0, the array wasn't rotated (or was rotated n times)
        if poi == 0:
            return binSearch(0, n - 1)
        
        # If target is in the left sorted portion:
        # (Must be >= first element AND <= the element right before the drop)
        if target >= nums[0] and target <= nums[poi - 1]:
            return binSearch(0, poi - 1)
        
        # Otherwise, it must be in the right sorted portion:
        else:
            return binSearch(poi, n - 1)