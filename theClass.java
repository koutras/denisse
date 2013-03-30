/* the Class Final */
/* author akis */

import java.util.*;
public class theClass{
/* mia klasi periexei methodous,klaseis tis
opoies exartatai kathws kai alles klaseis pou mporei
na periexei ..*/

	String name;
	int depthOfIerarchy;
	ArrayList<theMethod> collectionOfMethods; 
	ArrayList<theClass> collectionOfClassDependencies;
	ArrayList<theClass> collectionOfClasses;

	public void addMethod(theMethod aMethod){
		if(searchMethod(aMethod.getName())==null){
			collectionOfMethods.add(aMethod);
			System.out.println("		>adding Method... "+aMethod);
			System.out.println("		>Methods so far...");
			projectMethods();
		}
		else
			System.out.println("Method exists");
	}

	public void removeMethod(theMethod aMethod){
		System.out.println("removing method " + aMethod);
		System.out.println("from class " + this);

		collectionOfMethods.remove(aMethod);
	}

	public void addClass(theClass aClass){
		int currentDepth;
		currentDepth=getDepthOfIerarchy();
		aClass.setDepthOfIerarchy(currentDepth+1); // eswteriki klasi auxanw to epipedo ierarchias
		collectionOfClasses.add(aClass);
		System.out.println("		>adding Class in class... "+aClass);
		System.out.println("		>Classes in class so far...");
		projectClasses();

	}

	public void removeClass(theClass aClass){
		System.out.println("removing inner class " + aClass);
		System.out.println("from class " + this);
		collectionOfClasses.remove(aClass);
	}

	public void projectClasses(){
	if(collectionOfClasses.size()>0){
		for(int i=0;i<collectionOfClasses.size();i++){
			System.out.println("					+"+collectionOfClasses.get(i)+" (CinC)");
			collectionOfClasses.get(i).projectMethods();
			collectionOfClasses.get(i).projectClasses();
		}
		System.out.println("					------------");
	}
	}


	public void projectMethods(){
		for(int i=0;i<collectionOfMethods.size();i++)
			System.out.println("					  +"+collectionOfMethods.get(i)+" (M)");
			
	}
	
	public void setDepthOfIerarchy(int num){
		depthOfIerarchy=num;
	}

	public int getDepthOfIerarchy(){
		return depthOfIerarchy;
	}
	
	public ArrayList<theClass> getCollectionOfClasses(){
		return collectionOfClasses;
	}
	
	public void setName(String className){
		name=className;
	}
	public String getName(){
		return name;
	}
		
	public theClass(String className){
		setName(className);
		collectionOfMethods = new ArrayList<theMethod>();
		collectionOfClassDependencies = new ArrayList<theClass>();
		collectionOfClasses = new ArrayList<theClass>();
		setDepthOfIerarchy(0);

	}

	public String toString(){
		String aString="";
		for(int i=0;i<getDepthOfIerarchy();i++)
			aString.concat("*");
		return aString.concat(getName());
	}

	public	ArrayList<theMethod> getCollectionOfMethods(){
		return collectionOfMethods;
	}
	public theMethod searchMethod(String methodName){
		boolean found;
		found = false;
		int i;
		System.out.println("		>Searching method "+"\'"+methodName+"\'");
		for(i=0;i<collectionOfMethods.size();i++){
			System.out.println(i+")"+"\'"+collectionOfMethods.get(i)+"\'");
			if(collectionOfMethods.get(i).getName().equals(methodName)){
				found=true;
				break;
			}
		}
			
		if(found){	
			System.out.println("		>method found!!!");
			return collectionOfMethods.get(i); 
		}
		else{
		System.out.println("		>NOT FOUNDD!!!!");
		 return null;
		}
	}

	public theClass searchClass(String className){
		boolean found;
		found = false;
		int i;
		System.out.println("		>searching class " +"\'"+className+"\'");

		for(i=0;i<collectionOfClasses.size();i++)
			if(collectionOfClasses.get(i).getName().equals(className)){
				found=true;
				break;
			}
			
		if(found){	
			System.out.println("		>class found!!!");
			return collectionOfClasses.get(i) ;
		}
		else{
			System.out.println("		>class NOT FOUND!!!");
		} return null;
	}


	public theClass searchClassDependency(String dependableClassName){
		theClass aClass=null;
		boolean found;
		found = false;
		for(int i=0;i<collectionOfClassDependencies.size();i++)
			if(collectionOfClassDependencies.get(i).getName().equals(dependableClassName)){
				found=true;
				aClass=collectionOfClassDependencies.get(i);	
				break;
			}
		
			
		if(found)	
			return aClass;
		else return null;
	}


	public ArrayList<theClass> getClassDependencies(){
		return collectionOfClassDependencies;
	}
	public void addClassDependency(theClass dependableClass){
		if(searchClassDependency(dependableClass.getName())==null)
			collectionOfClassDependencies.add(dependableClass);
	}
	
	public void removeClassDependency(theClass dependableClass){
		collectionOfClassDependencies.remove(dependableClass);
		System.out.println("removing dependency: " +dependableClass +"\n");
		System.out.println("from: " +this);
	}
	
	
}
