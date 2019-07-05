#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct
{
	double data;
	double fudata;
}*Node;
int main()
{
	Node arr[2];
	double temp0, temp1;
	int i;
	for (i = 0; i < 2; i++)
	{
		arr[i] = (Node)malloc(sizeof(Node));
	}
	char ch;
	scanf("%c", &ch);
	getchar();
	for (i = 0; i < 2; i++)
	{
		scanf("%lf%lf", &arr[i]->data, &arr[i]->fudata);
	}
	switch (ch)
	{
	case '+':
		arr[0]->data = arr[0]->data + arr[1]->data;
		arr[0]->fudata = arr[0]->fudata + arr[1]->fudata;
		printf("%.2f+%.2fi", arr[0]->data, arr[0]->fudata);
		break;
	case '-':
		arr[0]->data = arr[0]->data - arr[1]->data;
		arr[0]->fudata = arr[0]->fudata - arr[1]->fudata;
		printf("%.2f+%.2fi", arr[0]->data, arr[0]->fudata);
		break;
	case '*':
		 temp0 = arr[0]->data * arr[1]->data-arr[0]->fudata*arr[1]->fudata;//¸´Êý*¸´Êý±äºÅ
		 temp1 = arr[0]->data * arr[1]->fudata+ arr[0]->fudata * arr[1]->data;
		printf("%.2f+%.2fi", temp0, temp1);
		break;
	case '/':
		 temp0 = arr[0]->data * arr[1]->data- arr[0]->fudata*(0-arr[1]->fudata);
		 temp1 = arr[0]->fudata * arr[1]->data+ arr[0]->data * (0-arr[1]->fudata);
		double x = arr[1]->data*arr[1]->data + arr[1]->fudata*arr[1]->fudata;
		printf("%.2f+%.2fi", temp0/x, temp1/x);
		break;
	}
	system("pause");
	return 0;
}