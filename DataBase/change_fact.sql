--ת������
  --to_number()
  --to_char()
  --to_date()
  ----------------------
  --�ַ�ת��Ϊ����char---->number
  select to_number('123')+3 from dual;--������ַ������������͵��ַ�
  --����ת��Ϊ�ַ�number--->char
  --ָ����ʾ��ʽ:
          --9��ʾռλ��������999,999,999�Ὣ���ְ���3��һ��,�ö��Ÿ���
          --L��ʾ����ҷ��ţ�$��ʾ��Ԫ����
          --0���Խ���ռλ���飬���������������λ�����㣬��ʹ��0���в�λ
  select to_char(123456789,'999,999,999') from dual;
  select to_char(123456789,'L999,999,999') from dual;
  select to_char(123456789,'$999,999,999') from dual;
  select to_char(123456789,'000,000,000,000') from dual;
  
  --to_char ��to_number֮���ת������ʽת��
  
  select * from emp where sal>'10000';--sal��number���͵ģ�'10000'��char�͵�
  
  --�ַ�ת��Ϊ���� char---->date
  ----��ѯԱ����ְ������82������Ϣ
    --ʹ��to_date('Ҫת�����ַ�',���ڸ�ʽ) �������ַ�ת��Ϊ����
    --oracle Ĭ�ϵ�ת����ʽΪ�����꣬����'01-1��-2018' oracle ��Ϊ��һ������
    --���õ����ڸ�ʽ��
        --  yyyy-mm-dd
        -- yyyy/mm/dd
    select *from emp where hiredate >to_date('1982-01-01','yyyy-mm-dd');
    select *from emp where hiredate >to_date('1982-01-01','yyyy/mm/dd');
    
    select to_char(hiredate,'yyyy-mm-dd') from emp;--ת��Ϊһ����ʽ�ַ�
    select hiredate from emp;
    --�ڱ�������������to_date,��ѯ������to_char
    --test
    select *from emp;
    insert into emp values(0001,'sofency','MANAGER','0002','01-1��-19',60000,null,20);--���ڵĸ�ʽ��char���͵� ֻ�����������Ͳ���
    --��ѯʱ��Ҫ����������ת��Ϊ�ַ����ͽ��в�ѯ
    select *from emp where hiredate>'1981-01-01';---��ѯ����
    
    
    select *from emp where to_char(hiredate,'yyyy-mm-dd')>'1982-01-01';---��ѯ��ȷ

    delete from emp where empno=1;
    select * from emp;
    
    
  