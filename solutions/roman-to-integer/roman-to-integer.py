class Solution:
    def romanToInt(self, s: str) -> int:
        total = 0
        for i in range(0, len(s)):
            if s[i] == "M":
                if s[i-1] == "C" and i > 0 :
                    total += 800
                else :
                    total += 1000
            if s[i] == "D":
                if s[i-1] == "C" and i > 0 :
                    total += 300
                else :
                    total += 500
            if s[i] == "C":
                if s[i-1] == "X" and i > 0:
                    total += 80
                else :
                    total += 100
            if s[i] == "L":
                if s[i-1] == "X" and i > 0:
                    total += 30
                else :
                    total += 50
            if s[i] == "X":
                if s[i-1] == "I" and i > 0:
                    total += 8
                else :
                    total += 10
            if s[i] == "V":
                if s[i-1] == "I" and i > 0:
                    total += 3
                else :
                    total += 5
            if s[i] == "I":
                total += 1
        return total

            