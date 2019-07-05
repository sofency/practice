#include<stdio.h>
#include <stdlib.h>
#include<string.h>
char str[100] = {0};
typedef struct node
{
	int data[100];
	int top;
}SqStack;//顺序栈
void init(SqStack *&L)//之所以加&符号是因为将操作的对象指向L而不是在内存中重新申请内存
{
	L = (SqStack*)malloc(sizeof(SqStack));
	L->top = 0;
	L->data[100] = { 0 };
}
void push(SqStack *&L, int data)//入栈操作
{	
	L->data[L->top] = data;
	L->top++;
}
int pop(SqStack *&L)//出栈
{
	L->top--;
	int data = L->data[L->top];
	return data;
}
int getnum(int &i, bool minus)//得到栈顶元素//加引用的目的就是让i随着函数的运行而变化
{
	int temp = 0;
	while (str[i] >= '0'&&str[i] <= '9')
	{
		temp = temp * 10 + str[i] - '0';//经典的算法
		i++;
	}
	if (minus)
		return temp;
	else
		return -temp;
}
int f(int x, int y, int a, int b)//二元函数的计算
{
    return a * x + b * y;
}
int main()
{
	int i = 0;
	int a, b;
	scanf("%d%d", &a, &b);//获取系数
	SqStack *L;
	init(L);
	scanf("%s", str);//获取字符串
	int temp=0;
	int flag = 1;
	
	for (;i <= strlen(str);i++)
	{
		if (str[i] == '-')
		{
			i++;//取出下一位进而判断到不为数字为止
			push(L,getnum(i, false));//入栈
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