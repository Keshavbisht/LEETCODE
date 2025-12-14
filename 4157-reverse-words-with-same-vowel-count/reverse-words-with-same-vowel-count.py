class Solution:
    def reverseWords(self, s: str) -> str:
        count = 0;
        l1 = s.split();
        str1 = l1[0];
        l2 = ['a','e','i','o','u']
        for i in range(0, len(l1[0]), 1):
            if(str1[i] in l2):
                count = count +1
        for i in range(1, len(l1),1):
            str2 = l1[i];
            temp = 0;
            for j in range(0, len(str2), 1):
                if(str2[j] in l2):
                    temp = temp +1
            if(temp == count):
                l1[i] = l1[i][::-1]
        return " ".join(l1);