#include<stdio.h>
#include<stdlib.h>
#define max 10
int main()
{
	int  num,maxnum=1;//会议个数
	printf("请输入会议个数:");
	scanf("%d", &num);
	int arr[max][2];//arr[n][0]表示会议开始的时间，arr[n][1]表示会议结束的时间
	for (int i = 0; i < num; i++)//获取时间
	{
		printf("请输入第%d个会议的时间安排：", i);
		scanf("%d%d", &arr[i][0], &arr[i][1]);
	}
	for (int i = 0; i < num; i++)//按照结束时间排序
	{
		for (int j = i + 1; j < num; j++)
		{
			if (arr[i][1] > arr[j][1])
			{
				int temp = arr[j][1];//交换结束时间
				arr[j][1] = arr[i][1];
				arr[i][1] = temp;

				int Temp = arr[j][0];//交换起始时间
				arr[j][0] = arr[i][0];
				arr[i][0] = Temp;
			}
		}
	}
	/*for (int i = 0; i < num; i++)
	{
		printf("%d  %d\n", arr[i][0], arr[i][1]);
	}*/
	int begin = 0;
	printf("安排的会议是:%d", begin);
	for (int i = 0; i < num-1; i++)
	{
		if (arr[begin][1] < arr[i + 1][0])
		{
			begin = i + 1;
			printf("  %d", begin);
			maxnum++;
		}
	}
	printf("\n%d", maxnum);
	system("pause");
	return 0;
}