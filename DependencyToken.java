public class DependencyToken{
		String packageName;
		String className;
		String classInClassName;
		String methodName;
		int type;
	/* type 0 -> method depends on */
	/* type 1 -> this method */	
		
		public DependencyToken(){
			classInClassName=null;
		}
		public int getType(){
			return type;
		}
		public void setType(int val){
			type=val;
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
