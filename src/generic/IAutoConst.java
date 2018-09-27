package generic;

public interface IAutoConst {
	//all global var r initialized
	//public static final by default
	public static final String CHROME_KEY="webdriver.chrome.driver";
	//public- access everywhere, static-wants to use in static block, final so that value will not be changed
	public static final String CHROME_VALUE="./driver/chromedriver.exe";
	public static final String GECKO_KEY="webdriver.gecko.driver";
	public static final String GECKO_VALUE="./driver/geckodriver.exe";
	String CONFIG_PATH="./config.properties";
	String SUMMARY_PATH="./result/Summary.xlsx";
	String INPUT_PATH="./data/Input.xlsx";
	String PHOTO_PATH="./photo";

}
