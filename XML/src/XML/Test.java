package XML;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Test {
    @org.junit.Test
    public void test()
    {
        //创建SaxReater输入流，读取xml配置文件，生成document对象
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("D:\\java\\IDEACommunity-Project\\javaSE\\XML\\xml\\books.xml");
            System.out.println(document);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void test02(){
        SAXReader reader=new SAXReader();
        try {
            //读取books.xml文件
            Document document = reader.read("D:\\java\\IDEACommunity-Project\\javaSE\\XML\\xml\\books.xml");
            //通过document对象获取根元素
            Element rootElement = document.getRootElement();
            //System.out.println(rootElement);
            //通过根元素获取book标签对象
            //element()和elements()都是通过标签名查找子元素
            List<Element> books=rootElement.elements("book");
            for(Element e:books){
                //把标签对象转换为标签字符串
                //System.out.println(e.asXML());
                Element nameElm=e.element("name");
                Element authorElm=e.element("author");
                Element priceElm=e.element("price");
                //获得标签文本内容
                System.out.println("书名:"+nameElm.getText()+" 作者："+authorElm.getText()+" 定价："+priceElm.getText());
                //直接获取指定标签名的文本内容
                System.out.println("书名："+e.elementText("name"));
                //获取属性值
                System.out.println("属性值sn="+e.attributeValue("sn"));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
