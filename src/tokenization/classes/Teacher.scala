package tokenization.classes

import java.time.LocalDate

class Teacher(id: String, firstName: String, lastName: String, dateOfBirth: LocalDate, email: String, phoneNumber: String, token:Token, var coursesTaught: List[Course] = List.empty) extends Human(id, firstName, lastName, dateOfBirth, email, phoneNumber, token) {

  def assignCourse(course: Course): Unit =
  coursesTaught = coursesTaught :+ course

  override def displayInfo(): String = {
    val teacherCourseNames =
      if (coursesTaught.isEmpty) "no courses"
      else coursesTaught.map(c => s"${c.id} - ${c.title}").mkString(", ")

    s"-------------------------------------------------------------------\n$firstName $lastName, $age years.\nCourses: $teacherCourseNames.\nContacts: $email, $phoneNumber."
  }
}