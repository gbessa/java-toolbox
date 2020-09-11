package br.com.hoptech.designpatterns;

public class Singleton {

    private static Singleton instance;
    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }


    
    private Singleton() {
	    this.appName = "No name";
    }
    
    public static synchronized Singleton getInstance() {
	
	if (instance == null) {
	    instance = new Singleton();
	}
	return instance;
	
    }
    
}

class UseSingleton {

    public static void main(String[] args) {
        Singleton singInstance1 = Singleton.getInstance();
        Singleton singInstance2 = Singleton.getInstance();

        System.out.println(singInstance1.getAppName());
        singInstance1.setAppName("JAVAAPP");
        System.out.println(singInstance1.getAppName());
        System.out.println(singInstance2.getAppName());


    }

}


