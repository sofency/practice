--and�Ĳ�ѯ�������or,С���ŵļ�������ߵ�
select *from emp where (job='SALESMAN' or job='MANAGER') and sal>2500;
--���к���

--1.�ַ�����
----��ѯ����Ա����Ϣ��Ա������,����Сд��ʾlower(����)
----����ĸ��д INITCAP(����)
----LTRIM(��ü�)  ltrim('acbdcd',acb)  ���dcd
----replace('jack and jue','j','bl')��'jack and jue'�н�j��bl����

select ltrim('sofency','so') from dual;
select trim('sofency','of') from dual;
select empno,lower(ename),lower(job) from emp;
select empno,INITCAP(ename),lower(job) from emp;
---oracle������
--�����oracle���������ҽ�һ��������
---��ѯ�ı�ʾα���������ʵ���ڵı�

---��ֵ����������α��
---dual�����Ǵ��ڵı�,��Ϊ�˷���������ݵ���֤����ʱ���ڵı�
--2.��ֵ������
select abs(-1),ceil(2.2),floor(3.3),power(2,3),mod(5,2),round(100.256),trunc(2.332,1) from dual;
---3.���ں�����
select months_between('01-1��-2018','24-6��-2017') from dual;--�жϸ��·��Ƿ񵽴�һ��--��ѯ������������˼�����
select add_months('01-2��-1998',11) from dual;--���·�  ����˵�����º��ʱ���Ƕ���
select next_day('17-4��-2019','���ڶ�') from dual;--����ʱ��������������ڶ�������
select last_day('06-4��-19') from dual;--���ظ��µ����һ��

select round(to_date('01-6��-03'),'YEAR') from dual;--���µ�һ������������,01-7��-04
select round(to_date('15-7��-03'),'MONTH') from dual;--���յ�һ������������,01-8��-03
select round(to_date('18-4��-19'),'DAY') from dual;--��ʾ�ͽ�������





