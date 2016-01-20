package cn.edu.haust.yfy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 年度预算实体类
 * 
 * ID 主键
 * department 部门
 * budgetItem 项目
 * years 年份
 * totalMoney 金额
 * overage 余额
 * remark 备注
 * 
 * @author wangdesen
 * */

@Entity
@Table(name="budget_year",uniqueConstraints={
		@UniqueConstraint(columnNames = {"department_id","budgetItem_id","years"})
})
public class BudgetYearPOJO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer ID;
	
	//部门
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "department_id")
	private DepartmentPOJO department;
	
	//项目
	@OneToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name = "budgetItem_id")
	private BudgetItemPOJO budgetItem;
	
	//年份
	@Column(name = "years")
	private String years;
	
	//金额
	@Column(name = "totalmoney")
	private Double totalMoney;
	
	//余额
	@Column(name = "overage")
	private Double overage;
	
	//备注
	@Column(name = "remark")
	private String remark;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public DepartmentPOJO getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentPOJO department) {
		this.department = department;
	}

	public BudgetItemPOJO getBudgetItem() {
		return budgetItem;
	}

	public void setBudgetItem(BudgetItemPOJO budgetItem) {
		this.budgetItem = budgetItem;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Double getOverage() {
		return overage;
	}

	public void setOverage(Double overage) {
		this.overage = overage;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
