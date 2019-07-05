#include <stdio.h>
#include <stdlib.h>
#define NULLKEY '?'
typedef struct btnode
{
	char data;
	struct btnode *lchild, *rchild;
}btnode, *bitree;
//创建一个二叉树
bitree preCreateBitree(bitree &root)
{
	char ch;
	scanf("%c", &ch);//输入二叉树的权值
	if (ch == NULLKEY)
	{
		root = NULL;
		return(root);
	}
	else
	{
		root = (bitree)malloc(sizeof(btnode));
		root->data = ch;
		preCreateBitree(root->lchild);
		preCreateBitree(root->rchild);
		return(root);
	}
}

void fsearch(bitree root)//先序遍历
{
	if (root == NULL)
		return;
	else
	{
		printf("%c", root->data); //先序遍历每个结点的值
		fsearch(root->lchild);
		fsearch(root->rchild);
	}
}

void msearch(bitree root)//中序遍历
{
	if (root == NULL)
		return;
	else
	{
		msearch(root->lchild);
		printf("%c", root->data); //中序遍历每个结点的值
		msearch(root->rchild);
	}
}

int main()
{
	bitree root;
	root = preCreateBitree(root);
	printf("first:");
	fsearch(root);
	printf("\n");
	printf("middle:");
	msearch(root);
	printf("\n");

	system("pause");
	return 0;
}
