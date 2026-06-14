class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        charCounter = [0]*26

        for i in range(len(s)):
            charCounter[ord(s[i])-ord('a')]+=1
            charCounter[ord(t[i])-ord('a')]-=1
        for j in charCounter:
            if j!=0:
                return False
        return True