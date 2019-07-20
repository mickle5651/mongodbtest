package com.hisign.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

/**
 * 过人文档
 * @author zhouzhongshuai
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Document(collection = "passPerson1")
public class PassPersonEntity implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -7269196672048044315L;
	@JsonIgnore
	private ObjectId id;

	private String jobId;//1，黑名单比对作业编号
	private String jobStatus;//2，作业状态1:正常记录
	private Date passTime;//3，通过时间
	private String stationNo;//4，站点编号
	private String perCarId;//5，关联车辆编号
	private String deviceCode;//6，设备编号
	private String deviceIP;//7，设备IP,为适应mongodb库
	private String blackType;//8，黑名单类型 "大类：****;中类：****;小类：****"
	private String collectionType;//9，采集类型 1自动读取 2ocr读取 3手工录入
	private String verifyResult;//10，人证合一比对结果 1：比对通过，2比对不通过，3未比对
	private String passNo;//11，通道编号
	private String inOrOut;//12，进出方向：1——进城2——出城
	private String organizationCode;//13，单位组织机构代码
	private String organParentCode;//14，父单位组织机构代码
	private String stationAreaCode;//15，站点地区代码，组织机构代码前六位
	private Date createDate;//16，创建时间
	private String name;//17，姓名
	private String genderCode;//18，性别代码1，男，2，女
	private String nationCode;//19，民族代码
	private String nationality;//20，国籍
	private String birthday;//21生日yyyyMMdd字符串
	private Integer age;//22年龄（通过时）add 2017-07-06 增加age
	private String addr;//23住址
	private String cardNo;//24身份证号
	private String cardType;//25证件类型：1，身份证，2，护照 ，3，港澳通行证
	private String cardNoPrefix4;//26身份证号前四位
	private String cardNoPrefix6;//27身份证号前六位
	private String cardStartTime;//28身份证有效起始时间yyyyMMdd字符串
	private String cardEndTime;//29身份证有效结束时间yyyyMMdd字符串
	private String issuingUnit;//30发证机关
	private String hasFingerFea;//31是否有指纹特征：0 否  1是
	private String fingerFeature0;//32左手拇指指纹特征
	private String fingerFeature1;//33右手拇指指纹特征
	private String cardImgPath;//34证件照
	private String sceneImgPath;//35现场照
	private String faceImgPath;//36人脸照
	private String fingerImgPath;//37指纹图片
	private String faceCompareResult;//38人脸比对结果
	private Double faceQualityScore;//39人脸质量分数
	private Double faceCompareScore;//40人脸比对分数
	private String fingerCompareResult;//41指纹比对结果：1，通过，2，不通过，3，未比对
	private String fingerCompareFeatureId;//42比中指纹的手指：1，左手拇指，2，右手拇指
	private Double fingerQualityScore;//43指纹质量分数
	private Double fingerCompareScore;//44指纹比对分数
	private String hasTicket;//45是否有车票信息
	private String ticketNo;//46客票编号
	private String ticketType;//47车票类型：1 火车票 2客车票 3飞机票
	private String trainNo;//48航班号、车牌号或列车编号
	private String seat;//49座位号
	private Date goTime;//50出发时间
	private String goAddr;//51出发地点
	private String goAddrCode;//52起始地区代码，6位行政区划
	private Date arriveTime;//53到达时间
	private String arriveAddr;//54到达地点
	private String arriveAddrCode;//55到达地区代码，6位行政区划
	private Date checkInTime; //56入住时间/** 酒店信息 */
	private Date leaveTime; //57离店时间
	private String roomNum; //58房间号
	private String deviceType;//59采集数据来源1闸机，2手持，3无证人员
	
	private String oracleId;//oracle中的id
	private String carNo;
	private String extendInfo;
	private String checkpointCode;
	private String checkpointAddr;
	
	
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getDeviceCode() {
		return deviceCode;
	}
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getCollectionType() {
		return collectionType;
	}
	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}
	public String getVerifyResult() {
		return verifyResult;
	}
	public void setVerifyResult(String verifyResult) {
		this.verifyResult = verifyResult;
	}
	public String getBlackType() {
		return blackType;
	}
	public void setBlackType(String blackType) {
		this.blackType = blackType;
	}
	public String getCheckpointCode() {
		return checkpointCode;
	}
	public void setCheckpointCode(String checkpointCode) {
		this.checkpointCode = checkpointCode;
	}
	public String getInOrOut() {
		return inOrOut;
	}
	public void setInOrOut(String inOrOut) {
		this.inOrOut = inOrOut;
	}
	public String getPassNo() {
		return passNo;
	}
	public void setPassNo(String passNo) {
		this.passNo = passNo;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public Date getPassTime() {
		return passTime;
	}
	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}
	public String getCheckpointAddr() {
		return checkpointAddr;
	}
	public void setCheckpointAddr(String checkpointAddr) {
		this.checkpointAddr = checkpointAddr;
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
	public String getStationNo() {
		return stationNo;
	}
	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}
	public String getStationAreaCode() {
		return stationAreaCode;
	}
	public void setStationAreaCode(String stationAreaCode) {
		this.stationAreaCode = stationAreaCode;
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
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardStartTime() {
		return cardStartTime;
	}
	public void setCardStartTime(String cardStartTime) {
		this.cardStartTime = cardStartTime;
	}
	public String getCardEndTime() {
		return cardEndTime;
	}
	public void setCardEndTime(String cardEndTime) {
		this.cardEndTime = cardEndTime;
	}
	public String getIssuingUnit() {
		return issuingUnit;
	}
	public void setIssuingUnit(String issuingUnit) {
		this.issuingUnit = issuingUnit;
	}
	public String getHasFingerFea() {
		return hasFingerFea;
	}
	public void setHasFingerFea(String hasFingerFea) {
		this.hasFingerFea = hasFingerFea;
	}
	public String getFingerFeature0() {
		return fingerFeature0;
	}
	public void setFingerFeature0(String fingerFeature0) {
		this.fingerFeature0 = fingerFeature0;
	}
	public String getFingerFeature1() {
		return fingerFeature1;
	}
	public void setFingerFeature1(String fingerFeature1) {
		this.fingerFeature1 = fingerFeature1;
	}
	public String getCardNoPrefix4() {
		return cardNoPrefix4;
	}
	public void setCardNoPrefix4(String cardNoPrefix4) {
		this.cardNoPrefix4 = cardNoPrefix4;
	}
	public String getCardNoPrefix6() {
		return cardNoPrefix6;
	}
	public void setCardNoPrefix6(String cardNoPrefix6) {
		this.cardNoPrefix6 = cardNoPrefix6;
	}
	public String getCardImgPath() {
		return cardImgPath;
	}
	public void setCardImgPath(String cardImgPath) {
		this.cardImgPath = cardImgPath;
	}
	public String getSceneImgPath() {
		return sceneImgPath;
	}
	public void setSceneImgPath(String sceneImgPath) {
		this.sceneImgPath = sceneImgPath;
	}
	public String getFaceImgPath() {
		return faceImgPath;
	}
	public void setFaceImgPath(String faceImgPath) {
		this.faceImgPath = faceImgPath;
	}
	public String getFingerImgPath() {
		return fingerImgPath;
	}
	public void setFingerImgPath(String fingerImgPath) {
		this.fingerImgPath = fingerImgPath;
	}
	public String getFaceCompareResult() {
		return faceCompareResult;
	}
	public void setFaceCompareResult(String faceCompareResult) {
		this.faceCompareResult = faceCompareResult;
	}
	public Double getFaceQualityScore() {
		return faceQualityScore;
	}
	public void setFaceQualityScore(Double faceQualityScore) {
		this.faceQualityScore = faceQualityScore;
	}
	public Double getFaceCompareScore() {
		return faceCompareScore;
	}
	public void setFaceCompareScore(Double faceCompareScore) {
		this.faceCompareScore = faceCompareScore;
	}
	public String getFingerCompareResult() {
		return fingerCompareResult;
	}
	public void setFingerCompareResult(String fingerCompareResult) {
		this.fingerCompareResult = fingerCompareResult;
	}
	public String getFingerCompareFeatureId() {
		return fingerCompareFeatureId;
	}
	public void setFingerCompareFeatureId(String fingerCompareFeatureId) {
		this.fingerCompareFeatureId = fingerCompareFeatureId;
	}
	public Double getFingerQualityScore() {
		return fingerQualityScore;
	}
	public void setFingerQualityScore(Double fingerQualityScore) {
		this.fingerQualityScore = fingerQualityScore;
	}
	public Double getFingerCompareScore() {
		return fingerCompareScore;
	}
	public void setFingerCompareScore(Double fingerCompareScore) {
		this.fingerCompareScore = fingerCompareScore;
	}
	public String getPerCarId() {
		return perCarId;
	}
	public void setPerCarId(String perCarId) {
		this.perCarId = perCarId;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getHasTicket() {
		return hasTicket;
	}
	public void setHasTicket(String hasTicket) {
		this.hasTicket = hasTicket;
	}
	public String getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public Date getGoTime() {
		return goTime;
	}
	public void setGoTime(Date goTime) {
		this.goTime = goTime;
	}
	public String getGoAddr() {
		return goAddr;
	}
	public void setGoAddr(String goAddr) {
		this.goAddr = goAddr;
	}
	public String getGoAddrCode() {
		return goAddrCode;
	}
	public void setGoAddrCode(String goAddrCode) {
		this.goAddrCode = goAddrCode;
	}
	public Date getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getArriveAddr() {
		return arriveAddr;
	}
	public void setArriveAddr(String arriveAddr) {
		this.arriveAddr = arriveAddr;
	}
	public String getArriveAddrCode() {
		return arriveAddrCode;
	}
	public void setArriveAddrCode(String arriveAddrCode) {
		this.arriveAddrCode = arriveAddrCode;
	}
	public String getExtendInfo() {
		return extendInfo;
	}
	public void setExtendInfo(String extendInfo) {
		this.extendInfo = extendInfo;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getOracleId() {
		return oracleId;
	}
	public void setOracleId(String oracleId) {
		this.oracleId = oracleId;
	}
	public String getDeviceIP() {
		return deviceIP;
	}
	public void setDeviceIP(String deviceIP) {
		this.deviceIP = deviceIP;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getLeaveTime() {
		return leaveTime;
	}
	public void setLeaveTime(Date leaveTime) {
		this.leaveTime = leaveTime;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
