package com.xw.supercar.entity;

import java.util.Date;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 *维修工单
 * </p>
 * 
 * @author wangsz
 * @date 2017-07-22 17:21:37
 */
@Setter
@Getter
@ToString @AllArgsConstructor @NoArgsConstructor
public class RepairWorkorder extends BaseDateEntity {
		
	   	/** 维修工单号 */
    	private String workorderNo;
		
	   	/** 工单状态。0-待派工，1-已派工 */
    	private String workorderState;
		
	   	/** 修理性质，数据字典外键 */
    	private String repairTypeLK;
		
	   	/** 结算金额 */
    	private BigDecimal sum;
		
	   	/** 服务顾问，用户表外键 */
    	private String clerk;
		
	   	/** 客户id，外键 */
    	private String clientId;
		
	   	/** 车进店里程 */
    	private Integer carMileage;
		
	   	/** 车进店油表 */
    	private String carOilmeter;
		
	   	/** 客户提醒 */
    	private String clentRemind;
		
	   	/** 送修人名称 */
    	private String sendMan;
		
	   	/** 送修时间 */
    	private Date sendTime;
		
	   	/** 交车时间 */
    	private Date endTime;
    	
    	/** 公司id */
    	private String company;
		
	public static enum DP {
		id, workorderNo, workorderState, repairTypeLK, sum, clerk, clientId, carMileage, carOilmeter, clentRemind, sendMan, sendTime, endTime, company;	
	}
}