package com.bharath.java8.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student {
	String name;
	String id;
	Student(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
public class Stream1 {
	public static void main(String args[]) {
		//case:1 - list of strings to uppercase
		List<String> listOfStrings = new ArrayList<>();
		listOfStrings.add("abc");
		listOfStrings.add("cde");
		listOfStrings.add("efg");
		//here the above list is filtered by removing "abc" and converting the 
		//rest of strings to upperCase using map and finally converting them to list using collectors
		List upperCaseList = listOfStrings.stream().filter(p->!p.equals("abc")).map(p->p.toUpperCase()).collect(Collectors.toList());
		System.out.println(upperCaseList);
		
		//case:2 - list of object to Map 
		List<Student> listOfStudents = new ArrayList<>();
		listOfStudents.add(new Student("Sai","1"));
		listOfStudents.add(new Student("Reddy", "2"));
		listOfStudents.add(new Student("Kishore", "3"));
		listOfStudents.add(new Student("Kumar", "4"));
		//here list of student objects are converted to a map with id as key and Student object itself as value 
		Map<String,Student> map = listOfStudents.stream().collect(Collectors.toMap(Student::getId, Function.identity()));
		map.forEach((a,b)->System.out.println(a + " " + b.getName()));
		
		//case:3- sorting the elements by passing a custom comaparator object
		listOfStudents.stream().map(Student::getName).sorted((a,b)->-a.compareTo(b)).forEach(System.out::println);
		
		//case:4  Find out duplicate number between 1 to N numbers
		 List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,8,4);
	        Set<Integer> set = new TreeSet<>();
	        for(Integer i : numbers) {
	        	if(!set.add(i)) {
	        		System.out.println("duplicate is " + i);
	        	}
	        }
	        
	        Map<Integer,Long> keyset = numbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	        keyset.entrySet().stream().filter(c->c.getValue()>1).forEach(e->System.out.println("duplicate is " + e.getKey()));
	}
}
