#include<stdio.h>
#include<stdlib.h>
int map[6][7] = { 
	{16,4,3,12,6,0,3},
    {4,-5,6,7,0,0,2},
    {6,0,-1,-2,3,6,8},
	{5,3,4,0,0,-2,7},
	{11,7,4,0,7,-5,6},
	{0,-1,3,4,12,4,2}
};//·������
//�涨�����һ�е�4��ʼ�������ߣ��ų������������������
int main()
{
	for (int i = 1; i < 6; i++)//��������е�����
	{
		map[4][i] += map[5][3];
	}
	map[4][0] = map[4][6] = -1000;//��Ϊ���������ݲ��ᱻ����
	for (int i = 3; i >= 0; i--)
	{
		for (int j = 0; j < 7; j++)
		{
			int max = -1000;
			for (int k = -2; k <= 2; k++)
			{
				if (j + k >= 0 && j + k <= 6)
				{
					if (max < map[i][j] + map[i + 1][j + k])
					{
						max = map[i][j] + map[i + 1][j + k];
					}
				}
			}
			map[i][j] = max;//�����ֵ����map[i][j]
		}
	}
	int a = map[0][0];
	for (int i = 1; i < 7; i++)
	{
		if (map[0][i] > a)
		{
			a = map[0][i];
		}
	}
	printf("���·����%d", a);
	system("pause");
	return 0;
}