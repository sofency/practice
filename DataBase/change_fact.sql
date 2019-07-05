--转换函数
  --to_number()
  --to_char()
  --to_date()
  ----------------------
  --字符转化为数字char---->number
  select to_number('123')+3 from dual;--里面的字符都是数字类型的字符
  --数字转化为字符number--->char
  --指定显示格式:
          --9表示占位符，例如999,999,999会将数字按照3个一组,用逗号隔开
          --L表示人民币符号，$表示美元符号
          --0可以进行占位分组，但是如果真是数据位数不足，会使用0进行补位
  select to_char(123456789,'999,999,999') from dual;
  select to_char(123456789,'L999,999,999') from dual;
  select to_char(123456789,'$999,999,999') from dual;
  select to_char(123456789,'000,000,000,000') from dual;
  
  --to_char 和to_number之间的转化是隐式转化
  
  select * from emp where sal>'10000';--sal是number类型的，'10000'是char型的
  
  --字符转化为日期 char---->date
  ----查询员工入职日期在82年后的信息
    --使用to_date('要转化的字符',日期格式) 函数将字符转化为日期
    --oracle 默认的转化格式为日月年，例如'01-1月-2018' oracle 认为是一个日期
    --常用的日期格式：
        --  yyyy-mm-dd
        -- yyyy/mm/dd
    select *from emp where hiredate >to_date('1982-01-01','yyyy-mm-dd');
    select *from emp where hiredate >to_date('1982-01-01','yyyy/mm/dd');
    
    select to_char(hiredate,'yyyy-mm-dd') from emp;--转化为一定格式字符
    select hiredate from emp;
    --在表中新增数据用to_date,查询数据用to_char
    --test
    select *from emp;
    insert into emp values(0001,'sofency','MANAGER','0002','01-1月-19',60000,null,20);--日期的格式是char类型的 只能以日期类型插入
    --查询时需要将日期类型转化为字符类型进行查询
    select *from emp where hiredate>'1981-01-01';---查询错误
    
    
    select *from emp where to_char(hiredate,'yyyy-mm-dd')>'1982-01-01';---查询正确

    delete from emp where empno=1;
    select * from emp;
    
    
  