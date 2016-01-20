package cn.edu.haust.yfy.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * 预算支出表
 * 
 * ID 主键
 * department 部门
 * budgetItem 项目
 * createTime 创建时间
 * money 金额
 * remark 备注
 * 
 * @author wangdesen
 * */

@Entity
@Table(name="budget_expendses",uniqueConstraints={
		@UniqueConstraint(columnNames = {"department_id","budgetItem_id"})
})
public class BudgetExpendsesPOJO {

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
	
	//创建时间
	@Column(name="create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar createTime = Calendar.getInstance();
	
	//金额
	@Column(name = "money")
	private Double money;
		
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

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
