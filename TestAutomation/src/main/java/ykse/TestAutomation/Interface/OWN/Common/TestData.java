package ykse.TestAutomation.Interface.OWN.Common;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestData {
	
	//获取默认值方法
	public static String FindValueInVariables(String key) {
		SAXReader sr = new SAXReader();// 获取读取xml的对象。
		try {
			Document doc = sr.read("src/main/java/ykse/TestAutomation/Web/MC/Common/resources/TestData.xml");
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
	
	public static String FindValueByApiNameAndCaseId(String apiName,String name,String CaseId) {
		
		SAXReader sr = new SAXReader();
		
		try {
			
			Document doc = sr.read("src/main/java/ykse/TestAutomation/Interface/OWN/Common/resources/OwnApiTestData.xml");
			Element root = doc.getRootElement();
			Element elements = root.element(apiName);
			//Attribute attr = elements.attribute("description");
			Element element = (Element) elements.elements().get(Integer.parseInt(CaseId));
			for (int i = 0; i < element.elements().size(); i++) {
				
				if (((Element) element.elements().get(i)).attributeValue("name").equals(name)) {
					return  ((Element) element.elements().get(i)).attributeValue("value");
				}
				
			}
			
			//return element.elements().size()+"";
			//return ((Element) element.elements().get(1)).attributeValue("description");
			//return element1.elements().size()+"";
			//return element.elements().size()+"";
			//return element.attributeValue("description");
			//return attr.getText();
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		}
	
	
	public static String FindValueByName(String name) {
		
		SAXReader sr = new SAXReader();
		
		try {
			
			Document doc = sr.read("src/main/java/ykse/TestAutomation/Interface/OWN/Common/resources/OwnApiTestData.xml");
			Element root = doc.getRootElement();
			for (int i = 0; i < root.elements().size(); i++) {
				
				if (((Element) root.elements().get(i)).attributeValue("name").equals(name)) {
					return  ((Element) root.elements().get(i)).attributeValue("value");
				}
			}
			
			//return element.elements().size()+"";
			//return ((Element) element.elements().get(1)).attributeValue("description");
			//return element1.elements().size()+"";
			//return element.elements().size()+"";
			//return element.attributeValue("description");
			//return attr.getText();
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
			
		}
		
		return null;
		}
	
}
