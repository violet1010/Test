package ykse.TestAutomation.Interface.OWN.Common;

import ykse.TestAutomation.Interface.OWN.Common.TestData;
import ykse.TestAutomation.Interface.OWN.Common.InterfaceOwnReadResponse;

public class InterFaceOwnAssertion {
	
	
	public static Boolean assertBizCodeNew(String apiName, String caseId, String gatewayRequest){
		
		/*
		 * expect预期结果
		 * actual实际结果
		 * return:true
		 */
		
		String expect = TestData.FindValueByApiNameAndCaseId(apiName, "bizCode", caseId);
		String actual = InterfaceOwnReadResponse.bizCode(gatewayRequest);
		if (expect.equals(actual)){
			return true;
		}else{
			
			return false;
		}
				
	}
	
	public static Boolean assertBizCode(String bizCode, String gatewayRequest){
		
		/*
		 * expect预期结果
		 * actual实际结果
		 * return:true
		 */
		
		String expect = TestData.FindValueByName(bizCode);
		String actual = InterfaceOwnReadResponse.bizCode(gatewayRequest);
		if (expect.equals(actual)){
			return true;
		}else{
			
			return false;
		}
				
	}
	
	

}
