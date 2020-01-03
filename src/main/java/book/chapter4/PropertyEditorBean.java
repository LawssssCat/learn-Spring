package book.chapter4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.Setter;
import lombok.ToString;

@Setter
public class PropertyEditorBean {


	private byte[] bytes ; 				// ByteArrayPropertyEditor 
	private Character character; 		// CharacterEditor
	private Class cls ; 				// ClassEditor
	private Boolean trueOrFalse ; 		// CustomBooleanEditor
	private List<String> stringList; 	// CustomCollectionEditor
	private Date date ; 				// CustomDateEditor
	private Float floatValue; 			// CustomNumberEditor
	
	private File file ; 				// FileEditor
	private InputStream stream ; 		// InputStreamEditor
	private Locale locale ; 			// LocaleEditor
	private Pattern pattern  ; 			// PatternEditor 
	private Properties properties ;		// PropertiesEditor
	private String trimString; 			// StringTrimmerEditor
	private URL url ; 					// URLEditor
	

	public static class CustomPropertyEditorRegistrar 
	implements PropertyEditorRegistrar {

		@Override
		public void registerCustomEditors(PropertyEditorRegistry registry) {
			//注册日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			registry.registerCustomEditor(
					Date.class, new CustomDateEditor(sdf, true));
			
			//注册trimString
			registry.registerCustomEditor(
					String.class, new StringTrimmerEditor(true));
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		//确保有这个文件夹
		File file = File.createTempFile("test", "txt");
		System.out.println(file);
		file.deleteOnExit();
		
		//加载
		GenericXmlApplicationContext gcx = new GenericXmlApplicationContext();
		gcx.load("classpath:book/chapter4/app-config-01.xml");
		gcx.refresh(); 
		
		//获取
		PropertyEditorBean bean = gcx.getBean("builtInSample" , PropertyEditorBean.class);
		System.out.println(bean);
		
		//tips
		System.out.println("finish ... ");
	}


	@Override
	public String toString() {
		return "PropertyEditorBean [\n\tbytes=" + Arrays.toString(bytes) + ",\n\tcharacter=" + character + ",\n\tcls="
				+ cls + ",\n\ttrueOrFalse=" + trueOrFalse + ",\n\tstringList=" + stringList + ",\n\tdate=" + date
				+ ",\n\tfloatValue=" + floatValue + ",\n\tfile=" + file + ",\n\tstream=" + stream + ",\n\tlocale="
				+ locale + ",\n\tpattern=" + pattern + ",\n\tproperties=" + properties + ",\n\ttrimString=" + trimString
				+ ",\n\turl=" + url + "\n]";
	}
	
	
}
