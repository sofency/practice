---ѡ����30�е�����Ա��
select *from emp where deptno=30;
---�г����а���Ա����������źͲ��ű��
select ename,empno,deptno from emp where job='CLERK';
---�ҳ�Ӷ�����н���Ա��
select *from emp where comm>sal;
---�ҳ�Ӷ�����н��60%��Ա��
select * from emp where comm>sal*0.4;
---�ҳ�����10�����о���(MANAGER)�Ͳ���20�����а���Ա(CLERK)����ϸ����
select *from emp where (deptno=10 and job='MANAGER') or (deptno=20 and job='CLERK');--����������Ҳ��and�ļ������or
---�ҳ�����10�����о���(MANAGER)�Ͳ���20�����а���Ա(CLERK),�Ȳ��Ǿ����ֲ��ǰ���Ա����н����ڵ���2000������Ա������ϸ����
select *from emp where (job='MANAGER' and deptno=10) or (deptno=20 and job='CLERK') or (job <>'MANAGER' and job<>'CLERK' and sal>4000);
---�ҳ���ȡӶ���Ա���Ĳ�ͬ����
select distinct job from emp where comm is not null and comm<>0;--������nullʱ������comm<>null ֻ����comm is not null
select *from emp;
---�ҳ�����Ӷ�����Ӷ�����100��Ա���Ĳ�ͬ����
select distinct job from emp where comm is null or comm<100;
---�ҳ����µ����������ܹ͵�Ա��
select * from emp where hiredate=last_day(hiredate)-2;--hiredate��ѯ�ܹ͵��·�������hiredate =last_day(hiredate)-2�Ĺ�Ӷʱ���ϵ
---�ҳ�����38��ǰ�ܹ͵�Ա��
select * from emp where months_between('20-4��-2019',hiredate)>12*38;
---������ĸ��д�ķ�ʽ��ʾ����Ա��������
select INITCAP(ename) from emp;
---��ʾ����Ϊ5���ַ���Ա������
select ename from emp where length(ename)=5;
---��ʾ����S��s��Ա��������
select ename from emp where ename not like '%S%' and ename not like '%s%';
---��ʾ����Ա��������ǰ�����ַ�
--ȡ���ַ���substr(�ַ���,��ʼλ�ã���ֹλ��) ע��λ���Ǵ�1��ʼ���
select substr(ename,1,3)  from emp ;
--��ʾ����Ա������������a��������A
select replace(ename,'A','a') from emp;
---��ʾ��35��������޵�Ա�����������ܹ�����
select sysdate from dual;--��ʾ��ǰ����
--ʹ��months_between
select ename,hiredate from emp where months_between(sysdate, hiredate)>12*35;
---ʹ������
select ename,hiredate from emp where (sysdate-hiredate)/365>35;
---��ʾԱ������ϸ���ϣ�����������
select *from emp order by ename;
---��ʾԱ�����������ܹ����ڣ����ݷ������޽����ϵ�Ա��������ǰ��
select ename,hiredate from emp order by (sysdate-hiredate) desc;--desc����
---��ʾ����Ա����������������н�𣬰������Ľ������У���������ͬ��н������
select ename,job,sal from emp order by job,sal desc;
--- ��ʾ����Ա�������������빫˾����ݺ��·ݣ����ܹ������������������·���ͬ��������ݵ�Ա������ǰ��
select ename,substr(to_char(hiredate,'yyyy-mm-dd'),1,4) ���,substr(to_char(hiredate,'yyyy-mm-dd'),6,7) �·�  from emp order by substr(to_char(hiredate,'yyyy-mm-dd'),6,7),substr(to_char(hiredate,'yyyy-mm-dd'),1,4);
--update emp set hiredate=to_char(hiredate,'yyyy-mm-dd');--�޷�������Ϊԭ�����ε���string���͵�
select ename,to_char(hiredate,'yyyy') ���,to_char(hiredate,'mm') �·� from emp order by to_char(hiredate,'mm');
--- ��ʾһ����Ϊ30����������Ա������н��
select floor((sal+nvl(comm,0))/30) avgerage from emp;
--- �ҳ��ڣ�������ݣ�2����Ƹ������Ա��
select * from emp where to_char(hiredate,'mm')=2;
---��ѯ����Ա�����繫˾������
select ename,hiredate,floor(sysdate- hiredate) days from emp;
---����������ʾ����Ա�����������
select ename,floor(floor(months_between(sysdate,hiredate))/12) ���,mod(floor(months_between(sysdate,hiredate)),12) �·� ,floor(mod(sysdate-hiredate,30)) �� from emp;


