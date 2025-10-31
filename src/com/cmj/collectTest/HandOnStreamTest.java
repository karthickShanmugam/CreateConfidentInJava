package com.cmj.collectTest;

import java.util.ArrayList;
import java.util.List;

class StudentDetails{
    String name;
    double score;

    public StudentDetails(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

public class HandOnStreamTest {
    public static void main(String[] args) {

        List<StudentDetails> studentDetails = new ArrayList<>();
        studentDetails.add(new StudentDetails("Karthick",56.5));
        studentDetails.add(new StudentDetails("Shanmugam",33.5));
        studentDetails.add(new StudentDetails("sowmiya",85.6));
        studentDetails.add(new StudentDetails("Krithika",99.6));

        studentDetails.stream().filter(s->s.score>=60).forEach(d->System.out.println(d.getName()));
    }
}
