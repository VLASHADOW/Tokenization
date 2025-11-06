package tokenization.classes

import java.time.LocalDate

class Student(
               id: String,
               firstName: String,
               lastName: String,
               dateOfBirth: LocalDate,
               email: String,
               phoneNumber: String,
               var _token: Token,
               var mpBalance: BigDecimal = 0,
               var enrolledCourses: List[Course] = List.empty,
               var grades: Map[String, Int] = Map.empty
             ) extends Human(id, firstName, lastName, dateOfBirth, email, phoneNumber, _token) {

  def addCourse(course: Course): Unit =
    enrolledCourses = enrolledCourses :+ course

  def addGrade(course: Course, grade: Int): Unit =
    grades = grades + (course.id -> grade)

  def enrollToCourse(course: Course, teacher: Teacher): Unit = {
    if (enrolledCourses.exists(_.id == course.id)) {
      println(s"$firstName вже записаний на курс ${course.title}.")
    } else if (token.Amount >= course.price) {
      token = token - new Token(course.price, token.Symb)
      teacher.token = teacher.token + new Token(course.price, token.Symb)
      enrolledCourses = enrolledCourses :+ course
      println(s"$firstName успішно записався на курс '${course.title}' за ${course.price}${token.Symb}.")
    } else {
      println(s"$firstName не має достатньо токенів для курсу '${course.title}'.")
    }
  }

  override def displayInfo(): String = {
    val studentCourseNames =
      if (enrolledCourses.isEmpty) "no courses"
      else enrolledCourses.map(c => s"${c.id} - ${c.title}").mkString(", ")

    s"""-------------------------------------------------------------------
       |$firstName $lastName,
       |Age: $age years, Tokens: ${token.Amount}${token.Symb}
       |Courses: $studentCourseNames
       |Grades: $grades
       |Contacts: $email, $phoneNumber
       |""".stripMargin
  }
}