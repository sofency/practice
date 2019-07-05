#include<stdio.h>
#include <stdlib.h>
#include<string.h>
#define EleType char
#define max 100
typedef struct node
{
	EleType ch;
	struct node*next;
}Brack;//����
void init(Brack *&L)//��ʼ��ջ
{
	L = (Brack*)malloc(sizeof(Brack));
	L->next = NULL;
}
bool StackEmpty(Brack *L)
{
	return (L->next == NULL) ? 1 : 0;
}
void DestoryStack(Brack *L)
{
	Brack *p = L, *q = L->next;
	while (q != NULL)
	{
		free(p);
		p = q;
		q = p->next;
	}
	free(p);
}
void push(Brack *L,char ch)//��ջ
{
	Brack *temp = (Brack*)malloc(sizeof(Brack));
	temp->ch = ch;
	temp->next = NULL;
	L->next = temp;
}
void pop(Brack *L,char ch)
{
	if (L->next == NULL)
	{
		return ;
	}
	Brack *p = L->next;
	ch = p->ch;
	L->next = p->next;
	free(p);
}
bool GetTop(Brack *L, char &ch)
{
	if (L->next == NULL)
		return false;
	ch = L->next->ch;
	return true;
}
bool Match(char exp[], int n)
{
	int i = 0;char e;
	bool match = true;
	Brack *L;
	init(L);
	while (i < n&&match)
	{
		if (exp[i] == '(')
			push(L, exp[i]);
		else if(exp[i]==')')
		{
			if (GetTop(L, e) == true)
			{
				if (e != '(')
				{
					match = false;
				}
				else
					pop(L, e);
			}
			else
				match = false;
		}	
		i++;
	}
	if (!StackEmpty(L))
	{
		match = false;
	}
	DestoryStack(L);
	return match;	
}
int main()
{
	char exp[max] = { "()()(((" };
	if (Match(exp, strlen(exp)))
	{
		printf("ƥ��\n");
	}
	else
	{
		printf("��ƥ��\n");
	}
	system("pause");
	return 0;
}