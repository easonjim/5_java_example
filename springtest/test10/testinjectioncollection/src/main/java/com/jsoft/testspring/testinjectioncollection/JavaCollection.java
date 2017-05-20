package com.jsoft.testspring.testinjectioncollection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollection {
	   private List addressList;
	   private Set  addressSet;
	   private Map  addressMap;
	   private Properties addressProp;

	   public void setAddressList(List addressList) {
	      this.addressList = addressList;
	   }
	   
	   public List getAddressList() {
	      System.out.println("List :"  + addressList);
	      return addressList;
	   }
	   
	   public void setAddressSet(Set addressSet) {
	      this.addressSet = addressSet;
	   }
	   
	   public Set getAddressSet() {
	      System.out.println("Set :"  + addressSet);
	      return addressSet;
	   }
	   
	   public void setAddressMap(Map addressMap) {
	      this.addressMap = addressMap;
	   }
	   
	   public Map getAddressMap() {
	      System.out.println("Map :"  + addressMap);
	      return addressMap;
	   }
	   
	   public void setAddressProp(Properties addressProp) {
	      this.addressProp = addressProp;
	   }
	   
	   public Properties getAddressProp() {
	      System.out.println("Property :"  + addressProp);
	      return addressProp;
	   }
}
