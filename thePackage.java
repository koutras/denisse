/* the Package Final */
//Package
/* author akis */
/* kathe paketo periexei kai mia syllogi
/* apo klaseis, xm, to swsto einai to
paketo na dynatai na periexei kai alla paketa... */

import java.util.*;
import java.io.*;
public class thePackage{
	ArrayList<theClass> collectionOfClasses;
	ArrayList <thePackage> collectionOfPackages;

	String name;

	public void addPackage(thePackage aPackage){
		collectionOfPackages.add(aPackage);
		System.out.println("		>adding Package in Package..."+aPackage);
		System.out.println("		>Packages in Package so far...");
		projectPackages();
	}

	public void removePackage(thePackage aPackage){
		System.out.println("removing package " + aPackage);
		collectionOfPackages.remove(aPackage);
	}

	

	public void projectPackages(){
		thePackage aPackage;
		for(int i=0; i<collectionOfPackages.size();i++){
			aPackage = collectionOfPackages.get(i);
			System.out.println("	   	+"+aPackage+" (PinP)");
			
		}
	}
	
	public void addClass(theClass aClass){
		collectionOfClasses.add(aClass);
		System.out.println("		>adding Class... "+aClass);
		System.out.println("		>Classes so far...");
		projectClasses();
	}


	public void removeClass(theClass aClass){
		System.out.println("removing class " + aClass);
		collectionOfClasses.remove(aClass);
	}
		
	public void projectClasses(){
		theClass aClass;
		for(int  i=0;i<collectionOfClasses.size();i++){
			aClass=collectionOfClasses.get(i);
			System.out.println("				+"+aClass+" (C)");
			aClass.projectMethods();
			aClass.projectClasses();
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

	public thePackage(String name){
		this.setName(name);
		collectionOfClasses = new ArrayList<theClass>();
		collectionOfPackages = new ArrayList<thePackage>();
	}

	public String  toString(){
		return getName();
	}

	public String getName(){
		return name;
	}

	public void setName(String packageName){
		name=packageName;
	}
	
	ArrayList<theClass> getCollectionOfClasses(){
		return collectionOfClasses;
	}
}
