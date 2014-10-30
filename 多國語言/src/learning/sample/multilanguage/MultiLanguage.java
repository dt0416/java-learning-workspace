package learning.sample.multilanguage;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 讀取根目錄的*.properties檔<br />
 * properties檔需轉成16位元編碼格式, 可使用JDK/bin/native2ascii.exe, 點兩下輸入要編碼文字, Enter即輸出編碼後文字<br />
 * Eclipse會自動轉換<br />
 * <br />
 * 當遇到有Message.java則優先以java檔先讀, 讀不到才讀properties<br />
 * 但一般會用properties來當做設定檔<br />
 * 
 * @author Ian Chen
 */
public class MultiLanguage {

	public static void main(String[] args) {
		// Locale
		Locale chLoc = new Locale("zh", "TW");
		Locale enLoc = new Locale("en", "US");
		// ResourceBundle
		ResourceBundle chRb = ResourceBundle.getBundle("Message", chLoc); // 讀取順序Message_zh_TW.java -> Message_zh_TW.properties -> Message.properties
		ResourceBundle enRb = ResourceBundle.getBundle("Message", enLoc); // 讀取順序Message_en_US.java -> Message_en_US.properties -> Message_zh_TW.java -> Message_zh_TW.properties -> Message.properties
		String zhValue = chRb.getString("info");
		String enValue = enRb.getString("info");
		System.out.println("中文為:" + MessageFormat.format(zhValue, "AAA", 10));
		System.out.println("英文為:" + MessageFormat.format(enValue, "BBB", 20));
	}
}
