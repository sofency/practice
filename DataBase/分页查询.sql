---������ͼ����ɾ�Ķ����ᱻ���µ��±���

--���Կ���ֻ�Ա�Ķ�ģʽ  ʹ�ùؼ���with read
create view emp1 as select empno,ename,job from emp where sal<5000 with read only;
select * from emp1;
update emp1 set ename='alice' where empno=7499;--�޷��޸�

--��ҳ��ѯ
  --���⣺ ��һ�����е��������ر��ʱ�����һ����ȫ����ʾ��Ӵ�û��������ҳ������Ӵ����鼫��
  ---�������ҳ��ѯ
  --ʹ��rownum�ؼ��֣�oracle������ṩ���Զ�����ѯ�����ŵĹؼ��֣���ÿ������û�й�ϵ
  --rownumֻ����< ��<=����ѯ
  select rownum,e.* from emp e;--��Ҫ��������emp e
  --��ѯ�ڶ�ҳ����
  select rownum,e.* from emp e where rownum<=5;
  select * from (select rownum r,e.* from emp e where rownum<=10) t where r>5;
  --��ѯ����ҳ����
  select * from (select rownum r,e.* from emp e where rownum<=15) s where r>10;
  --��ҳ��ѯԱ����Ϣ���չ�������
 select * from(select rownum r,e.* from (select * from emp order by sal) e where rownum<=10) where r>5;