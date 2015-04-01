package com.mph.models.dtos;

public interface BundlesDto {
	public String getFlavorColumnHeader();
	public void setFlavorColumnHeader(String flavorColumnHeader);
	public String getDecoratorColumnHeader();
	public void setDecoratorColumnHeader(String decoratorColumnHeader);
	public String getNewButton();
	public void setNewButton(String newButton);
	public String getSystemAdministratorButton();
	public void setSystemAdministratorButton(String systemAdministratorButton);
	public String getTotalLabel();
	public void setTotalLabel(String totalLabel);
	public String getPosMainScreenTitle();
	public void setPosMainScreenTitle(String posMainScreenTitle);
	public String getPosSystemAdminScreenTitle();
	public void setPosSystemAdminScreenTitle(String posSystemAdminScreenTitle);
	public String getTableColumnNameId();
	public void setTableColumnNameId(String tableColumnNameId);
	public String getTableColumnNameName();
	public void setTableColumnNameName(String tableColumnNameName);
	public String getTableColumnNamePrice();
	public void setTableColumnNamePrice(String tableColumnNamePrice);
	public String getTableColumnNameType();
	public void setTableColumnNameType(String tableColumnNameType);
	
	public String getSysAdmNewButton();
	public void setSysAdmNewButton(String sysAdmNewButton);
	public String getSysAdmDeleteButton();
	public void setSysAdmDeleteButton(String sysAdmDeleteButton);
	public String getSysAdmGoBackToMainScreenButton();
	public void setSysAdmGoBackToMainScreenButton(String sysAdmGoBackToMainScreenButton);
}
