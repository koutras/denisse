/* theMethod final */
/* author akis */

import java.util.*;
class theMethod{
	ArrayList<theMethod> collectionOfMethodDependencies;
	String name;


	public theMethod(String name){
		setName(name);
		collectionOfMethodDependencies = new ArrayList<theMethod>();
	}
	
	public String toString(){
		return getName();
	}

	public String getName(){
		return name;
	}
		
	public void setName(String methodName){
		name=methodName;
	}

	public void addMethodDependency(theMethod aMethod){
		if(searchMethodDependency(aMethod.getName())==null)
			collectionOfMethodDependencies.add(aMethod);
	}
	
	public ArrayList<theMethod> getMethodDependencies(){
		return collectionOfMethodDependencies;
	}

	public void removeMethodDependency(theMethod aMethod){
		collectionOfMethodDependencies.remove(aMethod);
	}
	
	public theMethod searchMethodDependency(String dependableMethodName){
		theMethod aMethod=null;
		boolean found;
		found = false;
		theClass aClass=null;
		int i;
		for(i=0;i<collectionOfMethodDependencies.size();i++)
			if(collectionOfMethodDependencies.get(i).getName().equals(dependableMethodName)){
				found=true;
				aMethod=collectionOfMethodDependencies.get(i);
				break;
			}
			
		if(found)	
			return aMethod;
		else return null;
	}


	
}
