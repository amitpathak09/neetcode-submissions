class Solution:
    def countSubstrings(self, s: str) -> int:

        #odd size palidromes
        palindromes = 0
        for i in range(len(s)):
            l,r=i,i
            while(l>=0 and r<len(s) and s[l]==s[r]):
                palindromes+=1
                l-=1
                r+=1

        #even size palindromes
        for j in range(len(s)-1):
            l,r=j,j+1
            while(l>=0 and r<len(s) and s[l]==s[r]):
                palindromes+=1
                l-=1
                r+=1
        return palindromes