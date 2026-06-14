from collections import deque

class Solution:
    def isValid(self, s: str) -> bool:
        stack = deque()
        for c in range(len(s)):
            if s[c]=='(' or s[c]=='{' or s[c]=='[':
                stack.append(s[c])
            else:
                if len(stack)==0:
                    return False
                temp = stack.pop()
                match s[c]:
                    case ')':
                        if temp!='(':
                            return False
                    case '}':
                        if temp!='{':
                            return False
                    case ']':
                        if temp!='[':
                            return False


        if len(stack) != 0:
            return False

        return True

        