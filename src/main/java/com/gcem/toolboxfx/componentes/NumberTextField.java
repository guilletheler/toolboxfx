package com.gcem.toolboxfx.componentes;

import javafx.scene.control.TextField;

/**
 * Textfield implementation that accepts formatted number and stores them in a
 * BigDecimal property The user input is formatted when the focus is lost or the
 * user hits RETURN.
 *
 * @author Thomas Bolz
 */
public class NumberTextField extends TextField {
	
	private String mask;

	@Override
	public void replaceText(int start, int end, String text) {
		if (validate(text)) {
			super.replaceText(start, end, text);
		}
	}

	@Override
	public void replaceSelection(String text) {
		if (validate(text)) {
			super.replaceSelection(text);
		}
	}

	private boolean validate(String text) {
		return text.matches(this.getMask());
	}

	public String getMask() {
		if(mask == null) {
			mask = "[0-9]*";
		}
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}
	
}
