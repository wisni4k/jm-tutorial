package com.acme.craft.fixme.solid.dependency.inversion;

public class Switch {

	private OnOff lamp;
	private boolean pressed;

	public Switch(OnOff lamp) {
		this.lamp = lamp;
	}

	private void pressSwitch() {
		pressed = !pressed;
		if (pressed) {
			lamp.setOn(true);
		} else {
			lamp.setOn(false);
		}
	}
}
