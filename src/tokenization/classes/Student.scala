package tokenization.classes

import java.time.LocalDate

class Student(id: String, firstName: String, lastName: String, dateOfBirth: LocalDate, email: String,phoneNumber: String, var mpBalance: BigDecimal = 0, var enrolledCourses: List[Course] = List.empty, var grades: Map[String, Int] = Map.empty) extends Human(id, firstName, lastName, dateOfBirth, email, phoneNumber) {

  def addCourse(course: Course): Unit =
    enrolledCourses = enrolledCourses :+ course

  def addGrade(course: Course, grade: Int): Unit =
    grades = grades + (course.id -> grade)

  override def displayInfo(): String = {
    val studentCourseNames =
      if (enrolledCourses.isEmpty) "no courses"
      else enrolledCourses.map(c => s"${c.id} - ${c.title}").mkString(", ")

    s"-------------------------------------------------------------------\n$firstName $lastName, $age years, $mpBalance.\nCourses: $studentCourseNames.\nGrades: $grades.\nContacts: $email, $phoneNumber."
  }
}