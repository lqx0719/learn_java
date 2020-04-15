package test1;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.TreeSet;


public class Container {
	public static void main(String[] args) {

		
		
		
	//set
	HashSet<Integer> hs = new HashSet<Integer>();
	hs.add(111);
	hs.add(111);
	hs.add(222);
	Iterator<Integer> it = hs.iterator();
	while(it.hasNext()){
		System.out.println("hashset: "+it.next());
	}
	
	TreeSet ts = new TreeSet();
	ts.add("C");
	ts.add("A");
	ts.add("B");
	ts.add("E");
	System.out.println(ts);
	
	//list
	ArrayList<String> al=new ArrayList<String>();
	al.add("aaa");
	al.add(0,"bbbb");
	System.out.println("arraylist: "+al.get(1));
	al.set(0, "cccc");
	System.out.println("arraylist: "+al.get(0));
	al.remove(1);
	System.out.println("arraylist: "+al.size());
	//linkedlist用法基本一致，但是可以removeFirst(),removeLast(),addFirst(),addLast()
	
	//map
	HashMap<String,Integer> hm = new HashMap<String,Integer>();	
	hm.put("aaa", 111);//增
	System.out.println("hashmap: "+hm.get("aaa"));//查
	System.out.println("hashmap: "+hm.containsKey("aaa"));
	System.out.println("hashmap: "+hm.containsValue(11));
	hm.remove("aaa");
	System.out.println("hashmap: "+hm.size());
	
	TreeMap tm = new TreeMap();
	tm.put("aaaa", 1111);
	tm.put("bbbb", 2222);
	System.out.println("treemap: "+tm.get("aaaa"));//查
	System.out.println("treemap: "+tm.containsKey("bbbb"));
	tm.remove("aaaa");
	System.out.println("treemap: "+tm.size());
	}
}
