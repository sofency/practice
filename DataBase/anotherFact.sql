--��������
--nvl()
--nvl2()
--decode()
---��ѯԱ���Ĺ�����Ϣ
select ename,job,sal,comm from emp;
select ename,job,sal+comm from emp;--���ݼ�null��Ϊnull
--��ѯнˮ,sal+comm
select ename, job,sal+nvl(comm,0),sal+comm,sal,comm from emp;--nvl�ж�,���commΪnull ����0(�ڶ�������),���򷵻ر���-����֧��if
select ename,job,sal,comm,nvl2(comm,sal+comm,sal) from emp;--���commΪnull�Ļ�ִ��,sal,��Ϊnullִ��sal+comm
select ename ,job,decode(job,'MANAGER','����','PRESIDENT','���³�','SALESMAN','����Ա','��ͨԱ��') career from emp;
-------------------------����, ����1,  ����1,   ����2,      ����2,   ����3,   ����3     ,���������¼�     