---���ݵ���ɾ��&���ݱ���
----��������
  ---�ڲ�������һ���µĲ�����Ϣ����Ϣ����Ϊ ���50  ����LOLѧԺ   ��ַ ����
  --f9֮�������Ǵ����ڴ��еģ���������������ݿ���,����������ݴ���,���Ե���ع��������ݴ��ڴ������
  insert into dept values(50,'LOLѧԺ','����');---ȫ�ֶβ������ʡ���ֶ���
  insert into dept(deptno,dname) values(60,'�Ϻ�');---���벿������
  select *from dept order by deptno;
  
  ---����
    ---��һ�ű��У�ĳ�����Ե�ֵ�����ظ����ǿ�Ψһ��
    ---Ψһ�ı�ʶ���ݣ�һ��������ʾһ������
    
    ---ɾ������
      --- ɾ���� delete from ����
          ---truncate table ���� ɾ������
      --- ɾ������  delete from ���� where ����
    delete from dept where deptno=10;---Υ��������Լ��-��Ϊ�ڱ�emp��ʹ����deptno(��dept������룬deptno��emp�������)
    --select *from emp;
    
    ----��������
    --update ���� set �ֶ���=�µ�ֵ,�ֶ���=�µ�ֵ����������where ����
    select *from dept;
    update dept set dname=null,loc='�Ϻ�' where deptno=60;
    update dept set dname='JAVAѧԺ' where deptno=50;
    
    
    ---���ݱ���
      ---���𱸷�
        --ȫ�����ݣ� create table �µı��� as select *from ���ݱ���
        --���ֱ��ݣ� create table �µı��� as select �ֶ���1,�ֶ���2����������from ����
        create table deptBak as select *from dept;---ȫ������
        select *from deptBak;
        insert into deptBak values(50,'11','11');--���Ὣ�������ݣ��������������Լ�����⡣
        --���в���
        insert into deptBak select *from dept;---���в���
