#include <stdio.h>
#include <stdlib.h>

#define OK     10000001
#define ERROR  10000002

struct node
{
	int data;
	struct node *next;
};
typedef struct node Node;

struct stack
{
	Node *top;
	int count;
};
typedef struct stack Stack;

int InitStack(Stack *l)
{
	l->top = NULL;
	l->count = 0;

	return OK;
}

int EmptyStack(Stack *s)
{
	return (s->count == 0) ? OK : ERROR;
}

int Push(Stack *s, int e)
{
	Node *p = (Node *)malloc(sizeof(Node));
	if (p == NULL)
	{
		return ERROR;
	}
	p->data = e;
	p->next = s->top;
	s->top = p;
	s->count++;//��¼ջ�ĳ���

	return OK;
}

int GetTop(Stack *s)
{
	if (NULL == s->top)
	{
		return ERROR;
	}

	return (s->top->data);
}

int Priority(char s)
{
	switch (s)
	{
	case '(':
		return 3;
	case '*':
	case '/':
		return 2;
	case '+':
	case '-':
		return 1;
	default:
		return 0;
	}
}

int Pop(Stack *s)
{
	int e;

	if (NULL == s->top)
	{
		return ERROR;
	}

	Node *p = s->top;
	e = p->data;
	s->top = p->next;
	free(p);
	s->count--;

	return e;
}

int main()
{
	Stack num, opt;
	char str[100] = { 0 };
	int i = 0, tmp = 0, j;

	if (InitStack(&num) != OK || InitStack(&opt) != OK)
	{
		printf("Init Failure!\n");
		exit(1);
	}

	printf("Please Input Operator :\n");
	scanf("%s", str);

	while (str[i] != '\0' || EmptyStack(&opt) != OK)
	{
		if (str[i] >= '0' && str[i] <= '9')
		{
			tmp = tmp * 10 + str[i] - '0';
			i++;
			if (str[i] < '0' || str[i] > '9')
			{
				Push(&num, tmp);
				tmp = 0;
			}
		}
		else
		{
			if ((EmptyStack(&opt) == OK) || (GetTop(&opt) == '(' && str[i] != ')') || Priority(str[i]) > Priority(GetTop(&opt)))//��ջ����������
			{
				Push(&opt, str[i]);
				i++;
				continue;
			}
			if (GetTop(&opt) == '(' && str[i] == ')')//��ջ����������
			{
				Pop(&opt);
				i++;
				continue;
			}
			if ((str[i] == '\0' && EmptyStack(&opt) != OK) || (str[i] == ')' && GetTop(&opt) != '(') || Priority(str[i]) <= Priority(GetTop(&opt)))//��ջ����������
			{
				switch (Pop(&opt))
				{
				case '+':
					Push(&num, Pop(&num) + Pop(&num));
					break;
				case '-':
					j = Pop(&num);
					Push(&num, Pop(&num) - j);
					break;
				case '*':
					Push(&num, Pop(&num) * Pop(&num));
					break;
				case '/':
					j = Pop(&num);
					Push(&num, Pop(&num) / j);
				}
				continue;
			}
		}
	}

	printf("%d", Pop(&num));
	printf("\n");
	system("pause");
	return 0;
}