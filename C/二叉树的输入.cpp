#include <stdio.h>
#include <stdlib.h>
#define NULLKEY '?'
typedef struct btnode
{
	char data;
	struct btnode *lchild, *rchild;
}btnode, *bitree;
//����һ��������
bitree preCreateBitree(bitree &root)
{
	char ch;
	scanf("%c", &ch);//�����������Ȩֵ
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

void fsearch(bitree root)//�������
{
	if (root == NULL)
		return;
	else
	{
		printf("%c", root->data); //�������ÿ������ֵ
		fsearch(root->lchild);
		fsearch(root->rchild);
	}
}

void msearch(bitree root)//�������
{
	if (root == NULL)
		return;
	else
	{
		msearch(root->lchild);
		printf("%c", root->data); //�������ÿ������ֵ
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
