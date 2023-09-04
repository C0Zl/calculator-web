package org.example;

/*
 요구사항
  - 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
  - MVC패턴(Model-View-Controller) 기반으로 구현한다.
  - 일급 컬렉션 사용
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat; // assertThat not found error 해결 ! (자동 import x)

import java.util.List;

public class GradeCalculatorTest {
    // 학점계산기 도메인 : 이수한 과목, 학점 계산기
    // 이수한 과목 : 객체지향 프로그래밍, 자료구조, 중국어회화 --> 과목 클래스로 표현

    // 이수한 과목(인자)을 전달하여 평균학점 계산 요청  --> 학점 계산기 --> (학점수×교과목 평점)의 합계/수강신청 총학점 수

    @DisplayName("평균 학점을 계산한다")
    @Test
    void calculateGradeTest() {
        List<Course> courses = List.of(new Course("OOP", 3, "A+"),
                new Course("자료구조", 3, "A+"));

        GradeCalculator gradeCalculator = new GradeCalculator(courses);
        double gradeResult = gradeCalculator.calculateGrade();

        assertThat(gradeResult).isEqualTo(4.5);
    }


}