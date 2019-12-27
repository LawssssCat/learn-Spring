package book.chapter3.collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjuection {
	private Map<String, Object> map ; 
	private Properties props ; 
	private Set set ; 
	private List list ;
	
	
	public void displayInfo() {
		System.out.println("==========  map  ==============");
		map.entrySet().forEach(e -> System.out.println(
				"key:"+e.getKey()+" - "+"value:"+ e.getValue()));
		System.out.println("==========  props  ============");
		props.entrySet().forEach(e -> System.out.println(
				"key:"+e.getKey() + " - "+ "value:"+ e.getValue()));
		System.out.println("==========  set  ==============");
		set.forEach(o -> System.out.println("value:"+ o));
		System.out.println("==========  list  =============");
		list.forEach(o -> System.out.println("value:"+ o));
		
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Properties getProps() {
		return props;
	}
	public void setProps(Properties props) {
		this.props = props;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	
	
}
