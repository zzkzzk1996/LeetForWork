package myHashTable.hashCode;

import java.util.HashMap;
import java.util.Objects;

/**
 * @program: LeetForWork
 * @description:
 * @author: Zekun Zhang
 * @create: 2019-10-08 19:25
 */

public class HashCode {
    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("zzk");
        Student student2 = new Student("zzk");
        System.out.println(student1.equals(student2));

        HashMap<Student, Integer> map = new HashMap<>();
        map.put(student1, 3);
        System.out.println(map.get(student2));
    }
}
