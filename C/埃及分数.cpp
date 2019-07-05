#include<stdio.h>
#include<stdlib.h>
int gcd(int a, int b)
{
	int mode = a % b;//a>b
	while (mode != 0)
	{
		a = b;
		b = mode;
		mode = a % b;
	}
	return b;
}
int main()
{
	int fenzi, fenmu;
	printf("请输入真分数:");
	scanf("%d%d", &fenzi, &fenmu);//获取分子，分母
	int C = fenmu % fenzi+1;
	while (fenzi != 1)
	{
		printf("1/%d+", C);
		fenzi = fenzi * C - fenmu;
		fenmu = fenmu * C;
		int a = gcd(fenmu, fenzi);
		fenzi = fenzi / a;
		fenmu = fenmu / a;
		C = fenmu % fenzi+1;
	}
	printf("1/%d", fenmu);
	system("pause");
	return 0;
}