/**
 * reverse.c
 *
 * Question: Write a C function that reverses a singly-linked list.
 */

#include <stdio.h>
#include <string.h>

struct Node {
	struct Node *next;
	char val;
};

Node* last(Node* node){
	for( ;node->next != NULL; node = node->next);
	return node;
}

void create(Node** root, char val){
	Node* new_node = new Node();
	new_node->val = val;
	new_node->next = NULL;

	if(*root == NULL){
		*root = new_node;
	}else{
		Node* node = last(*root);
		node->next = new_node;
	}
}

Node* reverse(Node* prev, Node* node){
	//end
	if(node == NULL){
		return prev;
	}
	Node* last = reverse(node, node->next);
	node->next = prev;
	prev->next = NULL;
	return last;
}

void print(Node* node){
	for(; node!=NULL;node=node->next){
		printf("%c\n", node->val);
	}
}

int
main(int argc, char* argv[])
{
	if(argc != 2){
		fprintf(stderr, "USAGE: %s text\n", argv[0]);
		return -1;
	}

	Node* root = NULL;

	int i;
	for(i = 0; i < strlen(argv[1]); i++){
		char c = argv[1][i];
		create(&root, c);
	}
	root = reverse(root, root->next);
	print(root);
	return 0;
}
