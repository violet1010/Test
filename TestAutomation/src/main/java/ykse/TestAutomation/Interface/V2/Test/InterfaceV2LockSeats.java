package ykse.TestAutomation.Interface.V2.Test;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import ykse.TestAutomation.Common.Log;
import ykse.TestAutomation.Interface.V2.Common.CommonUntil;
import ykse.TestAutomation.Interface.V2.Common.InterFaceV2Assertion;
import ykse.TestAutomation.Interface.V2.Common.InterFaceV2Data;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: zilan.dzl
 * Date: 16-7-25
 * Time: 上午10:07
 * To change this template use File | Settings | File Templates.
 */
public class InterfaceV2LockSeats {
    Logger logger = new Log("interface_v2").logger;

    @BeforeClass
    public static void setUp() throws Exception {

    }

    @AfterClass
    public static void tearDown() throws Exception {
        // driver.close();
    }

    @BeforeMethod(alwaysRun = true)
    public void BeforeCase() throws Exception {

        logger.warn("****开始执行用例****");
    }

    @AfterMethod(alwaysRun = true)
    public void AfterCase() throws Exception {
        logger.warn("****用例执行结束****");

    }

    @Test(groups={"P0"})
    public void TC_seat_lockSeats() throws InterruptedException {
        boolean result = false;
        logger.info("[步骤_1]. 查询影院列表  cinema_getCinemas");
        String res_cinema_getCinemas = InterFaceV2Data.cinema_getCinemas();
        logger.info("[步骤_2]. 查询排期列表_所有参数  schedule_getSchedules");
        Boolean starDate=true;
        Boolean endDate=true;
        String cinemaLinkId = CommonUntil.getcinemaLinkId(res_cinema_getCinemas);
        String res_schedule_getSchedules = InterFaceV2Data.schedule_getSchedules(cinemaLinkId,starDate,endDate);

        logger.info("[步骤_3]. 查询影厅座位  seat_getSeats");

        ArrayList<JSONObject> schedules = CommonUntil.getschedule(res_schedule_getSchedules, 2);
        Assert.assertTrue(schedules.size() > 0);
        JSONObject object=schedules.get(0);
        String res_seat_getSeats = InterFaceV2Data.seat_getSeats(object);
        ArrayList seatIdList = CommonUntil.getseatIdList(res_seat_getSeats);

        logger.info("[步骤_4]. 锁定有效座位  seat_lockSeats");
        String res = InterFaceV2Data.seat_lockSeats(object,seatIdList);
        result = InterFaceV2Assertion.TA_seat_lockSeats(res);
        Assert.assertEquals(result, true);

        logger.info("[步骤_5]. 释放座位  seat_releaseSeats");
        String lockOrderId = CommonUntil.getlockOrderId(res);
        String res1 = InterFaceV2Data.seat_releaseSeats(object,lockOrderId);
        result = InterFaceV2Assertion.TA_seat_lockSeats(res1);
        Assert.assertEquals(result, true);

        logger.info("[步骤_5]. 锁定无效座位  seat_lockSeats");
        String invalidRes = InterFaceV2Data.seat_lockSeats(object,seatIdList);
        result = InterFaceV2Assertion.TA_seat_lockSeats(res);
        Assert.assertEquals(result, false);

        logger.info("[步骤_6]. 锁定6座位  seat_lockSeats");
        ArrayList seat6 = CommonUntil.getseatIdList(res_seat_getSeats,6);
        String res6= InterFaceV2Data.seat_lockSeats(object,seat6);
        result=InterFaceV2Assertion.TA_seat_lockSeats(res6);
        Assert.assertEquals(result,true);

        logger.info("[步骤_5]. 释放座位  seat_releaseSeats");
        String lockOrderId2 = CommonUntil.getlockOrderId(res6);
        String res2 = InterFaceV2Data.seat_releaseSeats(object,lockOrderId);
        result = InterFaceV2Assertion.TA_seat_lockSeats(res2);
        Assert.assertEquals(result, true);

        logger.info("[步骤_7]. 锁定7座位  seat_lockSeats");
        ArrayList seat7 = CommonUntil.getseatIdList(res_seat_getSeats,7);
        String res7= InterFaceV2Data.seat_lockSeats(object,seat7);
        result=InterFaceV2Assertion.TA_seat_lockSeats(res7);
        Assert.assertEquals(result,false);

        logger.info("[步骤_8]. 跨排期锁座  seat_lockSeats");
        ArrayList seat8 = CommonUntil.getseatIdList(res_seat_getSeats,2);
        JSONObject object2=schedules.get(1);
        String res8= InterFaceV2Data.seat_lockSeats(object2,seat8);
        result=InterFaceV2Assertion.TA_seat_lockSeats(res8);
        Assert.assertEquals(result,false);


    }
}
