package tokenization.objects

import tokenization.classes.{Course, Student, Teacher, Token}

object EnrollmentService {
  def enrollStudentToCourse(student: Student, teacher: Teacher, course: Course): Boolean = this.synchronized {
    val cost = new Token(course.price, "USD")

    if (student.GetToken.Amount < cost.Amount) {
      val diff = cost.Amount - student.GetToken.Amount
      student.Buy(new Token(diff, "USD"))
    }

    if (student.GetToken.Amount >= cost.Amount) {
      student.token = student.GetToken - cost
      teacher.token = teacher.GetToken + cost
      Platform.addRevenue(cost)

      student.addCourse(course)

      println(s"[Thread-${Thread.currentThread().threadId()}] ${student.firstName} успішно записався на курс '${course.title}'.")
      true
    }
    else {
      println(s"[Thread-${Thread.currentThread().threadId()}] ПОМИЛКА: ${student.firstName} не зміг оплатити курс.")
      false
    }
  }
}
