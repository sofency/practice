#include"sum.h"
extern int sum(int*, int, int);
int main()
{
	int arr[100] = { 0 };
	int count = 0;
	int n;
	scanf("%d", &n);//数组的大小
	for (int i = 0; i < n; i++)
	{
		scanf("%d", &arr[i]);
	}
	int sum1 = sum(arr, 0, n);
	printf("%d\n", sum1);
	system("pause");
	return 0;
}