class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        common_prefix = strs[0]

        for i in range(len(common_prefix), 0, -1):
            prefix = common_prefix[:i]

            found = True

            for word in strs:
                if not word.startswith(prefix):
                    found = False
                    break

            if found:
                return prefix

        return ""

                    

                    

        