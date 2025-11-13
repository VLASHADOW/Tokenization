package tokenization.objects

import tokenization.classes.{Course, Student, Teacher, Token}

object EnrollmentService {
  def enrollStudentToCourse(student: Student, teacher: Teacher, course: Course): Boolean = {
    val cost = new Token(course.price, "USD")

    if (student.GetToken.Amount < cost.Amount) {
      val diff = cost.Amount - student.GetToken.Amount
      println(s"${student.firstName} не має достатньо токенів. Купує $diff${cost.Symb} з біржі.")
      student.Buy(new Token(diff, "USD"))
    }

    if (student.GetToken.Amount >= cost.Amount) {
      student.token = student.GetToken - cost
      teacher.token = teacher.GetToken + cost
      Platform.addRevenue(cost)
      student.addCourse(course)
      println(s"${student.firstName} успішно купив курс ${course.title} у ${teacher.firstName}.")
      true
    } else {
      println(s"${student.firstName} все ще не має достатньо токенів для покупки курсу ${course.title}.")
      false
    }
  }
}
