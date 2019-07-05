#include <stdio.h>
#include <math.h>
#include<stdlib.h>
void power(int n);
int main()
{
	int n;
	scanf("%d", &n);
	power(n);
	system("pause");
	return 0;
}
void power(int n) {
	int x = 2, y, surplus;
	y = log(n) / log(2);//记录2的最高次幂
	if (y > 2) {
		printf("2(");
		power(y);
		printf(")");
	}
	else if (y == 1) {
		printf("2");
	}
	else {
		printf("2(%d)", y);
	}
	surplus = n - pow(2, y);//是因为并不是所有的数都能用2的幂表示，所以减去能表示的
	if (surplus > 0) {
		printf("+");
		power(surplus);
	}
}
