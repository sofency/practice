from package import size
from package import importfunc
## from package.size import width 导入宽度
#出现下划线的解决方案
"""
1.setting 下 console下选择 python console 添加source root to pythonpath
2 在项目下 添加目录为根节点

"""

if __name__=='__main__':
    print("宽度是"+str(size.width))
    importfunc.change(10,2)
    print(importfunc.getHeight())
    print(importfunc.getWidth())