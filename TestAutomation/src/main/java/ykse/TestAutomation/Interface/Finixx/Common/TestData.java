package ykse.TestAutomation.Interface.Finixx.Common;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestData {
	static String filePath = "src/main/java/ykse/TestAutomation/Interface/Finixx/Common/resources/";
	//public 

	/**
	*根据key获取xml的value值
	* @author lkg
	* @Time2016-04-18 11:44
	*/	
	public static String FindValueInVariables(String key) {
		SAXReader sr = new SAXReader();// 获取读取xml的对象。
		try {
			String xmlFile = filePath + "TestData.xml";
			Document doc = sr.read(xmlFile);
			Element resRoot = doc.getRootElement();
			for (int i = 0; i < resRoot.elements().size(); i++) {
				if (((Element) resRoot.elements().get(i)).attributeValue("name").equals(key)) {

					return  ((Element) resRoot.elements().get(i)).attributeValue("value");
				}

			}
			return null;

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	*根据key,xml文件名获取xml的value值
	* @author lkg
	* @Time2016-04-18 11:44
	*/		
	public static String FindValueInVariablesByFile(String key,String file) {
		SAXReader sr = new SAXReader();// 获取读取xml的对象。
		try {
			String xmlFile = filePath + file;
			Document doc = sr.read(xmlFile);
			Element resRoot = doc.getRootElement();
			for (int i = 0; i < resRoot.elements().size(); i++) {
				if (((Element) resRoot.elements().get(i)).attributeValue("name").equals(key)) {

					return  ((Element) resRoot.elements().get(i)).attributeValue("value");
				}

			}
			return null;

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
