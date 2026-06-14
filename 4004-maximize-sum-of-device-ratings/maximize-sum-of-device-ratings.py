class Solution:
    def maxRatings(self, units: List[List[int]]) -> int:
        pnt1 = -1
        mini = float(inf)

        mini2 = float(inf)
        pnt2 = -1

        ind = -1

        for i in units:
            ind+=1
            sum1 = 0
            i.sort()
            
            if(len(i) == 1):
                sum1 += i[0]
            else:
                sum1 = i[0] + i[1]
            if mini ==sum1 and len(units[pnt1]) > 1 and len(i) > 1:

                if(units[pnt1][1] > i[1]):
                    pnt2 = pnt1
                    pnt1 = ind
                    mini2 = mini



            elif(mini > sum1):

                pnt2 = pnt1
                mini2 = mini

                pnt1 = ind
                mini = sum1
            
        # print(units)
        # print(units[pnt1])
        
        if(len(units[pnt1]) >1 and len(units[pnt2]) >1):
            if(units[pnt1][1] > units[pnt2][1]):
                pnt1 = pnt2
        last = units[pnt1]
        units.pop(pnt1)
        ans = 0
        for i in units:
            if(len(i) > 1):
                last.append(i.pop(0))
            ans += i[0]
        ans += min(last)
        return ans

        

                
        
            

        