--��ѯ��ͬ���ŵ���߹���
--ʹ��group by ����
---ʹ�÷����,��select�����ֻ������ַ����ֶκͶ��к���
select deptno,max(sal)
-------�����ֶ�,���к���
from emp 
group by deptno
order by deptno;--�����źŲ�ѯ
--�����ŷֳ����飬���ÿ�����߹���
select *from emp;
select job, max(sal),count(*) from emp group by job; --count(*)��ʾ�ù���������

--���ݶ���������з���
--��ѯ��ͬ���ŵĲ�ͬ������λ������
--���ֶν��з���,�������յ�һ�ֶη���,Ȼ��ÿ��С��������յڶ����ֶμ������飬һ������
select deptno,job,count(*) from emp group by deptno,job order by deptno;---�Ȱ���deptno���з���,�ڰ���job���з���


---����ɸѡ��ѯ�ؼ���HAVING having 
--��ѯ��ͬ���ŵĲ�ͬ������λ��������1����Ϣ

select deptno,lower(job),count(*) from emp group by deptno,job having count(*)>1 order by deptno;---�ؼ�������ԭ��
--��Է���������ɸѡ������ʹ�ö��к���
---having ����ͷ�����ʹ�ò�������ʹ��

---��ѯ���źŴ���10�Ĳ�ͬ���ŵĲ�ͬ������λ������
select deptno,lower(job),count(*),max(sal) from emp group by deptno,job having deptno>10;--���нˮ����ÿһ�еķ���Ļ��������
select deptno,lower(job),count(*),max(sal)from emp where deptno>10 group by deptno,job;--��ѯЧ�ʸ�
--ִ�е�˳��  
--from emp                                    2.--from emp
--group by deptno,job                           --where deptno>10 ---��С�˷�Χ
--select deptno,job,count(*),max(sal)           --group by deptno,job
--having count(*)>1                             --select deptno,lower(job)
                                                --having count(*)>1
--����emp�а���deptno����,�ٰ���job��deptno����Ļ����Ͻ��з��齨���Ȼ���ѯdeptno����10����Ϣ


