package book.chapter4;

import java.io.File;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBean {

	private File file ; 
	private String filePath ;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	} 
	
	
	
	public static void main(String[] args) {
		GenericXmlApplicationContext gtx = 
				new GenericXmlApplicationContext();
		gtx.load("classpath:book/chapter4/app-context-xml.xml");
		gtx.refresh();
		
		DestructiveBean destructiveBean = 
				gtx.getBean("destructiveBean" ,DestructiveBean.class );
		
		System.out.println(destructiveBean.getFilePath());
	}
	
}
