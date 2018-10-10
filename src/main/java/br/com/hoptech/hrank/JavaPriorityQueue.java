package br.com.hoptech.hrank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JavaPriorityQueue {
    
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }

}

class Priorities {

    public List<Student> getStudents(List<String> events) {
	
	PriorityQueue<Student> queue = new PriorityQueue();
	
	for(String event : events) {
	    if (event.equals("SERVED")) {
		queue.poll();
	    } else {
		queue.add(new Student(Integer.valueOf(event.split(" ")[3]), event.split(" ")[1], Double.valueOf(event.split(" ")[2])));	    		
	    }
	}
	
	        
	List<Student> retorno = new ArrayList<Student>();
	Iterator<Student> it = queue.iterator(); 
	while (it.hasNext()) {
	    retorno.add(it.next()); 
	}
	
	return getLista(queue);
    }
    
    static List<Student> getLista(PriorityQueue<Student> queue) {
	List<Student> retorno = new ArrayList<Student>();
	PriorityQueue<Student> clone = new PriorityQueue<>(queue);
	
	//System.out.println("------ printLista -------");
	for (int i = 0; i<queue.size(); i++) {
	    //System.out.println("Value: "+ clone.poll());
	    retorno.add(clone.poll());
	}
	return retorno;
    }
    
}

class Student implements Comparable{
    
    private int id;
    private String name;
    private double cgpa;
    
    public Student(int id, String name, double cgpa) {
	super();
	this.id = id;
	this.name = name;
	this.cgpa = cgpa;
    }
    public int getId() {
	return id;
    }
    public String getName() {
	return name;
    }
    public double getCgpa() {
	return cgpa;
    }

    @Override
    public int compareTo(Object otherStudent) {
        double firstCompare = this.cgpa - ((Student) otherStudent).getCgpa();
        if (firstCompare > 0.0) {
            return -1;
        } else if (firstCompare < 0.0) {
            return 1;
        }
        int secondCompare = this.name.compareTo(((Student) otherStudent).getName());
        
        if (secondCompare != 0) return secondCompare;
        
        return this.id - ((Student) otherStudent).getId();
        
    }
    
    @Override
    public String toString() {
        return "Nota: " + this.getCgpa() + " " + "  Nome: " + this.getName() + "  id: " + this.getId();
    }

}