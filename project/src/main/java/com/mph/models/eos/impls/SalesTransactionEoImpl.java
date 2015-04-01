package com.mph.models.eos.impls;

import java.util.Date;

import com.mph.models.eos.SalesTransactionEo;
import com.mph.models.vos.IcecreamVo;

public class SalesTransactionEoImpl implements SalesTransactionEo {
	private Integer id;
	private IcecreamVo icecream;
	private Date datetime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public IcecreamVo getIcecream() {
		return icecream;
	}
	public void setIcecream(IcecreamVo icecream) {
		this.icecream = icecream;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SalesTransactionEoImpl [id=");
		builder.append(id);
		builder.append(", icecream=");
		builder.append(icecream);
		builder.append(", datetime=");
		builder.append(datetime);
		builder.append("]");
		return builder.toString();
	}
	
}
