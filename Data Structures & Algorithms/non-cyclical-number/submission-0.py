class Solution:
    def isHappy(self, n: int) -> bool:
        hashset = set()

        while n not in hashset:
            hashset.add(n)
            n=self.calculate(n)
            if(n==1):
                return True
        return False



    def calculate(self, n: int)->int:
        output=0
        while n:
            digit=n%10
            digit=digit**2
            output+=digit
            n=n//10

        return output