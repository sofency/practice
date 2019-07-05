#include<stdio.h>
#include<cstdlib>
int main()
{
	int arr[3][6] = { {0,3,7,9,12,13},{0,5,10,11,11,11},{0,4,6,11,12,12} };
	int max = 0;
	for (int i = 0; i < 5; i++)
	{
		for (int j = 0; j < 5 - i; j++)
		{
			int a= arr[0][i] + arr[1][j] + arr[2][5 - i - j];
			if (a > max)
			{
				max = a;
			}
		}
	}
	printf("%d\n", max);


	system("pause");
	return 0;
}