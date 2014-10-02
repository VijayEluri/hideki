class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        ret = 0
        for v in A:
            ret ^= v
        return ret


if __name__ == '__main__':
    sol = Solution()
    print(sol.singleNumber([10, 11, 10, 22, 22]))