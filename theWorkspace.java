/* the Worskace Final */
//theWorkspace
/* author akis */
import java.util.*;
import java.io.*;
public class theWorkspace{
	ArrayList<thePackage> collectionOfPackages;

	String name;
	
	public void addPackage(thePackage aPackage){
		System.out.println("		>Adding package.... "+aPackage);
		System.out.println("		>Packages so far...");
		collectionOfPackages.add(aPackage);
		projectPackages();
	}

	public void removePackage(thePackage aPackage){
		System.out.println(" removing package " + aPackage);
		collectionOfPackages.remove(aPackage);
	}
	
	public void projectPackages(){
		thePackage aPackage;
		for(int i=0;i<collectionOfPackages.size();i++){
			aPackage =	collectionOfPackages.get(i);
			System.out.println("			+"+aPackage+" (P)");
			aPackage.projectClasses();		
		}
				
	}

	public thePackage searchPackage(String packageName){
		boolean found;
		int i;
		found = false;
		System.out.println("		>will search for package: "+"\'"+packageName+"\'");
		for(i=0;i<collectionOfPackages.size();i++){
			System.out.println(i+")"+collectionOfPackages.get(i).getName());
			if(collectionOfPackages.get(i).getName().equals(packageName)){
				found=true;
				break;
			}
		}
			
		
		if(found){	
			System.out.println("		>package: "+collectionOfPackages.get(i) + " Found!!");
			return collectionOfPackages.get(i);
		}
		else return null;
	}




	public theWorkspace(String name){
		setName(name);
		collectionOfPackages = new ArrayList<thePackage>();
	}


	public void setName( String wName){
		name=wName;
	}
	public String getName(){
		return name;
	}
		

	public String toString(){
		return getName();
	}


	ArrayList<thePackage> getCollectionOfPackages(){
		return collectionOfPackages;
	}
}
