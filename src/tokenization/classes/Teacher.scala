package tokenization.classes

import java.time.LocalDate

class Teacher(
               id: String,
               firstName: String,
               lastName: String,
               dateOfBirth: LocalDate,
               email: String,
               phoneNumber: String,
               var _token: Token,
               var coursesTaught: List[Course] = List.empty
             ) extends Human(id, firstName, lastName, dateOfBirth, email, phoneNumber, _token) {

  def assignCourse(course: Course): Unit =
    coursesTaught = coursesTaught :+ course

  def gradeStudent(student: Student, course: Course, grade: Int): Unit = {
    if (!coursesTaught.exists(_.id == course.id))
      println(s"$firstName не викладає курс ${course.title}.")
    else if (!student.enrolledCourses.exists(_.id == course.id))
      println(s"${student.firstName} не записаний на курс ${course.title}.")
    else {
      student.addGrade(course, grade)
      println(s"$firstName виставив $grade балів студенту ${student.firstName} за курс '${course.title}'.")
    }
  }

  override def displayInfo(): String = {
    val teacherCourseNames =
      if (coursesTaught.isEmpty) "no courses"
      else coursesTaught.map(c => s"${c.id} - ${c.title}").mkString(", ")

    s"""-------------------------------------------------------------------
       |$firstName $lastName,
       |Age: $age years, Tokens: ${token.Amount}${token.Symb}
       |Courses taught: $teacherCourseNames
       |Contacts: $email, $phoneNumber
       |""".stripMargin
  }
}