#include<stdio.h>
#include<stdlib.h>
int array[6][7] = { 
{16,4,3,12,6,0,3},
{4,-5,6,7,0,0,2},
{6,0,-1,-2,3,6},
{5,3,4,0,0,-2,7},
{-1,7,4,0,7,-5,6},
{0,-1,3,4,12,4,2} };
int decide(int i, int j);
int main()
{
	for (int i = 4; i >= 0; i--)
	{
		for (int j = 0; j < 7; j++)
		{
			array[i][j] = decide(i, j);
		}
	}
	int max = array[0][0];
	for (int i = 1; i < 7; i++)
	{
		if (max < array[0][i])
		{
			max = array[0][i];
		}
	}
	printf("%d\n", max);
	system("pause");
	return 0;
}
int decide(int i, int j)//找出最大值然后赋值给上一行，i和j表示下标
{
	int max = 0;//假设没有比0更小的数字了
	for (int k = -2; k <= 2; k++)
	{
		int a=0;
		if (j + k >= 0 && j + k <= 6)
		{
			a = array[i][j] + array[i+1][j + k];
			if (a > max)
			{
				max = a;
			}
		}
	}
	return max;
}