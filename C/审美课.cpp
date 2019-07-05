#include<stdio.h>
int main()
{
	int ans[2000000] = { 0 };//VS 中无法承受如此巨大的数组
	int A[50005] = { 0 };
	int student, picture, i, j, sum = 0;
	scanf("%d%d", &student, &picture);
	for (i = 0; i < student; i++)
	{
		for (j = 0; j < picture; j++)
		{
			int temp;
			scanf("%d", &temp);
			A[i] = (A[i] << 1) + temp;//转化为二进制保存
		}
		ans[A[i]]++;//记录每个结果的个数
	}
	int max = (1 << picture) - 1;//转化为 20个1
	for (i = 0; i < student; i++)
	{
		int temp = A[i] ^ max;//异或操作找到与A[i]不同的序列
		sum += ans[temp];//记录每一个人中有多少评价不同的个数
	}
	printf("%d", sum/2);//因为多记录的一半
	return 0;
}
