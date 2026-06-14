func findDuplicate(nums []int) int {
    size:=len(nums)
    for i:=0; i<size; i++ {
        if nums[abs(nums[i])-1]<0 {
            return abs(nums[i])
        }
        nums[abs(nums[i])-1]=-1*nums[abs(nums[i])-1]
    }
    return abs(nums[size-1])
}

func abs (x int) int {
    if x<0 {
        return -1*x
    } else {
        return x
    }
}