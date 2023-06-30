package oopex0;

public class People {
	
	 
	  public int v1 = 10;
	  protected int v2 = 20;
	  int v3 =30;
	  private int v4 =40;
	  
	  public void ex() {
		  System.out.println("같은 클래스 내부");
		  System.out.println("v1"); //10
		  System.out.println("v2"); //20
		  System.out.println("v3"); //30
		  System.out.println("v4"); //40
	  
	
	  }
	
	  public static String Schoolname = "kh고등학교";
	  private String name;
	  
	  public String getName() {
		  return name;
	  }
	  
	  public void setName(String name) {
		  
		  this.name = name;
	  }
}
