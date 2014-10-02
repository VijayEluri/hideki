import math

# Definition for a  binary tree node
class TreeNode:
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def maxDepth(self, root):
        if root == None:
            return 0
        return self._maxDepth(root, 1)

    def _maxDepth(self, node, depth):
        if node == None:
            return depth
            
        left = depth
        right = depth
        if node.left != None:
            left = self._maxDepth(node.left, depth+1)
        if node.right != None:
            right = self._maxDepth(node.right, depth+1)
        return max(left, right)


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right.right = TreeNode(4)
    solution = Solution()
    print(solution.maxDepth(root)) ## 3
    