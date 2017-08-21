package com.zsh.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "COMPANY_BASIC")
public class CompanyBasic{

    /**
     * 企业名称
     */
    @Length(max=100,message="名称小于100个字符")
	@NotBlank(message="名称不能为空")
    private String name;

    /**
     * 统一社会信用代码
     */
    @Pattern(regexp="^[A-Za-z0-9-]+$",message="统一社会信用代码是英文或数字组成")
    @Length(max=50,message="统一社会信用代码长度最大不超过50个字符")
    @Column(name = "UNIFORM_SOCIAL_CREDIT_CODE")
    private String uniformSocialCreditCode;

    /**
     * 组织机构代码
     */
    @Pattern(regexp="^[A-Za-z0-9-]+$",message="统一社会信用代码是英文或数字组成")
    @Length(max=45,message="组织机构代码长度最大不超过45个字符")
    @Column(name = "ORG_INST_CODE")
    private String orgInstCode;

    /**
     * 行政区划代码
     */
    @Length(max=50,message="行政区划代码长度最大不超过50个字符")
    @NotBlank(message="行政区划代码不能为空")
    private String districtCode;

	@Length(max=100,message="行政区划代码名称长度最大不超过100个字符")
	@NotBlank(message="行政区划代码不能为空")
	@Column(name = "DISTRICT_NAME")
    private String districtName;
	
	/**
     * 市级编码冗余字段
     */
    @Column(name = "CITY_CODE")
    private String cityCode;
    
    /**
     * 区县编码冗余字段
     */
    @Column(name = "COUNTY_CODE")
    private String countyCode;
    
    /**
     * 法定代表人
     */
    @Length(max=50,message="法定代表人长度最大不超过50个字符")
    @Column(name = "LEGAL_PERSON")
    private String legalPerson;

    /**
     * 联系电话
     */
    @Pattern(regexp="^[0-9-]*$",message="电话号码不能带特殊符号")
    @Length(max=100,message="法定代表人联系电话长度最大不超过100个字符")
    @Column(name = "PRINCIPAL_PHONE")
    private String principalPhone;

    /**
     * 主要负责人
     */
    @Length(max=50,message="主要负责人长度最大不超过50个字符")
    @Column(name = "PERSON_IN_CHARGE")
    private String personInCharge;

    /**
     * 主要负责人固定电话号码
     */
    @Pattern(regexp="^[0-9-]*$",message="电话号码不能带特殊符号")
    @Length(max=100,message="主要负责人固定电话号码长度最大不超过100个字符")
    @Column(name = "PIC_TEL")
    private String picTel;

    /**
     * （通讯地址）生产/经营地址
     */
    @Length(max=300,message="（通讯地址）生产/经营地址长度最大不超过300个字符")
    @Column(name = "PRODUCTION_ADDRESS")
    private String productionAddress;

    /**
     * 行业类别代码（国标）,国家行业分类，关联CODE_INDUSTRY_CATEGORY_C
     */
    @Length(max=45,message="行业类别代码（国标）编码长度最大不超过45个字符")
    @Column(name = "INDUSTRY_CATEGORY_C_CODE")
    private String industryCategoryCCode;

    @Length(max=45,message="行业类别代码（国标）名称长度最大不超过45个字符")
    @Column(name = "INDUSTRY_CATEGORY_C_NAME")
    private String industryCategoryCName;

    /**
     * 所属省行业-安监行业分类，关联CODE_INDUSTRY_CATEGORY_P二级编码
     */
    @Pattern(regexp="^[A-Za-z0-9- ]+$",message="行业类别代码英文或数字组成,由-分割")
    @Length(max=45,message="所属省行业-安监行业分类编码长度最大不超过45个字符")
    @Column(name = "INDUSTRY_CATEGORY_P_CODE")
    private String industryCategoryPCode;

    @Length(max=45,message="所属省行业-安监行业分类名称长度最大不超过45个字符")
    @Column(name = "INDUSTRY_CATEGORY_P_NAME")
    private String industryCategoryPName;

    /**
     * 经营范围
     */
    @Length(max=30,message="经营范围长度最大不超过30个字符")
    @Column(name = "MANAGE_AREA")
    private String manageArea;

    /**
     * 注册资金(万元)
     */
    @Digits(integer=10, fraction=2,message="注册资金(万元)超长")
    @Column(name = "REGISTER_FUND")
    private BigDecimal registerFund;

    /**
     * 年销售收入(万元)
     */
    @Digits(integer=10, fraction=2,message="年销售收入(万元)超长")
    @Column(name = "SALE_INCOME")
    private BigDecimal saleIncome;

    /**
     * 占地面积(㎡)
     */
    @Digits(integer=10, fraction=2,message="占地面积(㎡)超长")
    @Column(name = "AREA")
    private BigDecimal area;

    /**
     * 从业人员数量
     */
    @Column(name = "STAFF_QUANTITY")
    @Max(value=32767,message="从业人员数量超长")
    @Min(value=0,message="从业人员数量是正整数")
    private Integer staffQuantity;

    /**
     * 营业执照类别：关联CODE_LICENSE_CATEGORY
     */
    @Length(max=30,message="营业执照类别编码长度最大不超过30个字符")
    @Column(name = "LICENSE_CATEGORY_CODE")
    private String licenseCategoryCode;

    @Length(max=30,message="营业执照类别名称长度最大不超过30个字符")
    @Column(name = "LICENSE_CATEGORY_NAME")
    private String licenseCategoryName;

    /**
     * 1：规模以上；0：规模以下
     */
    @Column(name = "SCALE")
    private Byte scale;

    /**
     * 安全类别
     */
    @Length(max=45,message="安全类别长度最大不超过45个字符")
    @Column(name = "SAFETY_CATEGORY")
    private String safetyCategory;
    
    /**
     * 结构类型
     */
    @Length(max=45,message="结构类型长度最大不超过45个字符")
    @Column(name = "STRUCTURE_TYPE")
    private String structureType;
    
    /**
     * 经纬度坐标点
     */
    @Length(max=45,message="经纬度长度最大不超过45个字符")
    @Column(name = "POINT")
    private String point;

    /**
     * 标准化等级：关联CODE_SAFTY_CATEGORY
     */
    @Length(max=30,message="标准化等级编码长度最大不超过30个字符")
    @Column(name = "WSS_LEVEL_CODE")
    private String wssLevelCode;

    @Length(max=30,message="标准化等级名称长度最大不超过30个字符")
    @Column(name = "WSS_LEVEL_NAME")
    private String wssLevelName;

    /**
     * 诚信等级:关联CODE_CREDIT_LEVEL
     */
    @Length(max=30,message="诚信等级编码长度最大不超过30个字符")
    @Column(name = "INTEGRITY_LEVEL_CODE")
    private String integrityLevelCode;

    @Length(max=30,message="诚信等级名称长度最大不超过30个字符")
    @Column(name = "INTEGRITY_LEVEL_NAME")
    private String integrityLevelName;

    /**
     * 注册登记类型,关联CODE_ECONOMY_TYPE
     */
    @Length(max=30,message="注册登记类型编码长度最大不超过30个字符")
    @Column(name = "ECONOMY_TYPE_CODE")
    private String economyTypeCode;

    /**
     * 注册登记类型名称冗余字段
     */
    @Length(max=30,message="注册登记类型名称长度最大不超过30个字符")
    @Column(name = "ECONOMY_TYPE_NAME")
    private String economyTypeName;

 /**
  * 所属网络编码
  */
 @Length(max=30,message="所属网络长度最大不超过45个字符")
 @Column(name = "GRID_CODE")
 private String gridCode;
    
    /**
     * 所属网络
     */
    @Length(max=30,message="所属网络长度最大不超过30个字符")
    @Column(name = "GRID")
    private String grid;

    /**
     * 集团公司名称
     */
    @Length(max=45,message="集团公司名称长度最大不超过45个字符")
    @Column(name = "GROUP_ORG_NAME")
    private String groupOrgName;
    
 
    /**
     * 最高风险点等级,由风险点回写
     */
    @Column(name = "TOP_RISK_SITE_LEVEL")
    private Byte topRiskSiteLevel;
    
    @Column(name="FOCUS")
    private Byte focus;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public Byte getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Byte isEffective) {
        this.isEffective = isEffective;
    }

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    public Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    public Date updateTime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_USER")
    public Integer createUser;

    /**
     * 更新人
     */
    @Column(name = "UPDATE_USER")
    public Integer updateUser;

    /**
     * 状态(1为有效，0为无效)
     */
    @Column(name = "IS_EFFECTIVE")
    public Byte isEffective;
    
    
    
    
    /**
     * 获取企业名称
     *
     * @return NAME - 企业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置企业名称
     *
     * @param name 企业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return UNIFORM_SOCIAL_CREDIT_CODE - 统一社会信用代码
     */
    public String getUniformSocialCreditCode() {
        return uniformSocialCreditCode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniformSocialCreditCode 统一社会信用代码
     */
    public void setUniformSocialCreditCode(String uniformSocialCreditCode) {
        this.uniformSocialCreditCode = uniformSocialCreditCode;
    }

    /**
     * 获取行政区划代码
     *
     * @return DISTRICT_CODE - 行政区划代码
     */
    public String getDistrictCode() {
        return districtCode;
    }

    /**
     * 设置行政区划代码
     *
     * @param districtCode 行政区划代码
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * @return DISTRICT_NAME
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * @param districtName
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * 获取法定代表人
     *
     * @return LEGAL_PERSON - 法定代表人
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法定代表人
     *
     * @param legalPerson 法定代表人
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取联系电话
     *
     * @return PRINCIPAL_PHONE - 联系电话
     */
    public String getPrincipalPhone() {
        return principalPhone;
    }

    /**
     * 设置联系电话
     *
     * @param principalPhone 联系电话
     */
    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone;
    }

    /**
     * 获取主要负责人
     *
     * @return PERSON_IN_CHARGE - 主要负责人
     */
    public String getPersonInCharge() {
        return personInCharge;
    }

    /**
     * 设置主要负责人
     *
     * @param personInCharge 主要负责人
     */
    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    /**
     * 获取主要负责人固定电话号码
     *
     * @return PIC_TEL - 主要负责人固定电话号码
     */
    public String getPicTel() {
        return picTel;
    }

    /**
     * 设置主要负责人固定电话号码
     *
     * @param picTel 主要负责人固定电话号码
     */
    public void setPicTel(String picTel) {
        this.picTel = picTel;
    }

    /**
     * 获取（通讯地址）生产/经营地址
     *
     * @return PRODUCTION_ADDRESS - （通讯地址）生产/经营地址
     */
    public String getProductionAddress() {
        return productionAddress;
    }

    /**
     * 设置（通讯地址）生产/经营地址
     *
     * @param productionAddress （通讯地址）生产/经营地址
     */
    public void setProductionAddress(String productionAddress) {
        this.productionAddress = productionAddress;
    }

    /**
     * 获取行业类别代码（国）
     *
     * @return INDUSTRY_CATEGORY_C_CODE - 行业类别代码（国）
     */
    public String getIndustryCategoryCCode() {
        return industryCategoryCCode;
    }

    /**
     * 设置行业类别代码（国）
     *
     * @param industryCategoryCCode 行业类别代码（国）
     */
    public void setIndustryCategoryCCode(String industryCategoryCCode) {
        this.industryCategoryCCode = industryCategoryCCode;
    }

    /**
     * @return INDUSTRY_CATEGORY_C_NAME
     */
    public String getIndustryCategoryCName() {
        return industryCategoryCName;
    }

    /**
     * @param industryCategoryCName
     */
    public void setIndustryCategoryCName(String industryCategoryCName) {
        this.industryCategoryCName = industryCategoryCName;
    }

    /**
     * 获取所属省行业-安监行业分类
     *
     * @return INDUSTRY_CATEGORY_P_CODE - 所属省行业-安监行业分类
     */
    public String getIndustryCategoryPCode() {
        return industryCategoryPCode;
    }

    /**
     * 设置所属省行业-安监行业分类
     *
     * @param industryCategoryPCode 所属省行业-安监行业分类
     */
    public void setIndustryCategoryPCode(String industryCategoryPCode) {
        this.industryCategoryPCode = industryCategoryPCode;
    }

    /**
     * @return INDUSTRY_CATEGORY_P_NAME
     */
    public String getIndustryCategoryPName() {
        return industryCategoryPName;
    }

    /**
     * @param industryCategoryPName
     */
    public void setIndustryCategoryPName(String industryCategoryPName) {
        this.industryCategoryPName = industryCategoryPName;
    }

    /**
     * 获取经营范围
     *
     * @return MANAGE_AREA - 经营范围
     */
    public String getManageArea() {
        return manageArea;
    }

    /**
     * 设置经营范围
     *
     * @param manageArea 经营范围
     */
    public void setManageArea(String manageArea) {
        this.manageArea = manageArea;
    }

    /**
     * 获取注册资金(万元)
     *
     * @return REGISTER_FUND - 注册资金(万元)
     */
    public BigDecimal getRegisterFund() {
        return registerFund;
    }

    /**
     * 设置注册资金(万元)
     *
     * @param registerFund 注册资金(万元)
     */
    public void setRegisterFund(BigDecimal registerFund) {
        this.registerFund = registerFund;
    }

    /**
     * 获取年销售收入(万元)
     *
     * @return SALE_INCOME - 年销售收入(万元)
     */
    public BigDecimal getSaleIncome() {
        return saleIncome;
    }

    /**
     * 设置年销售收入(万元)
     *
     * @param saleIncome 年销售收入(万元)
     */
    public void setSaleIncome(BigDecimal saleIncome) {
        this.saleIncome = saleIncome;
    }

    /**
     * 获取占地面积(㎡)
     *
     * @return AREA - 占地面积(㎡)
     */
    public BigDecimal getArea() {
        return area;
    }

    /**
     * 设置占地面积(㎡)
     *
     * @param area 占地面积(㎡)
     */
    public void setArea(BigDecimal area) {
        this.area = area;
    }

    /**
     * 获取从业人员数量
     *
     * @return STAFF_QUANTITY - 从业人员数量
     */
    public Integer getStaffQuantity() {
        return staffQuantity;
    }

    /**
     * 设置从业人员数量
     *
     * @param staffQuantity 从业人员数量
     */
    public void setStaffQuantity(Integer staffQuantity) {
        this.staffQuantity = staffQuantity;
    }

    /**
     * 获取营业执照类别：企业法人，个体工商户营业执照，其他
     *
     * @return LICENSE_CATEGORY_CODE - 营业执照类别：企业法人，个体工商户营业执照，其他
     */
    public String getLicenseCategoryCode() {
        return licenseCategoryCode;
    }

    /**
     * 设置营业执照类别：企业法人，个体工商户营业执照，其他
     *
     * @param licenseCategoryCode 营业执照类别：企业法人，个体工商户营业执照，其他
     */
    public void setLicenseCategoryCode(String licenseCategoryCode) {
        this.licenseCategoryCode = licenseCategoryCode;
    }

    /**
     * @return LICENSE_CATEGORY_NAME
     */
    public String getLicenseCategoryName() {
        return licenseCategoryName;
    }

    /**
     * @param licenseCategoryName
     */
    public void setLicenseCategoryName(String licenseCategoryName) {
        this.licenseCategoryName = licenseCategoryName;
    }

    /**
     * 获取1：规模以上；0：规模以下
     *
     * @return SCALE - 1：规模以上；0：规模以下
     */
    public Byte getScale() {
        return scale;
    }

    /**
     * 设置1：规模以上；0：规模以下
     *
     * @param scale 1：规模以上；0：规模以下
     */
    public void setScale(Byte scale) {
        this.scale = scale;
    }

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

    /**
     * 获取标准化等级：一级、二级、三级、规范化企业、未定级
     *
     * @return WSS_LEVEL_CODE - 标准化等级：一级、二级、三级、规范化企业、未定级
     */
    public String getWssLevelCode() {
        return wssLevelCode;
    }

    /**
     * 设置标准化等级：一级、二级、三级、规范化企业、未定级
     *
     * @param wssLevelCode 标准化等级：一级、二级、三级、规范化企业、未定级
     */
    public void setWssLevelCode(String wssLevelCode) {
        this.wssLevelCode = wssLevelCode;
    }

    /**
     * @return WSS_LEVEL_NAME
     */
    public String getWssLevelName() {
        return wssLevelName;
    }

    /**
     * @param wssLevelName
     */
    public void setWssLevelName(String wssLevelName) {
        this.wssLevelName = wssLevelName;
    }

    /**
     * 获取诚信等级:A,B,C,D,未定级
     *
     * @return INTEGRITY_LEVEL_CODE - 诚信等级:A,B,C,D,未定级
     */
    public String getIntegrityLevelCode() {
        return integrityLevelCode;
    }

    /**
     * 设置诚信等级:A,B,C,D,未定级
     *
     * @param integrityLevelCode 诚信等级:A,B,C,D,未定级
     */
    public void setIntegrityLevelCode(String integrityLevelCode) {
        this.integrityLevelCode = integrityLevelCode;
    }

    /**
     * @return INTEGRITY_LEVEL_NAME
     */
    public String getIntegrityLevelName() {
        return integrityLevelName;
    }

    /**
     * @param integrityLevelName
     */
    public void setIntegrityLevelName(String integrityLevelName) {
        this.integrityLevelName = integrityLevelName;
    }

    public String getEconomyTypeCode() {
		return economyTypeCode;
	}

	public void setEconomyTypeCode(String economyTypeCode) {
		this.economyTypeCode = economyTypeCode;
	}

	public String getEconomyTypeName() {
		return economyTypeName;
	}

	public void setEconomyTypeName(String economyTypeName) {
		this.economyTypeName = economyTypeName;
	}

	public String getGroupOrgName() {
		return groupOrgName;
	}

	public void setGroupOrgName(String groupOrgName) {
		this.groupOrgName = groupOrgName;
	}

	/**
     * 获取所属网络

     *
     * @return GRID - 所属网络

     */
    public String getGrid() {
        return grid;
    }

    /**
     * 设置所属网络

     *
     * @param grid 所属网络

     */
    public void setGrid(String grid) {
        this.grid = grid;
    }

 public String getGridCode() {
  return gridCode;
 }

 public void setGridCode(String gridCode) {
  this.gridCode = gridCode;
 }

 public Byte getTopRiskSiteLevel() {
		return topRiskSiteLevel;
	}

	public void setTopRiskSiteLevel(Byte topRiskSiteLevel) {
		this.topRiskSiteLevel = topRiskSiteLevel;
	}

	public String getOrgInstCode() {
		return orgInstCode;
	}

	public void setOrgInstCode(String orgInstCode) {
		this.orgInstCode = orgInstCode;
	}

	public Byte getFocus() {
		return focus;
	}

	public void setFocus(Byte focus) {
		this.focus = focus;
	}

	public String getSafetyCategory() {
		return safetyCategory;
	}

	public void setSafetyCategory(String safetyCategory) {
		this.safetyCategory = safetyCategory;
	}

	public String getStructureType() {
		return structureType;
	}

	public void setStructureType(String structureType) {
		this.structureType = structureType;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

}