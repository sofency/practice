#include<stdio.h>
#include <stdlib.h>
#include<string.h>
char str[100] = {0};
typedef struct node
{
	int data[100];
	int top;
}SqStack;//˳��ջ
void init(SqStack *&L)//֮���Լ�&��������Ϊ�������Ķ���ָ��L���������ڴ������������ڴ�
{
	L = (SqStack*)malloc(sizeof(SqStack));
	L->top = 0;
	L->data[100] = { 0 };
}
void push(SqStack *&L, int data)//��ջ����
{	
	L->data[L->top] = data;
	L->top++;
}
int pop(SqStack *&L)//��ջ
{
	L->top--;
	int data = L->data[L->top];
	return data;
}
int getnum(int &i, bool minus)//�õ�ջ��Ԫ��//�����õ�Ŀ�ľ�����i���ź��������ж��仯
{
	int temp = 0;
	while (str[i] >= '0'&&str[i] <= '9')
	{
		temp = temp * 10 + str[i] - '0';//������㷨
		i++;
	}
	if (minus)
		return temp;
	else
		return -temp;
}
int f(int x, int y, int a, int b)//��Ԫ�����ļ���
{
    return a * x + b * y;
}
int main()
{
	int i = 0;
	int a, b;
	scanf("%d%d", &a, &b);//��ȡϵ��
	SqStack *L;
	init(L);
	scanf("%s", str);//��ȡ�ַ���
	int temp=0;
	int flag = 1;
	
	for (;i <= strlen(str);i++)
	{
		if (str[i] == '-')
		{
			i++;//ȡ����һλ�����жϵ���Ϊ����Ϊֹ
			push(L,getnum(i, false));//��ջ
		}
		else if (str[i] >= '0'&&str[i] <= '9')
		{
			push(L, getnum(i, true));
		}
		if (str[i] == ')')
		{
			int y = pop(L);
			int x = pop(L);
			push(L, f(x, y, a, b));
			i++;
		}
	}
	printf("%d", L->data[L -> top-1]);
	system("pause");
	return 0;
}