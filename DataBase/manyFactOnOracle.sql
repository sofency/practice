---���к����Ĵ���
--�ۼ�����
select sal from emp;
select max(sal),min(sal) from emp;--���к������ܺ��ֶ�ֱ�ӻ��ã����Ƿ���

select ename,sal from emp where sal=(select max(sal) from emp);--��ѯ���нˮ��������нˮ

select avg(sal) from emp;---��ѯƽ����
select count(*) from emp;--��ѯԪ�����
select distinct job from emp;--��ѯ���������ಢ��ʾ
select count(distinct job) from emp;--��ѯԱ��������
--���к������Ի��ã���ʾ��һ��
select count(*),max(sal),min(sal),avg(sal),sum(sal) from emp;
------------------------------------------------------------------------







