package spring5.chapter3.beanfactory;

public class BookwormOracle implements Oracle{
	//TODO 里面啥没写
	private Encyclopedia encyclopedia ; 
	
	public void setEncyclopedia(Encyclopedia encyclopedia) {
		this.encyclopedia = encyclopedia;
	}

	@Override
	public String defineMeaningOfLife() {
		//翻译：百科全书是浪费钱的东西，去看看这个世界？？？
		return "Encyclopedias are a waste of money - go see the world instead";
	}

}
