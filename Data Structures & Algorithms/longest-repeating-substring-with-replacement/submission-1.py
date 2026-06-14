class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        size = len(s)
        maxl = 0
        hashmap = {}
        l=0
        maxf = 0
        for r in range(len(s)):
            hashmap[s[r]]=1+hashmap.get(s[r],0)
            maxf = max(maxf, hashmap[s[r]])

            if r-l+1-maxf<=k:
                maxl = max(maxl, r-l+1)
                continue
            while r-l+1-maxf>k:
                hashmap[s[l]]-=1
                l+=1

            maxl=max(maxl, r-l+1)
        return maxl

