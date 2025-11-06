package tokenization.objects

import tokenization.classes.{Student, Teacher, Token}

object TokenizationLogic {
  def payForCourse(student: Student, teacher: Teacher, price: Int): Unit = {
    val token = new Token(price, "USD")

    if (student.token.Amount >= token.Amount) {
      student.token = student.token - token
      teacher.token = teacher.token + token
      println(s"${student.firstName} ${student.lastName} paid ${token.Amount}${token.Symb} to ${teacher.firstName} ${teacher.lastName}")
    }
    else {
      println(s"${student.firstName} does not have enough tokens.")
    }
  }
}
