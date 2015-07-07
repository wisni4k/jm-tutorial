package com.acme.craft.fixme.solid.dependency.inversion;

import lombok.Data;

@Data
public class Lamp implements OnOff {

	private boolean on = false;

	@Override
	public void setOn(boolean b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setOff(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
