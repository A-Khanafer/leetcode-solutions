class Solution:
    def isPalindrome(self, x: int) -> bool:
        word = str(x)
        return word == word[::-1]
