package book.chapter4;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] s = text.split("\\s");
		setValue(new FullName(s[0] , s[1]));
	}
}
