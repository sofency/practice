--����ѯ

--��ѯԱ��������������н�ʣ���������
--�ѿ����� 
select * from emp,dept; --emp���dept��ȫ����
--��ֵ����
---������ĵѿ�������Ȼ��ɸѡ��ɸѡ����Ϊ��ֵɸѡ
---���������Ĺ����ֶΣ���Ҫ�������� ���������ɸѡ deptnoҪ������emp.deptno
select ename,job,sal ,dname from emp,dept where emp.deptno=dept.deptno; 
select e.ename,e.empno,e.sal from emp e;--����ʹ�ñ���

--����ֵ����
select * from emp;
select * from emp e,salgrade s where e.sal>s.losal and e.sal<s.hisal;
select * from salgrade;
--��������
--��ѯԱ��������������н�ʣ����ϼ��쵼����
select e1.*,e2.ename from emp e1,emp e2 where e1.mgr=e2.empno;--��������
select e1.empno,e1.ename,e1.job,e1.sal,e2.ename from emp e1,emp e2 where e1.mgr=e2.empno;

---������
    --��������
       --��ѯԱ��������������н�ʣ��������Ƽ�û��Ա���Ĳ�����Ϣ
       select * from emp e,dept d where e.deptno(+)=d.deptno;--��ʾ��ߵ����ݿ��ܲ�������(+)�ӵ��ұ߱�ʾ�ұߵ����ݿ��ܲ�����
       
    --��������
    --��ѯԱ��������������н�ʣ��������Ƽ�û�в��ŵ�Ա����Ϣ
     select * from emp e,dept d where e.deptno=d.deptno(+);
     
---SQL99����ѯ
      ---��Ȼ����
        ---�ص�1���ײ��ȵѿ�������Ȼ�������е�ͬ��ֵͬ�ֶ��Զ����е�ֵɸѡ
        ---ȱ��1������밴���ֶ�����ͬ������ֵ��ͬ���е�ֵɸѡ��ô�죿�ͱ�������SQL�Ĳ�ѯ�ϼ��ϰ������
        ---ȱ��2�����ָ���ղ����ֶν���ɸѡ��ô�죿
        select * from emp cross join dept;
        select * from emp natural join dept;
      ---ȱ��������
        ---���1��ʹ��using�ؼ���
            --����1��ָ��ʹ��ָ�����ֶζ����ϲ�ѯ�Ľ�����е�ֵ��ѯ ע�⣺ָ�����ֶα����������е�ͬ��ֵͬ�ֶ�
            select * from emp inner join dept using(deptno)--ָ�����ֶ�д��ǰ��
            --����2��ʹ��on�ؼ��ֽ����Զ�����������ɸѡ(��ֵɸѡ������ֵɸѡ)
            ---ע�⣺��ͨɸѡ����ʹ��where����ɸѡ����Ҫʹ��on�ؼ��� �ô���SQL�����Ķ��Ա�ǿ
            --select ���� from ���� inner join ���� on �������� where ��ͨɸѡ����
            select * from emp inner join dept on emp.deptno=dept.deptno where sal>2000;
            
        --������
          ---�������� left join
          select * from emp e left join dept d on d.deptno=e.deptno order by e.empno;
          ---�������� right join
           select * from emp e right join dept d on d.deptno=e.deptno order by e.empno;
          ---ȫ������ full outer join
           select * from emp e  full outer join dept d on d.deptno=e.deptno;
           --select * from emp;
          --update emp set deptno=null where empno=7369;
          
          --������
          select e1.*,e2.ename from emp e1 inner join emp e2 on e1.mgr=e2.empno;
          
          ---�÷��ܽ�
               ---select ���� (���������ӷ���ȥ�أ�oracle�������߼�����)
               ---from ����1������2������3������������
               --where ����(����,������������ͨɸѡ������)
               ---group by ���� �ֶ�
               ---having ���к���ɸѡ
               ---order  by �����ֶ�
               
        ---SQL99�ܽ�
        --ɸѡ����
        select * from emp 
        inner join dept 
        on emp.deptno=dept.deptno 
        inner join city 
        on dept.loc=city.cid;--cityδ����  ��ѯЧ�ʸߣ����ҽṹ����
        where emp.sal>2000 or e.comm is not null;
     
     