#include<stdio.h>
#include<stdlib.h>
#define max 10
int main()
{
	int  num,maxnum=1;//�������
	printf("������������:");
	scanf("%d", &num);
	int arr[max][2];//arr[n][0]��ʾ���鿪ʼ��ʱ�䣬arr[n][1]��ʾ���������ʱ��
	for (int i = 0; i < num; i++)//��ȡʱ��
	{
		printf("�������%d�������ʱ�䰲�ţ�", i);
		scanf("%d%d", &arr[i][0], &arr[i][1]);
	}
	for (int i = 0; i < num; i++)//���ս���ʱ������
	{
		for (int j = i + 1; j < num; j++)
		{
			if (arr[i][1] > arr[j][1])
			{
				int temp = arr[j][1];//��������ʱ��
				arr[j][1] = arr[i][1];
				arr[i][1] = temp;

				int Temp = arr[j][0];//������ʼʱ��
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
	printf("���ŵĻ�����:%d", begin);
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