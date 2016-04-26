package ReflectAnalysis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassReflectAnalysis {

	public static void main(String[] args) {
		Class<Human> classobj = Human.class;
		
		String parentName = classobj.getSuperclass().getName();
		String modifier = Modifier.toString(classobj.getModifiers());
		Class [] interfaces = classobj.getInterfaces();
		StringBuffer interfacesBuf = new StringBuffer();
		if(interfaces.length != 0){
			interfacesBuf.append("implements ");
			for(int i = 0; i <= interfaces.length - 1; i++){
				if(i != interfaces.length - 1){
					interfacesBuf.append(interfaces[i].getName() + ",");
				}else{
					interfacesBuf.append(interfaces[i].getName());
				}
			}
		}
		String Header = modifier + " class " + classobj.getName() + " extends " + parentName + interfacesBuf.toString() + "{";
		System.out.println(Header + "\n");
		
		printFields(classobj);
		printMethods(classobj);
		printConstructors(classobj);
		
		System.out.println("}");
	}
	
	public static void printFields(Class<?> classobj){
		System.out.println("	//Fileds");
		String modifier = "";
		String type = "";
		String name = "";
		Field [] fields = classobj.getDeclaredFields();
		for(int i = 0; i <= fields.length - 1; i++){
			modifier = Modifier.toString(fields[i].getModifiers());
			type = fields[i].getType().getName();
			name = fields[i].getName();
			System.out.println("	" + modifier + " " + type + " " + name + ";");
		}
		System.out.println();
	}
	
	public static void printMethods(Class<?> classobj){
		System.out.println("	//Methods");
		String modifier = "";
		String returnType = "";
		String name = "";
		Class [] paraClasses = null;
		StringBuffer paraType = new StringBuffer();
		Method [] methods = classobj.getDeclaredMethods();
		for(int i = 0; i <= methods.length - 1; i++){
			modifier = Modifier.toString(methods[i].getModifiers());
			returnType = methods[i].getReturnType().getName();
			name = methods[i].getName();
			paraClasses = methods[i].getParameterTypes();
			for(int j = 0; j <= paraClasses.length - 1; j++){
				if(j != paraClasses.length - 1){
					paraType.append(paraClasses[j].getName() + ", ");
				}
				else{
					paraType.append(paraClasses[j].getName());
				}
			}
			System.out.println("	" + modifier + " " + returnType + " " + name + "(" + paraType.toString() + ")");
		}
		System.out.println();
	}
	
	public static void printConstructors(Class<?> classobj){
		System.out.println("	//Constructors");
		Constructor [] constructors = classobj.getConstructors();
		String modifier = "";
		String name = "";
		Class [] paraClasses = null;
		StringBuffer paraType = new StringBuffer();
		for(int i = 0; i <= constructors.length - 1; i++){
			modifier = Modifier.toString(constructors[i].getModifiers());
			name = constructors[i].getName();
			paraClasses = constructors[i].getParameterTypes();
			for(int j = 0; j <= paraClasses.length - 1; j++){
				if(j != paraClasses.length - 1){
					paraType.append(paraClasses[j].getName() + ", ");
				}
				else{
					paraType.append(paraClasses[j].getName());
				}
			}
			System.out.println("	" + modifier + " " + name + "(" + paraType.toString() + ")");
		}
		System.out.println();
	}
}
