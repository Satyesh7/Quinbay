import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue ;
import java.util.LinkedList ;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private int id;
    private String name;
    private double cgpa;
    public Student(String name, double cgpa,int id) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID(){return id;}
    public String getName(){return name;}
    public double getCGPA(){return cgpa;}
};
class Priorities {
    private PriorityQueue<Student> queue;
    public Priorities() {
        queue = new PriorityQueue<>((s1, s2) -> {
            int[] res = {Double.compare(s2.getCGPA(),
            s1.getCGPA()),s1.getName().compareTo(s2.getName()),
            Integer.compare(s1.getID(), s2.getID())};
            for (int r : res){if (r != 0){return r;}}
            return 0;});
    }
    public List<Student> getStudents(List<String> events) {
        for (String event : events) {String[] e = event.split(" ");
            if (e[0].equals("ENTER")) 
            {queue.add(
                new Student(e[1], Double.parseDouble(e[2]),Integer.parseInt(e[3]))
                );}
            else if (e[0].equals("SERVED")) {queue.poll();}}
            LinkedList<Student> StudentsLeft = new LinkedList<>();
            while (!queue.isEmpty()) {StudentsLeft.add(queue.poll());}
            return StudentsLeft;}
}

public class Solution {
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