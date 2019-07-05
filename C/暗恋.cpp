/*
问题描述
　　同在一个高中，他却不敢去找她，虽然在别人看来，那是再简单不过的事。暗恋，是他唯一能做的事。他只能在每天课间操的时候，望望她的位置，看看她倾心的动作，就够了。操场上的彩砖啊，你们的位置，就是他们能够站立的地方，他俩的关系就像砖与砖之间一样固定，无法动摇。还记得当初铺砖的工人，将整个操场按正方形铺砖（整个操场可视为R行C列的矩阵，矩阵的每个元素为一块正方形砖块），正方形砖块有两种，一种为蓝色，另一种为红色。我们定义他和她之间的“爱情指标”为最大纯色正方形的面积，请你写一个程序求出“爱情指标”。
输入格式
　　第一行两个正整数R和C。
　　接下来R行C列描述整个操场，红色砖块用1来表示，蓝色砖块用0来表示。
  题目是找出最大的纯色正方形
*/
#include<stdio.h>
#include<stdlib.h>
#define max 250
int map[max][max] = { 0 };//存储地图
bool isPlace(int x, int y, int a)//a是代表第几行，从而判断该行有没有形如arr[a][a]的数组
{
	int i, j;
	int index = map[x][y];
	for (i = 0; i < a; i++)
	{
		for (j = 0; j < a; j++)
		{
			if (map[x + i][y + j] != index) //判断在边长为a的正方形下是否纯色
			{
				return false; 
			}
		}
	}
	return true;
}
int main()
{
	int i, j, ans=0;
	int m, n;
	scanf("%d%d", &m, &n);
	int maxcol = m > n ? m : n;//获取最大可能的高度
	for (i = 0; i < m; i++)//获取地图
	{
		for (j = 0; j < n; j++)
		{
			scanf("%d", &map[i][j]);
		}
	}
	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
			for (int a = ans + 1; a < maxcol; a++)
			{
				if (i + a <= n && j + a <= m) {//此时的坐标在地图里面
					if (isPlace(i, j, a)) ans = a;//假设之前找到一个的话但是没有ans大的话就不会运行
					//就是找到2*2的之后就不会再找2*2的进而找3*3的。
				}
				else
					break;
			}
		}
	}
	printf("%d", ans*ans);
	system("pause");
	return 0;
}