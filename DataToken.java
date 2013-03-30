public class DataToken{
	 int value;
		String packageName;
		String className;
		String classInClassName;
		String methodName;
	  public void setValue(int aVal){
			value=aVal;	
		}
	  public int getValue(){
			return value;
		}
			public String getClassInClassName(){
			return classInClassName;
		}
		public void setClassInClassName( String className){
			classInClassName=className;
			
		}
		public String getMethodName(){
			return methodName;
		}
		public String getClassName(){
			return className;
		}
	
		public String getPackageName(){
			return packageName;
		}

		public void setPackageName(String name){
			packageName=name;
		}
		public void setClassName(String name){
			className=name;
		}
	
		public void setMethodName(String name){
			methodName=name;
		}

}
