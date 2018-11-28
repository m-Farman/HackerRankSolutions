import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.ArrayList;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private int id;
    private double cgpa;
    private String name;

    public Student() {
        // TODO Auto-generated constructor stub
    }

    public Student(int id, double cgpa, String name) {
        this.id = id;
        this.cgpa = cgpa;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Priorities{

    public List<Student> getStudents(List<String> events){
        TreeMap<Student, String> treeMap = new TreeMap<>(
                Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));
        for (String input : events) {
            if (input.equals("SERVED")) {
                treeMap.pollFirstEntry();
            } else {
                String[] token = input.split(" ");
                treeMap.put(new Student(Integer.parseInt(token[3]), Double.parseDouble(token[2]), token[1]), "");
            }
        }

        return new ArrayList(treeMap.keySet());
    }
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
