package com.mph.models.dtos.impls;

import com.mph.models.dtos.BundlesDto;

public class BundlesDtoImpl implements BundlesDto{
	private String flavorColumnHeader;
	private String decoratorColumnHeader;
	private String newButton;
	private String systemAdministratorButton;
	private String totalLabel;
	private String posMainScreenTitle;
	private String posSystemAdminScreenTitle;
	private String tableColumnNameId;
	private String tableColumnNameName;
	private String tableColumnNamePrice;
	private String tableColumnNameType;
		
	private String sysAdmNewButton;
	private String sysAdmDeleteButton;
	private String sysAdmGoBackToMainScreenButton;

	
	public String getSysAdmNewButton() {
		return sysAdmNewButton;
	}
	public void setSysAdmNewButton(String sysAdmNewButton) {
		this.sysAdmNewButton = sysAdmNewButton;
	}
	public String getSysAdmDeleteButton() {
		return sysAdmDeleteButton;
	}
	public void setSysAdmDeleteButton(String sysAdmDeleteButton) {
		this.sysAdmDeleteButton = sysAdmDeleteButton;
	}
	public String getSysAdmGoBackToMainScreenButton() {
		return sysAdmGoBackToMainScreenButton;
	}
	public void setSysAdmGoBackToMainScreenButton(
			String sysAdmGoBackToMainScreenButton) {
		this.sysAdmGoBackToMainScreenButton = sysAdmGoBackToMainScreenButton;
	}
	public String getFlavorColumnHeader() {
		return flavorColumnHeader;
	}
	public void setFlavorColumnHeader(String flavorColumnHeader) {
		this.flavorColumnHeader = flavorColumnHeader;
	}
	public String getDecoratorColumnHeader() {
		return decoratorColumnHeader;
	}
	public void setDecoratorColumnHeader(String decoratorColumnHeader) {
		this.decoratorColumnHeader = decoratorColumnHeader;
	}
	public String getNewButton() {
		return newButton;
	}
	public void setNewButton(String newButton) {
		this.newButton = newButton;
	}
	public String getSystemAdministratorButton() {
		return systemAdministratorButton;
	}
	public void setSystemAdministratorButton(String systemAdministratorButton) {
		this.systemAdministratorButton = systemAdministratorButton;
	}
	public String getTotalLabel() {
		return totalLabel;
	}
	public void setTotalLabel(String totalLabel) {
		this.totalLabel = totalLabel;
	}
	
	
	public String getPosMainScreenTitle() {
		return posMainScreenTitle;
	}
	public void setPosMainScreenTitle(String posMainScreenTitle) {
		this.posMainScreenTitle = posMainScreenTitle;
	}
	public String getPosSystemAdminScreenTitle() {
		return posSystemAdminScreenTitle;
	}
	public void setPosSystemAdminScreenTitle(String posSystemAdminScreenTitle) {
		this.posSystemAdminScreenTitle = posSystemAdminScreenTitle;
	}
	public String getTableColumnNameId() {
		return tableColumnNameId;
	}
	public void setTableColumnNameId(String tableColumnNameId) {
		this.tableColumnNameId = tableColumnNameId;
	}
	public String getTableColumnNameName() {
		return tableColumnNameName;
	}
	public void setTableColumnNameName(String tableColumnNameName) {
		this.tableColumnNameName = tableColumnNameName;
	}
	public String getTableColumnNamePrice() {
		return tableColumnNamePrice;
	}
	public void setTableColumnNamePrice(String tableColumnNamePrice) {
		this.tableColumnNamePrice = tableColumnNamePrice;
	}
	public String getTableColumnNameType() {
		return tableColumnNameType;
	}
	public void setTableColumnNameType(String tableColumnNameType) {
		this.tableColumnNameType = tableColumnNameType;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BundlesDtoImpl [flavorColumnHeader=");
		builder.append(flavorColumnHeader);
		builder.append(", decoratorColumnHeader=");
		builder.append(decoratorColumnHeader);
		builder.append(", newButton=");
		builder.append(newButton);
		builder.append(", systemAdministratorButton=");
		builder.append(systemAdministratorButton);
		builder.append(", totalLabel=");
		builder.append(totalLabel);
		builder.append(", posMainScreenTitle=");
		builder.append(posMainScreenTitle);
		builder.append(", posSystemAdminScreenTitle=");
		builder.append(posSystemAdminScreenTitle);
		builder.append(", tableColumnNameId=");
		builder.append(tableColumnNameId);
		builder.append(", tableColumnNameName=");
		builder.append(tableColumnNameName);
		builder.append(", tableColumnNamePrice=");
		builder.append(tableColumnNamePrice);
		builder.append(", tableColumnNameType=");
		builder.append(tableColumnNameType);
		builder.append(", sysAdmNewButton=");
		builder.append(sysAdmNewButton);
		builder.append(", sysAdmDeleteButton=");
		builder.append(sysAdmDeleteButton);
		builder.append(", sysAdmGoBackToMainScreenButton=");
		builder.append(sysAdmGoBackToMainScreenButton);
		builder.append("]");
		return builder.toString();
	}

	
	
}
