--���е�ѧϰ
create sequence cc;--������������
select cc.currval from dual;---��ѯ��ǰ����
select cc.nextval from dual;--��ֵ̬���µ���9

--�����Զ�������
create sequence aa start with 5 --��5��ʼ
increment by 2--���ò���

--�������Ա�
create table teacher(
   tid number(10) primary key,
   tname varchar(100) not null
);
insert into teacher values(cc.nextval,'����');
select * from teacher order by tid;

--��������  
--ֻ��Ҫʹ����������������� oracle�ڵײ��Ѿ�����������
--oracle �Զ�Ϊ������������
 create index ������ on ����(�ֶ���)
 
 create index index_teacher_tname on teacher(tname);--��name��������
 --����Ҫ֪����δ��������� ֱ���ø���䴴������
 drop index index_teacher_tname;--ɾ������
 
 
 