package org.example;

import java.util.List;

public class GradeCalculator {


    private final List<Course> courses;

    public GradeCalculator(List<Course> courses) {
        this.courses = courses;
    }

    /*
 요구사항
  - 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
  - MVC패턴(Model-View-Controller) 기반으로 구현한다.
  - 일급 컬렉션 사용
 */

    public double calculateGrade() {
        // (학점수×교과목 평점)의 합계
        double MultipliedCreditAndCourseGrade = 0;

        for (Course course: courses) {
            // 기존 방법
            // MultipliedCreditAndCourseGrade += course.getcredit() * course.getGradeToNumber;
            // -> course 내에서 수행하지 않기 때문에 응집도가 낮음
            // -> 비슷한 코드를 여러 군데에서 사용하게 될 때 수정 시에 번거로움

            // 수정한 방법 : 객체에게 작업 위임
            MultipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }

        int totalCompletedCredit = courses.stream()
                .mapToInt(Course::getCredit)
                .sum();

        return MultipliedCreditAndCourseGrade / totalCompletedCredit;
    }
}
