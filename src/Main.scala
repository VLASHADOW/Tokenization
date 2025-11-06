package tokenization

import tokenization.classes.{Course, Human, Student, Teacher, Token}
import tokenization.objects.{CourseAssigner, Exchange, ListCourses, ListStudent, ListTeacher, TokenizationLogic}

import java.time.{LocalDate, Period}

object Tokenization {
  def main(args: Array[String]): Unit = {
    val students = ListStudent.students
    val teachers = ListTeacher.teachers
    val courses = ListCourses.courses

    println("=== Teachers ===")
    teachers.foreach(t => println(t.displayInfo()))

    println("\n=== Students ===")
    students.foreach(s => println(s.displayInfo()))

    println("\n=== Token Exchange ===")
    TokenizationLogic.payForCourse(students.head, teachers.head, 20)

    println(s"${students.head.firstName} now has ${students.head.token.TokenInfo()}")
    println(s"${teachers.head.firstName} now has ${teachers.head.token.TokenInfo()}")
  }
}
