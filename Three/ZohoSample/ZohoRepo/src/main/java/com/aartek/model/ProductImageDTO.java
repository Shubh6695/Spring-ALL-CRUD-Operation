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
@Table(name="product_image")
public class ProductImageDTO {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PRODUCT_IMAGE_ID")
	private Integer piid;
	
	@Column(name="PRODUCT_IMAGE_NAME")
	private String piname;
	
	@Column(name="PRODUCT_IMAGE_PATH")
	private String pipath;

	@Column(name="PRODUCT_ID")
	private Integer productid;

	
	public Integer getPiid() {
		return piid;
	}

	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	public String getPiname() {
		return piname;
	}

	public void setPiname(String piname) {
		this.piname = piname;
	}

	public String getPipath() {
		return pipath;
	}

	public void setPipath(String pipath) {
		this.pipath = pipath;
	}


	
}
