# -*- coding: utf-8 -*-
import scrapy#导入模块
from quotetutorial.items import QuoteItem

class QuotesSpider(scrapy.Spider):
    name = 'quotes'
    allowed_domains = ['quotes.toscrape.com']
    start_urls = ['http://quotes.toscrape.com/']

    def parse(self, response):
        quotes = response.css(".quote")     #调用scrapy里面的response里面的css进行属性的选择  返回所有得到名言标签列表
        for quote in  quotes:

            item = QuoteItem()
            text = quote.css(".text::text").extract_first()  #获取text标签里面的text文本  extract_first找取第一个文本
            author = quote.css(".author::text").extract_first()  #获取作者的名字
            tags = quote.css(".tags .tag::text").extract()  #获取所有的文本信息

            #将获取的文本存储到item里面进行再次处理
            item['text'] = text
            item['author'] = author
            item['tags'] = tags
            yield item
        #湖区单签页面的next属性进行再次处理
        next = response.css(".pager .next a::attr(href)").extract_first()
        print(next)
        url = response.urljoin(next)  ##w完整的url
        yield  scrapy.Request(url=url,callback=self.parse)  #回调使用parse进行使用爬取数据
