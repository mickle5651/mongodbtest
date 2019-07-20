/**
 * @author: Wu Xueheng
 * @date: 2017年7月1日-上午8:45:06
 */
package com.hisign.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 人员黑名单告警文档
 *
 * @author Wu Xueheng
 * @since 2017年7月1日
 */
@Document(collection = "personBlacklistAlarm")
public class PersonBlacklistAlarm {
	@JsonIgnore
	private ObjectId _id;
	private String jobId; // 任务ID
	private String name; // 姓名
	private String genderCode; // 性别代码：1——男 | 2——女
	private String nationCode; // 民族代码
	private String cardNo; // 身份证号
	private String address; // 人员住址
	private String blackType; // 黑名单类型
	private String minBlackType; // 黑名单类型-小类
	private String medBlackType; // 黑名单类型-中类
	private String maxBlackType; // 黑名单类型-大类
	private String ifPolitics; // 是否是重点监控人员（政法5类人）：1——是 | 0——不是
	private String politicsType; // 政法等级（包括1，2，3，4，5类，6,特殊群体，9其他，共7种类型） 100 逃犯
	private String lgjgdw; // 布控单位
	private String mjxm; // 民警姓名
	private String mjlxfs; // 民警联系方式
	private String djdw; // 监管单位
	private String bzczcs; // 处置措施
	private String leaveState; // 请假状态：1——已请假 | 0——未请假
	private String alarmStatus; // 报警状态：0——前后端不报警 | 1——前后端报警 | 2——后端报警前端不报警
	private String compareStatus; // 比对状态：0——正常比对 | 1——县内比对 | 2——跨县比对 | 3——布控比对
	private String ip; // 设备IP
	private String deviceCode; // 设备代码
	private String stationNo; // 站点编码
	private String stationType; // 站点类型
	private String organizationCode; // 组织机构代码
	private String organParentCode; // 组织机构父代码
	private String compareModel; // 比对模式：0——即时比对 | 1——二次校验
	private Date createDate; // 创建时间
	private String collectionType; // 采集类型
	private Date passTime; // 通过时间
	private String servIp; // 公安网前置IP
	private String remark; // 备注
	
	private String alarmId;
	
	/*人工处理*/
	private String disposeUserId; //处理用户的id
	private String disposeUserName; //处理用户的用户名
	private Date disposeTime; // 处理时间
	private String disposalMeasures; //处理理由（内容）
	private String disposeReason; // 处理理由
	private String hasDisposed; //处理状态【已处理、未处理】

	public String getDisposeReason() {
		return disposeReason;
	}

	public void setDisposeReason(String disposeReason) {
		this.disposeReason = disposeReason;
	}

	public String getDisposeUserId() {
		return disposeUserId;
	}

	public void setDisposeUserId(String disposeUserId) {
		this.disposeUserId = disposeUserId;
	}

	public String getDisposeUserName() {
		return disposeUserName;
	}

	public void setDisposeUserName(String disposeUserName) {
		this.disposeUserName = disposeUserName;
	}

	public Date getDisposeTime() {
		return disposeTime;
	}

	public void setDisposeTime(Date disposeTime) {
		this.disposeTime = disposeTime;
	}

	public String getDisposalMeasures() {
		return disposalMeasures;
	}

	public void setDisposalMeasures(String disposalMeasures) {
		this.disposalMeasures = disposalMeasures;
	}

	public String getHasDisposed() {
		return hasDisposed;
	}

	public void setHasDisposed(String hasDisposed) {
		this.hasDisposed = hasDisposed;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}

	public String getNationCode() {
		return nationCode;
	}

	public void setNationCode(String nationCode) {
		this.nationCode = nationCode;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlackType() {
		return blackType;
	}

	public void setBlackType(String blackType) {
		this.blackType = blackType;
	}

	public String getMinBlackType() {
		return minBlackType;
	}

	public void setMinBlackType(String minBlackType) {
		this.minBlackType = minBlackType;
	}

	public String getMedBlackType() {
		return medBlackType;
	}

	public void setMedBlackType(String medBlackType) {
		this.medBlackType = medBlackType;
	}

	public String getMaxBlackType() {
		return maxBlackType;
	}

	public void setMaxBlackType(String maxBlackType) {
		this.maxBlackType = maxBlackType;
	}

	public String getIfPolitics() {
		return ifPolitics;
	}

	public void setIfPolitics(String ifPolitics) {
		this.ifPolitics = ifPolitics;
	}

	public String getPoliticsType() {
		return politicsType;
	}

	public void setPoliticsType(String politicsType) {
		this.politicsType = politicsType;
	}

	public String getLgjgdw() {
		return lgjgdw;
	}

	public void setLgjgdw(String lgjgdw) {
		this.lgjgdw = lgjgdw;
	}

	public String getMjxm() {
		return mjxm;
	}

	public void setMjxm(String mjxm) {
		this.mjxm = mjxm;
	}

	public String getMjlxfs() {
		return mjlxfs;
	}

	public void setMjlxfs(String mjlxfs) {
		this.mjlxfs = mjlxfs;
	}

	public String getDjdw() {
		return djdw;
	}

	public void setDjdw(String djdw) {
		this.djdw = djdw;
	}

	public String getBzczcs() {
		return bzczcs;
	}

	public void setBzczcs(String bzczcs) {
		this.bzczcs = bzczcs;
	}

	public String getLeaveState() {
		return leaveState;
	}

	public void setLeaveState(String leaveState) {
		this.leaveState = leaveState;
	}

	public String getAlarmStatus() {
		return alarmStatus;
	}

	public void setAlarmStatus(String alarmStatus) {
		this.alarmStatus = alarmStatus;
	}

	public String getCompareStatus() {
		return compareStatus;
	}

	public void setCompareStatus(String compareStatus) {
		this.compareStatus = compareStatus;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getStationNo() {
		return stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOrganParentCode() {
		return organParentCode;
	}

	public void setOrganParentCode(String organParentCode) {
		this.organParentCode = organParentCode;
	}

	public String getCompareModel() {
		return compareModel;
	}

	public void setCompareModel(String compareModel) {
		this.compareModel = compareModel;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public Date getPassTime() {
		return passTime;
	}

	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}

	public String getServIp() {
		return servIp;
	}

	public void setServIp(String servIp) {
		this.servIp = servIp;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
		if(alarmId!=null){
			this._id = new ObjectId(alarmId);
		}
	}

	
	

}
