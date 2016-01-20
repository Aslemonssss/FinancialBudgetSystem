package cn.edu.haust.yfy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 部门实体类
 * 
 * ID 主键
 * name 部门名称
 * code 部门编码
 * status 部门状态 0-禁用，1-启用
 * 
 * @author wangdesen
 * 
 * */

@Entity
@Table(name="department",uniqueConstraints={
		@UniqueConstraint(columnNames = {"code"})
})
public class DepartmentPOJO {

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
	
	//状态
	@Column(name="status",nullable = false, columnDefinition="INT default 0")
	private Integer status;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
}

