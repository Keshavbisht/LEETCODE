class Solution:
    def reverseWords(self, s: str) -> str:
        l1 = s.split()
        print(l1)
        l1.reverse()
        ans = " ".join(l1)
        return ans