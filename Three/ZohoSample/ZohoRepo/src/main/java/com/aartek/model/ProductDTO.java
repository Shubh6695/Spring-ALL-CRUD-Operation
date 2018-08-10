package com.aartek.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductDTO {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="P_ID")
	private Integer pid;

	
	@Column(name="P_NAME")
	private String pname;

	
	@Column(name="P_DESCRIPTION")
	private String pdescription;

	
	@Column(name="P_PRICE")
	private Double pprice;

	@OneToMany(targetEntity=ProductDTO.class, cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID", referencedColumnName="P_ID")
	private List<ProductImageDTO> proimage;	
	
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdescription() {
		return pdescription;
	}

	public void setPdescription(String pdescription) {
		this.pdescription = pdescription;
	}

	public Double getPprice() {
		return pprice;
	}

	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}

	public List<ProductImageDTO> getProimage() {
		return proimage;
	}

	public void setProimage(List<ProductImageDTO> proimage) {
		this.proimage = proimage;
	}

	
}
