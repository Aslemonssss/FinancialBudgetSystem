package cn.edu.haust.yfy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 项目实体类
 * 
 * ID 主键
 * name 项目名称
 * code 项目编码
 * 
 * @author wangdesen
 * 
 * */

@Entity
@Table(name="budget_item",uniqueConstraints={
		@UniqueConstraint(columnNames = {"code"})
})
public class BudgetItemPOJO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer ID;
	
	
	//名称
	@Column(name="name",nullable = false)
	private String name;
	
	//编码
	@Column(name="code",nullable = false)
	private String code;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
