#include<stdio.h>
#include<stdlib.h>
int gcd(int data1, int data2)
{
	int temp;
	int max = data1 > data2 ? data1 : data2;
	int min = data1 < data2 ? data1 : data2;
	temp = max % min;
	while (temp != 0)
	{
		max = min;
		min = temp;
		temp = max % min;
	}
	return min;
}
int main()
{
	int x1, y1, x2, y2,gcd1,gcd2;
	scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
	gcd1 = gcd(x1, y1);
	gcd2 = gcd(x2, y2);
	if (gcd1 != 0 && gcd2 != 0)
	{
		x1 = x1 / gcd1, y1 = y1 / gcd1;
		x2 = x2 / gcd2, y2 = y2 / gcd2;
	}
	printf("zrf is:%d/%d;ssh is:%d/%d\n", x1, y1, x2, y2);
	printf("zrf==ssh is:%d; (zrf<ssh) is:%d", (x1 == x2 && y1 == y2) ? 1 : 0, ((double)x1/y1<(double)x2/y2) ? 1 : 0);
	system("pause");
	return 0;
}