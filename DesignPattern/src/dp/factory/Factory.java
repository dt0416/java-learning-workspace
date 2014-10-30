package dp.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

interface Fruit {
	public void eat();
}

class Apple implements Fruit {
	public void eat() {
		System.out.println("蘋果");
	}
}

class Orange implements Fruit {
	public void eat() {
		System.out.println("橘子");
	}
}

class Factory {
	public static Fruit getInstance(String className) {
		Fruit f = null;
		try {
			f = (Fruit) Class.forName(className).newInstance();
		} catch (Exception e) {
		}
		return f;
	}
}

class PropertiesOperate {
	private Properties pro = null;
	private File file = new File("fruit.properties");

	public PropertiesOperate() {
		this.pro = new Properties();
		if (file.exists()) {
			try {
				pro.loadFromXML(new FileInputStream(file));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			this.save() ;
		}
	}

	private void save() {
		this.pro.setProperty("fruit", "learning.sample.Factory.Apple");
		try {
			this.pro.storeToXML(new FileOutputStream(this.file), "Fruit");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Properties getProperties() {
		return this.pro;
	}
}
