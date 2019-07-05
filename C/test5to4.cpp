#include<stdio.h>
#define max 5
#include<stdlib.h>
int panduanTwo(int num1, int num2)
{
	int i = 0, j = 0, cnti = 0, cntj = 0;
	int arr1[max] = { 0 };
	int arr2[max] = { 0 };
	while (num1 != 0)
	{
		arr1[cnti++] = num1 % 10;
		num1 = num1 / 10;
	}
	while (num2 != 0)
	{
		arr2[cntj++] = num2 % 10;
		num2 = num2 / 10;
	}
	for (i = 0; i < cnti; i++)
	{
		for (j = 0; j < cntj; j++)
		{
			if (arr1[i] == arr2[j])
			{
				return 0;
			}
		}
	}
	return 1;
}
int panduan(int num1)
{
	int cnti = 0;
	int arr1[max] = { 0 };
	while (num1 != 0)
	{
		arr1[cnti++] = num1 % 10;
		num1 = num1 / 10;
	}
	for (int i = 0; i < cnti; i++)
	{
		for (int j = 0; j < cnti; j++)
		{
			if (i != j && arr1[i] == arr1[j])
			{
				return 0;
			}
		}
	}
	return 1;
}
int main()
{
	for (int i = 5000; i < 9999; i++)
	{
		if (panduan(i) && panduan(i * 2))
		{
			if (panduanTwo(i, i * 2))
			{
				printf("%d %d\n", i, i * 2);
			}
		}
	}
	system("pause");
	return 0;
}
