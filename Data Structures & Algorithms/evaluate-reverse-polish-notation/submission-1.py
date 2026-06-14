class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for i in range(len(tokens)):
            c = tokens[i]
            if c not in "+-*/":
                stack.append(c)
            else:
                r=int(stack.pop())
                l=int(stack.pop())
                if c=='+':
                    stack.append(l+r)
                elif c=='-':
                    stack.append(l-r)
                elif c=='*':
                    stack.append(l*r)
                else:
                    stack.append(int(l/r))
        return int(stack.pop())