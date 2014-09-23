
/**
 * find the depth of binary tree / maximum path in tree
 */

#include <stdio.h>

#define max( a, b ) ( ((a) > (b)) ? (a) : (b) )

typedef struct _Node {
    struct _Node* left;
    struct _Node* right;
} Node;


int 
maxHightOfBinaryTree(Node* node){
    if(node == NULL)
        return 0;
    int leftHeight = 0;
    int rightHeight = 0;
    if(node->left != NULL)
        leftHeight = maxHightOfBinaryTree(node->left);
    if(node->right != NULL)
        rightHeight = maxHightOfBinaryTree(node->right);
    
    return max(leftHeight, rightHeight) + 1;
}
int 
main(int argc, char** argv){
    Node root;
    Node left;
    root.left = &left;
    printf("height => %d\n", maxHightOfBinaryTree(&root));
    printf("height => %d\n", maxHightOfBinaryTree(&left));
    printf("height => %d\n", maxHightOfBinaryTree(NULL));
}