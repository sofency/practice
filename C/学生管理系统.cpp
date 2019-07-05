#include<stdio.h>
#include <string.h>
#include <stdlib.h>
#include<Windows.h>
typedef struct student//学生信息
{
	char name[20];
	char sex[10];
	int ClassRoom;
	int score;
	struct student *pre;
	struct student *next;
}STU, *PSTU;

//2.函数声明
int load();//登录界面
void menu();//菜单
void insertNode(PSTU head);//插入
void searchNode(PSTU head);//查找
void searchByName(PSTU head);//按姓名查找
void searchByClass(PSTU head);//按班级查找
void changeNode(PSTU head);//修改
void changeClass(PSTU temp);//改变班级
void changeScore(PSTU temp);//改变成绩
void deleteMenu(PSTU head);//删除
void deletByName(PSTU head);//根据名字删除
void deletBySex(PSTU head);//根据性别删除
void deletByClass(PSTU head);//根据班级删除
//3.主函数
int main()
{
	if (load() == 1)
	{
		menu();
	}
	getchar();
	getchar();
	return 0;
}

//4.函数定义
void menu()
{
	PSTU head = (PSTU)malloc(sizeof(STU));
	head->next = head;
	head->pre = head;

	while (1)
	{
		system("cls");
		printf("欢迎进入学生管理系统\n");
		printf("1.录入新同学\n");
		printf("2.查询信息\n");
		printf("3.修改同学信息\n");
		printf("4.删除\n");
		printf("0.退出系统\n");
		printf("请输入选项：");
		int choice;
		scanf("%d", &choice);
		switch (choice)
		{
		case 1:insertNode(head); break;
		case 2:searchNode(head); break;
		case 3:changeNode(head); break;
		case 4:deleteMenu(head); break;
		case 0:return;
		default:printf("输入错误 重新输入\n");
			Sleep(1000); break;
		}
	}
}
int load()//登录
{
	//输入账号密码 进行验证
	//新的账号密码
	char userName[20], passWord[20];//用户名和密码
	char name[20], word[20];//文件读取的账号密码
	FILE *fp = fopen("admin.txt", "r");
	if (fp == NULL) return 0;
	while (1)
	{
		rewind(fp);//文件指针移回开头
		system("cls");
		printf("请输入账号和密码\n");
		printf("账号：");
		scanf("%s", userName);
		printf("密码：");
		scanf("%s", passWord);
		while (1)//从文件中读取数据
		{
			fscanf(fp, "%s\t%s\n", name, word);//账号 密码
			//printf("%s\t%s\n", name, word);
			if (feof(fp)) break;//读取完毕直接读出
			if (strcmp(name, userName) == 0 && strcmp(word, passWord) == 0)
			{
				//存在  继续
				printf("用户和密码正确\n");//进入菜单
				fclose(fp);
				return 1;
			}
		}
	}
	fclose(fp);
}
void insertNode(PSTU head)
{
	PSTU temp = (PSTU)malloc(sizeof(STU));
	printf("请输入学生名字	性别	班级	成绩\n");
	scanf("%s	%s	%d	%d", temp->name, temp->sex, &temp->ClassRoom, &temp->score);
	temp->next = head->next;
	temp->pre = head;
	temp->pre->next = temp;
	temp->next->pre = temp;
	printf("插入成功\n");

	Sleep(100);
}
void deleteMenu(PSTU head)
{
	printf("选择要删除的方式\n");
	printf("1,根据名字删除\n");
	printf("2,根据性别删除\n");
	printf("3，根据班级删除\n");
	int choice;
	scanf("%d", &choice);
	switch (choice)
	{
	case 1:deletByName(head);
		break;
	case 2:deletBySex(head);
		break;
	case 3:deletByClass(head);
	default:break;
	}
}
void deletByName(PSTU head)
{
	char name[20];
	int choice;
	PSTU myList[100];
	int length = 0;

	printf("输入要输出的学员名字");
	scanf("%s", name);
	PSTU p = head->next;
	while (p != head)
	{
		if (strcmp(p->name, name) == 0)
		{
			myList[length++] = p;
		}
		p = p->next;
	}
	if (length == 0)
	{
		printf("没有找到任何数\n");
		Sleep(2000);
		return;
	}
	printf("查询到的所有结点有\n");
	for (int i = 0; i < length; i++)
	{
		printf("\n%d\t名字：%s,性别：%s,班级：%d,成绩：%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
	printf("输入编号删除数据\n");
	scanf("%d", &choice);
	if (choice >= length || choice < 0)
	{
		printf("没有对应的编号 删除失败\n");
		Sleep(1000);
	}
	else
	{
		//要输出的元素  myList[choice]
		p = myList[choice];
		p->pre->next = p->next;
		p->next->pre = p->pre;
		free(p);
		printf("删除中...\n");
		Sleep(1000);
		//myList[choice]失效了
	}

}
void deletBySex(PSTU head)
{
	char sex[10];
	int choice;
	PSTU myList[100];
	int length = 0;

	printf("输入要输出的学员性别：");
	scanf("%s", sex);
	PSTU p = head->next;
	while (p != head)
	{
		if (strcmp(sex, p->sex) == 0)
		{
			myList[length++] = p;
		}
		p = p->next;
	}
	if (length == 0)
	{
		printf("没有找到任何数\n");
		Sleep(1000);
		return;
	}
	printf("查询到的所有结点有\n");
	for (int i = 0; i < length; i++)
	{
		printf("%d\t名字：%s,性别：%c,班级：%d,成绩：%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
	printf("输入编号删除数据\n");
	scanf("%d", &choice);
	if (choice >= length || choice < 0)
	{
		printf("没有对应的编号 删除失败\n");
	}
	else
	{
		//要输出的元素  myList[choice]
		p = myList[choice];
		p->pre->next = p->next;
		p->next->pre = p->pre;
		free(p);
		printf("删除中...\n");
		Sleep(1000);
		//myList[choice]失效了
	}

}
void deletByClass(PSTU head)
{
	int Class;
	int choice;
	PSTU myList[100];
	int length = 0;

	printf("输入要输出的学员名字");
	scanf("%d", &Class);
	PSTU p = head->next;
	while (p != head)
	{
		if (p->ClassRoom == Class)
		{
			myList[length++] = p;
		}
		p = p->next;
	}
	if (length == 0)
	{
		printf("没有找到任何数\n");
		Sleep(1000);
		return;
	}
	printf("查询到的所有结点有\n");
	for (int i = 0; i < length; i++)
	{
		printf("%d\t名字：%s,性别：%s,班级：%d,成绩：%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
	printf("\n输入编号删除数据:");
	scanf("%d", &choice);
	if (choice >= length || choice < 0)
	{
		printf("\\n没有对应的编号 删除失败\n");
		Sleep(1000);
	}
	else
	{
		//要输出的元素  myList[choice]
		p = myList[choice];
		p->pre->next = p->next;
		p->next->pre = p->pre;
		free(p);
		printf("删除中...\n");
		Sleep(1000);
		//myList[choice]失效了
	}
}
void searchNode(PSTU head)
{
	printf("请输入查找的方式\n");
	printf("1.按姓名查找\n");
	printf("2.按班级查找\n");
	int choice;
	scanf("%d", &choice);
	switch (choice)
	{
	case 1:searchByName(head);
	case 2:searchByClass(head);
	default:break;
	}
}
void searchByName(PSTU head)//考虑到可能重名的情况
{
	char name[20];
	PSTU myList[100];
	int length = 0;

	printf("输入要寻找的学员名字");
	scanf("%s", name);
	PSTU p = head->next;
	while (p != head)
	{
		if (strcmp(p->name, name) == 0)
		{
			myList[length++] = p;
		}
		p = p->next;
	}
	if (length == 0)
	{
		printf("没有找到任何数\n");
		Sleep(2000);
		return;
	}
	printf("查询到的所有结点有\n");
	for (int i = 0; i < length; i++)
	{
		printf("\n%d\t名字：%s,性别：%s,班级：%d,成绩：%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
}
void searchByClass(PSTU head)
{
	int Class;
	PSTU myList[100];
	int length = 0;

	printf("输入要输出的学员班级：\n");
	scanf("%d", &Class);
	PSTU p = head->next;
	while (p != head)
	{
		if (Class == p->ClassRoom)
		{
			myList[length++] = p;
		}
		p = p->next;
	}
	if (length == 0)
	{
		printf("没有找到任何同学\n");
		Sleep(2000);
		return;
	}
	printf("查询到的所有学员有\n");
	for (int i = 0; i < length; i++)
	{
		printf("\n%d\t名字：%s,性别：%s,班级：%d,成绩：%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
}
void changeNode(PSTU head)
{
	char name[20];
	PSTU temp;
	int flag = 0;

	printf("请输入要修改的同学姓名\n");
	scanf("%s", name);

	PSTU p = head->next;
	while (p != head)
	{
		if (strcmp(p->name, name) == 0)
		{
			flag = 1;
			temp = p; break;
		}
		p = p->next;
	}
	if (flag == 0)
	{
		printf("没有找到任何数\n");
		Sleep(2000);
		return;
	}
	else
	{
		printf("\n名字：%s,性别：%s,班级：%d,成绩：%d", temp->name, temp->sex, temp->ClassRoom, temp->score);
	}
	printf("你需要修改的编号：\n");
	printf("1.班级\n");
	printf("2.成绩\n");
	int choice;
	scanf("%d", &choice);
	switch (choice)
	{
	case 1:changeClass(temp); break;
	case 2:changeScore(temp); break;
	default:printf("你输入的有误，请重新输入\n"); break;
	}
	Sleep(1000);
}
void changeClass(PSTU temp)//改变班级
{
	int newClass;
	printf("请输入要转入的班级\n");
	scanf("%d", &newClass);
	printf("请稍等,正在修改中...\n");
	temp->ClassRoom = newClass;
	Sleep(1000);
	printf("修改成功\n");
	printf("修改的结果如下\n");
	printf("名字：%s\t性别：%s\t班级：%d\t成绩：%d\n", temp->name, temp->sex, temp->ClassRoom, temp->score);

}
void changeScore(PSTU temp)//改变成绩
{
	int newScore;
	printf("请输入要修改的成绩\n");
	scanf("%d", &newScore);
	printf("请稍等,正在修改中...\n");
	temp->score = newScore;
	Sleep(1000);
	printf("修改成功\n");
	printf("修改的结果如下\n");
	printf("名字：%s\t性别：%s\t班级：%d\t成绩：%d\n", temp->name, temp->sex, temp->ClassRoom, temp->score);
}
