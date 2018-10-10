package br.com.hoptech.collections;

import java.util.Comparator;

public class ComparableAndComparator {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

}

class Student implements Comparable<Student>{
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
	super();
	this.id = id;
	this.fname = fname;
	this.cgpa = cgpa;
    }
    public int getId() {
	return id;
    }
    public String getFname() {
	return fname;
    }
    public double getCgpa() {
	return cgpa;
    }

    public int compareTo(Student otherStudent) {
	double firstCompare = ((Student) otherStudent).getCgpa() - this.cgpa;
	if (firstCompare < 0.0) {
	    return -1;
	} else if (firstCompare > 0.0) {
	    return 1;
	}
	int secondCompare = this.fname.compareTo(((Student) otherStudent).getFname());

	if (secondCompare != 0) return secondCompare;

	return this.id - ((Student) otherStudent).getId();
    }

}

class Checker implements Comparator<Player> {

    public int compare(Player one, Player other) {
	int firstCompare = (other.score - one.score);
	if (firstCompare < 0) {
	    return -1;
	} else if (firstCompare > 0) {
	    return 1;
	}
	return one.name.compareTo(other.name);
    }  
}

class Player{
    String name;
    int score;

    Player(String name, int score){
	this.name = name;
	this.score = score;
    }
}