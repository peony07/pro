package com.sc.pro.apiimpl.modelname;

import com.sc.pro.api.modelname.RegistrySrv;

public class RegistrySrvImpl implements RegistrySrv {

	@Override
	public String getName(String name) {
		return "this is the server result getName="+name;
	}
	
	public String getValue(String value) {
		return "this is the server result getValue="+value;
	}

}
