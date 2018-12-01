package com.relesee.framework.sax;


import com.relesee.framework.sax.domains.Student;
import com.relesee.framework.sax.domains.Teacher;

import java.util.Scanner;

public class Main {
    public static void main (String args[]) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()){
            System.out.println(s.nextInt());
        }
        /*
        AssemblyPlant ap = new AssemblyPlant();
        try {
            Teacher teacher = ap.get(Teacher.class,"src/main/resources/test/Test.xml");
            System.out.println(teacher.getNO()+"--"+teacher.getName());
            Student s = ap.get(Student.class,"src/main/resources/test/Student.xml");
            System.out.println(s.getStuid()+"--"+s.getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        */
    }
}
