class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        lens = len(s)
        lent = len(t)
        hashMapS = {}
        hashMapT = {}
        if lens!=lent:
            return False
        for i in range(lens):
            if s[i] in hashMapS:
                hashMapS[s[i]] +=1
            else:
                hashMapS[s[i]] = 1
            if t[i] in hashMapT:
                hashMapT[t[i]] +=1
            else:
                hashMapT[t[i]] = 1

        for key in hashMapS:
            if key not in hashMapT or hashMapS[key]!=hashMapT[key]:
                return False
        return True
            