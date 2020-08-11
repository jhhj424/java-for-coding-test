package sort;

import java.util.*;

/**
 * 정렬문제 : 성적이 낮은 순서로 학생 출력하기
 *  - 오름차순 정렬
 */
public class RowStudent {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        // N을 입력받기
        int n = sc.nextInt();

        // N명의 학생 정보를 입력받아 리스트에 저장
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            students.add(new Student(name, score));
        }

        Collections.sort(students);


        for (int i = 0; i < students.size(); i++) {
            System.out.print(students.get(i).getName() + " : " + students.get(i).getScore());
        }
    }
}

class Student implements Comparable<Student> {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }


    @Override
    public int compareTo(Student other) {
        if(this.score < other.score) {
            return -1;
        }
        return 1;
    }
}
