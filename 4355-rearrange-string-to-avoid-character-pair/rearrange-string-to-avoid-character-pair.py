class Solution:
    def rearrangeString(self, s: str, x: str, y: str) -> str:
        # ans = False
        # n = len(s)
        # i =-1
        # while(True):
        #     i = i+1
        #     curr = list(s)
        #     # print(i)
        #     last = curr[0]
        #     curr.pop(0)
        #     curr.append(last)
        #     s = "".join(curr)
        #     # print(curr)
        #     flag = False
        #     for j in range(0, n, 1):
        #         if(flag == True and s[j] == y):
        #             break
        #         if(s[j] == x):
        #             flag = True
        #         if(j == n-1):
        #             ans = True
        #     if(ans == True):
        #         return s
        # return s
        curr = list(s)
        # print(curr)
        co = curr.count(y)
        # print(co)
        new = []
        n = len(s)
        for i in range(0, co, 1):
            new.append(y)
        for i in range(0, n,1):
            if(curr[i] == y):
               continue
            new.append(curr[i])
        
        
        return "".join(new)

                
            