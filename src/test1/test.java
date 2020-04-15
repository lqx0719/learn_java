package test1;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
public class test {
	public static void main(String[] args){
		boolean[] test = new boolean[10];
//		for(int i =0; i< test.length;i++){
//			test[i] = true;
//			System.out.println(test[i]);
//		}
		String infoString = "2020-4-14 阅读(1000) 评论(999)";
		Pattern pattern = Pattern.compile("(.*?) 阅读\\((.*?)\\) 评论\\((.*?)\\)");
		Matcher matcher = pattern.matcher(infoString);
		if(matcher.find()) {
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
		}
		/*
		int a = 10;
		int b = 11;
		int abs_ab = Math.abs(a-b);
		System.out.println(abs_ab);
		int[] c={1,2,3};
		System.out.println(Arrays.toString(c));
		int[] name = {11,22};
		Student s = new Student(name);
		System.out.println(s.getName());
		name[0] = 33;
		System.out.println(s instanceof Student);
		
		Student s1 = new Student(name);
		Student s2 = new Student(name);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		for(Field field:Student.class.getFields()){
			if(field.isAnnotationPresent((Class<? extends Annotation>) testAnnotation.class)){
				System.out.println(field.getAnnotation(testAnnotation.class).num());
			}
		}
		*/
	}
}
class Student{
	public int[] name;
	@testAnnotation(num=1000)
	public int sex;
	public Student(int[] name){
		this.name = name;
	}
	public int getName(){
		return this.name[0]+this.name[1];
	}
	
	public void setSex(int sex){
		this.sex = sex;
	}
	
	public int getSex(){
		return this.sex;
		
	}
	
}
