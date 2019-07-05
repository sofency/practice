#include<stdio.h>
#include <string.h>
#include <stdlib.h>
#include<Windows.h>
typedef struct student//ѧ����Ϣ
{
	char name[20];
	char sex[10];
	int ClassRoom;
	int score;
	struct student *pre;
	struct student *next;
}STU, *PSTU;

//2.��������
int load();//��¼����
void menu();//�˵�
void insertNode(PSTU head);//����
void searchNode(PSTU head);//����
void searchByName(PSTU head);//����������
void searchByClass(PSTU head);//���༶����
void changeNode(PSTU head);//�޸�
void changeClass(PSTU temp);//�ı�༶
void changeScore(PSTU temp);//�ı�ɼ�
void deleteMenu(PSTU head);//ɾ��
void deletByName(PSTU head);//��������ɾ��
void deletBySex(PSTU head);//�����Ա�ɾ��
void deletByClass(PSTU head);//���ݰ༶ɾ��
//3.������
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

//4.��������
void menu()
{
	PSTU head = (PSTU)malloc(sizeof(STU));
	head->next = head;
	head->pre = head;

	while (1)
	{
		system("cls");
		printf("��ӭ����ѧ������ϵͳ\n");
		printf("1.¼����ͬѧ\n");
		printf("2.��ѯ��Ϣ\n");
		printf("3.�޸�ͬѧ��Ϣ\n");
		printf("4.ɾ��\n");
		printf("0.�˳�ϵͳ\n");
		printf("������ѡ�");
		int choice;
		scanf("%d", &choice);
		switch (choice)
		{
		case 1:insertNode(head); break;
		case 2:searchNode(head); break;
		case 3:changeNode(head); break;
		case 4:deleteMenu(head); break;
		case 0:return;
		default:printf("������� ��������\n");
			Sleep(1000); break;
		}
	}
}
int load()//��¼
{
	//�����˺����� ������֤
	//�µ��˺�����
	char userName[20], passWord[20];//�û���������
	char name[20], word[20];//�ļ���ȡ���˺�����
	FILE *fp = fopen("admin.txt", "r");
	if (fp == NULL) return 0;
	while (1)
	{
		rewind(fp);//�ļ�ָ���ƻؿ�ͷ
		system("cls");
		printf("�������˺ź�����\n");
		printf("�˺ţ�");
		scanf("%s", userName);
		printf("���룺");
		scanf("%s", passWord);
		while (1)//���ļ��ж�ȡ����
		{
			fscanf(fp, "%s\t%s\n", name, word);//�˺� ����
			//printf("%s\t%s\n", name, word);
			if (feof(fp)) break;//��ȡ���ֱ�Ӷ���
			if (strcmp(name, userName) == 0 && strcmp(word, passWord) == 0)
			{
				//����  ����
				printf("�û���������ȷ\n");//����˵�
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
	printf("������ѧ������	�Ա�	�༶	�ɼ�\n");
	scanf("%s	%s	%d	%d", temp->name, temp->sex, &temp->ClassRoom, &temp->score);
	temp->next = head->next;
	temp->pre = head;
	temp->pre->next = temp;
	temp->next->pre = temp;
	printf("����ɹ�\n");

	Sleep(100);
}
void deleteMenu(PSTU head)
{
	printf("ѡ��Ҫɾ���ķ�ʽ\n");
	printf("1,��������ɾ��\n");
	printf("2,�����Ա�ɾ��\n");
	printf("3�����ݰ༶ɾ��\n");
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

	printf("����Ҫ�����ѧԱ����");
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
		printf("û���ҵ��κ���\n");
		Sleep(2000);
		return;
	}
	printf("��ѯ�������н����\n");
	for (int i = 0; i < length; i++)
	{
		printf("\n%d\t���֣�%s,�Ա�%s,�༶��%d,�ɼ���%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
	printf("������ɾ������\n");
	scanf("%d", &choice);
	if (choice >= length || choice < 0)
	{
		printf("û�ж�Ӧ�ı�� ɾ��ʧ��\n");
		Sleep(1000);
	}
	else
	{
		//Ҫ�����Ԫ��  myList[choice]
		p = myList[choice];
		p->pre->next = p->next;
		p->next->pre = p->pre;
		free(p);
		printf("ɾ����...\n");
		Sleep(1000);
		//myList[choice]ʧЧ��
	}

}
void deletBySex(PSTU head)
{
	char sex[10];
	int choice;
	PSTU myList[100];
	int length = 0;

	printf("����Ҫ�����ѧԱ�Ա�");
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
		printf("û���ҵ��κ���\n");
		Sleep(1000);
		return;
	}
	printf("��ѯ�������н����\n");
	for (int i = 0; i < length; i++)
	{
		printf("%d\t���֣�%s,�Ա�%c,�༶��%d,�ɼ���%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
	printf("������ɾ������\n");
	scanf("%d", &choice);
	if (choice >= length || choice < 0)
	{
		printf("û�ж�Ӧ�ı�� ɾ��ʧ��\n");
	}
	else
	{
		//Ҫ�����Ԫ��  myList[choice]
		p = myList[choice];
		p->pre->next = p->next;
		p->next->pre = p->pre;
		free(p);
		printf("ɾ����...\n");
		Sleep(1000);
		//myList[choice]ʧЧ��
	}

}
void deletByClass(PSTU head)
{
	int Class;
	int choice;
	PSTU myList[100];
	int length = 0;

	printf("����Ҫ�����ѧԱ����");
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
		printf("û���ҵ��κ���\n");
		Sleep(1000);
		return;
	}
	printf("��ѯ�������н����\n");
	for (int i = 0; i < length; i++)
	{
		printf("%d\t���֣�%s,�Ա�%s,�༶��%d,�ɼ���%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
	printf("\n������ɾ������:");
	scanf("%d", &choice);
	if (choice >= length || choice < 0)
	{
		printf("\\nû�ж�Ӧ�ı�� ɾ��ʧ��\n");
		Sleep(1000);
	}
	else
	{
		//Ҫ�����Ԫ��  myList[choice]
		p = myList[choice];
		p->pre->next = p->next;
		p->next->pre = p->pre;
		free(p);
		printf("ɾ����...\n");
		Sleep(1000);
		//myList[choice]ʧЧ��
	}
}
void searchNode(PSTU head)
{
	printf("��������ҵķ�ʽ\n");
	printf("1.����������\n");
	printf("2.���༶����\n");
	int choice;
	scanf("%d", &choice);
	switch (choice)
	{
	case 1:searchByName(head);
	case 2:searchByClass(head);
	default:break;
	}
}
void searchByName(PSTU head)//���ǵ��������������
{
	char name[20];
	PSTU myList[100];
	int length = 0;

	printf("����ҪѰ�ҵ�ѧԱ����");
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
		printf("û���ҵ��κ���\n");
		Sleep(2000);
		return;
	}
	printf("��ѯ�������н����\n");
	for (int i = 0; i < length; i++)
	{
		printf("\n%d\t���֣�%s,�Ա�%s,�༶��%d,�ɼ���%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
}
void searchByClass(PSTU head)
{
	int Class;
	PSTU myList[100];
	int length = 0;

	printf("����Ҫ�����ѧԱ�༶��\n");
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
		printf("û���ҵ��κ�ͬѧ\n");
		Sleep(2000);
		return;
	}
	printf("��ѯ��������ѧԱ��\n");
	for (int i = 0; i < length; i++)
	{
		printf("\n%d\t���֣�%s,�Ա�%s,�༶��%d,�ɼ���%d", i, myList[i]->name, myList[i]->sex, myList[i]->ClassRoom, myList[i]->score);
	}
}
void changeNode(PSTU head)
{
	char name[20];
	PSTU temp;
	int flag = 0;

	printf("������Ҫ�޸ĵ�ͬѧ����\n");
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
		printf("û���ҵ��κ���\n");
		Sleep(2000);
		return;
	}
	else
	{
		printf("\n���֣�%s,�Ա�%s,�༶��%d,�ɼ���%d", temp->name, temp->sex, temp->ClassRoom, temp->score);
	}
	printf("����Ҫ�޸ĵı�ţ�\n");
	printf("1.�༶\n");
	printf("2.�ɼ�\n");
	int choice;
	scanf("%d", &choice);
	switch (choice)
	{
	case 1:changeClass(temp); break;
	case 2:changeScore(temp); break;
	default:printf("���������������������\n"); break;
	}
	Sleep(1000);
}
void changeClass(PSTU temp)//�ı�༶
{
	int newClass;
	printf("������Ҫת��İ༶\n");
	scanf("%d", &newClass);
	printf("���Ե�,�����޸���...\n");
	temp->ClassRoom = newClass;
	Sleep(1000);
	printf("�޸ĳɹ�\n");
	printf("�޸ĵĽ������\n");
	printf("���֣�%s\t�Ա�%s\t�༶��%d\t�ɼ���%d\n", temp->name, temp->sex, temp->ClassRoom, temp->score);

}
void changeScore(PSTU temp)//�ı�ɼ�
{
	int newScore;
	printf("������Ҫ�޸ĵĳɼ�\n");
	scanf("%d", &newScore);
	printf("���Ե�,�����޸���...\n");
	temp->score = newScore;
	Sleep(1000);
	printf("�޸ĳɹ�\n");
	printf("�޸ĵĽ������\n");
	printf("���֣�%s\t�Ա�%s\t�༶��%d\t�ɼ���%d\n", temp->name, temp->sex, temp->ClassRoom, temp->score);
}
