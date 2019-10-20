
##设置模板进行打印
#1
import math
template='编号 ：{:0>9s} \t 公司名称 ：{:s} \t 官网： http://www.{:s}.com'
context1=template.format('41702070701','腾讯','tenxun')#向模板里面填充字符串
context2=template.format('41702070710','自由职业','home')
print(context1)
print(context2)

#使用%格式不能使用正则
template1='编号：%s \t 公司名称 %s   官网:官网： http://www.%s.com'
test=("41702070710","alibaba","taobao")
print(template1%test)

#2
print('1251+3950的结果是（以货币形式显示）：￥{:.2f}元'.format(1251+3950))
##print('{:.1f}用科学技术法表示：{0:E}'.format(120000.1))
print('∏取五位小数点：{:.5f}'.format(math.pi))
##print('{0:d}的十六进制结果是{:#x}'.format(100))