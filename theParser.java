/* the Parser Final */
import java.io.*;

/**
 * @author akis
 */
public class theParser {

	private String line;
	private String[] stringTable;
	private BufferedReader in;
	

	public theParser(BufferedReader input) {
		in = input;
	}


	/* epistrefei to String pou exei diavasei i alliws ""
	 * an exoume ftasei sto telos tou arxeiou
	 */

	/* 0 gia paketo 1 kai class kai 2 gia methodo */
	
	/* epipleon 3 gia class in class */

	public String getTokenData(DataToken token){

		boolean classInClass=false;

		String aString="kwlos";

		try{
		line=in.readLine();
		}catch(IOException ex){
			System.out.println("input/output error!!");
		 }

		token.setClassInClassName(null);
		token.setClassName(null);
		token.setMethodName(null);
		token.setPackageName(null);

		/* prowri epistrofi an vrethei telos arxeiou */
		if(line.contains("Tree Report")){
			System.out.println("#Second half of file detected ...");
			System.out.println("#Changing way of reading file ...");
			return "secondHalf";
		}

		else	if(null==line) //telos arxeiou
			return "";

		else{

			if(line.contains("(Package)")){
				stringTable=line.split(" ");
				aString=stringTable[0];
					//an paketo mesa se paketo
					if(aString.contains(".")){
							  System.out.println("#SOS packet in packet !!!");
							  stringTable=aString.split(".");
							  aString=stringTable[stringTable.length - 1];
							  System.exit(-1);
					}

				System.out.println("");
				System.out.println("-------------------------");
				System.out.println("#Package-> " + aString);
				token.setValue(0);
				token.setPackageName(aString);
				return aString;
				/* pare to onoma tou paketou
				 * pou vrisketai apo tin arxi tis grammis
				 * mexri to prwto keno
				 */
			}
			else if(line.contains("(Class)") || line.contains("(Abstract Class)")){
				/*pare to onoma tis klasis pou vrisketai meta
				 * tin prwti teleia kai sto prwto keno pou tha
				 * syntantisei amesws meta
				 */
				stringTable=line.split("[.]");
				/* for debug */
				System.out.println(" spliting string, stringTable:");
				for(int i=0; i<stringTable.length; i++)
						System.out.println(stringTable[i]);
				System.out.println("string table size "+stringTable.length);


				/* fore debug */
				if(stringTable.length>=3){	
				    System.out.println(" SOS Class in Classs" );
					classInClass=true;
					
				
				}
				aString=stringTable[stringTable.length - 1];
				if(classInClass)
					token.setClassName(stringTable[stringTable.length-2]);
				
				stringTable=aString.split(" "); //deutero split
				aString=stringTable[0];			//me vasi ta kena
				System.out.println("#		Class-> " + aString);
				if(classInClass){
					token.setValue(4);	
					token.setClassInClassName(aString);
				}
				else{
				 token.setValue(1);
				 token.setClassName(aString);
				}
				 return aString;

			}
			else if(line.contains("(Method)") || line.contains("(Constructor)")){
				/* pare to onoma tis methodou pou vrisketai
				 * meta tin deuteri teleia mexri to prwto keno
				 */
				classInClass=false;
				stringTable=line.split("[.]");

				if(stringTable.length>=4)
					classInClass=true;

				aString=stringTable[stringTable.length -1];
				token.setMethodName(aString);
				if(classInClass){
					token.setClassName(stringTable[stringTable.length -3]);
					token.setClassInClassName(stringTable[stringTable.length -2]);
				}
				else
					token.setClassName(stringTable[stringTable.length -2]);

				stringTable=aString.split(" "); //kanei ena deutero split
														//me vasi ta kena
				aString=stringTable[0];

				System.out.println("#			Method-> " + aString);
				token.setValue(2);
				token.setMethodName(aString);
				return aString;

			}

			else
				aString = getTokenData(token); //anadromi, pairnei tin epomeni grammi
		}
		
	//	System.out.println("mikreeeee ");
		return aString;
	}

	/* argotera , h synartisi pou tha kalei ton parser tha vlepei
	 * an kaleitai apeutheias methodos apo alli klasi opote tha exoume
	 * apli dependency i alliws an yparei constructor tha exoume association */
	/* type 0 -> method depends on */
	/* type 1 -> this method */

	public String getTokenDependency(DependencyToken token){
	
		String retString;
		String packageName,className,methodName;
		String classInClassName;

		try{
		line=in.readLine();
		}catch(IOException ex){
			System.out.println("input/output error!!");
		}

		if( null == line ){
			return "";
		}

	//me dedomeno oti den yparxei paketo mesa se paketo	
		if(line.contains(".") && !line.contains("|")){
			
			/* ta setType gia ti  wra den xreiazontai dioti
			doulevw me vasi to string epistrofis */

			classInClassName=null;
			token.setType(0);
			stringTable=line.split("[.]");

			packageName=stringTable[0];
			System.out.println("# packageName is "+"\'"+packageName+"\'");
			String tempStrTable[];
			tempStrTable=packageName.split(" ");
			packageName=tempStrTable[0]; //exei ena extra keno kai to afairw
			className=stringTable[1];

			if(stringTable.length==4){ //class in class
				methodName=stringTable[3];
				classInClassName=stringTable[2];
				System.out.println("#ClassInClass is " +"\'"+classInClassName+"\'");
			}
			else methodName=stringTable[2];

	
			token.setClassInClassName(classInClassName);
			token.setPackageName(packageName);
			token.setClassName(className);
			token.setMethodName(methodName);

			System.out.println("-----------------------");
			if(classInClassName!=null)
				System.out.println("#method: " + packageName +" * "+className+
					" *  " +classInClassName+" * " +methodName);
			else
				System.out.println("#method: " + packageName +" * "+className+" * "+methodName);
			System.out.println("#depends on: ");
			return "depends";  //xazomara, apla gia na epistrefei kati 
		}

		else if(line.contains(".") && line.contains("|")){
			
			classInClassName=null;
//			System.out.println("line is " + line);
			token.setType(1);
			stringTable=line.split("[| ]",2);
			line = stringTable[1];
			stringTable = line.split("[.]");
			packageName=stringTable[0];
			System.out.println("#packageName is "+"\'"+packageName+"\'");
			String tempStrTable[];
			tempStrTable=packageName.split(" ");
			packageName=tempStrTable[1]; //exei ena extra keno kai to afairw
			System.out.println("#packageName is "+"\'"+packageName+"\'");
			className=stringTable[1];

			if(stringTable.length==4){ //class in class
				methodName=stringTable[3];
				classInClassName=stringTable[2];
				System.out.println("#ClassInClass is " +"\'"+classInClassName+"\'");
			}
			else methodName=stringTable[2];

			token.setClassInClassName(classInClassName);
			token.setPackageName(packageName);
			token.setClassName(className);
			token.setMethodName(methodName);

			if(classInClassName!=null)
				System.out.println("#method: " + packageName +" * "+className+
					" *  " +classInClassName+" * " +methodName);
			else
				System.out.println("#method: " + packageName +" * "+className+" * "+methodName);
		
			return "on";
}
		else retString=getTokenDependency(token);
	
		return retString;
	}
}
