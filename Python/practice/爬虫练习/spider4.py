import requests
import os
root="D://python爬取//"
pic_list=['https://t1.hddhhn.com/uploads/tu/201920/533/wlmn.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/532/twmn.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/532/zgmn.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/532/rbmn.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/528/hgmn.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/332/230.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/332/231.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/277/45hgf65g.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/276/5445fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/268/56fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/272/212fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/266/5445hgf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/260/54665hg.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/248/6565grtf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/246/5454hgf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/274/45g65fd.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/225/8778ghf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/270/3532.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/264/5456gfd.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/262/2165fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/217/48jui.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/258/45gfd.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/256/85hgf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/254/45hgf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/252/f5ds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/250/6565gfd.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/244/45g5fd.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/242/6589fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/240/5454fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/238/5656nh.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/236/6556gf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/234/65465gf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/231/2323hgf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/191/45ghfg.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/229/45fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/227/455fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/178/787gfd.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/277/45hgf65g.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/276/5445fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/268/56fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/272/212fds.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/266/5445hgf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/260/54665hg.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/248/6565grtf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/246/5454hgf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/274/45g65fd.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/225/8778ghf.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/270/3532.jpg',
          'https://t1.hddhhn.com/uploads/tu/201920/264/5456gfd.jpg']


kv={"user-agent":"Mozilla/5.0"}
try:
    if not os.path.exists(root):
        os.mkdir(root)

    for img in pic_list:
        path = root + img.split('/')[-1]
        if not os.path.exists(path):
            r = requests.get(img,headers=kv)
            with open (path,"wb") as f:
                f.write(r.content)
                f.close()
                print("文件保存成功")
        else:
            print("文件已存在")
except:
    print("爬取失败")
