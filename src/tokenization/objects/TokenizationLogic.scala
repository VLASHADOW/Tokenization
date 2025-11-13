package tokenization.objects

import tokenization.classes.{Student, Teacher, Token}

object TokenizationLogic {
  def payForCourse(student: Student, teacher: Teacher, price: Int): Boolean = {
    val requiredToken = new Token(price, "USD")

    if (student.GetToken.amount < requiredToken.amount) {
      println(s"${student.firstName} does not have enough tokens. Trying to buy from Exchange.")
      val missingAmount = requiredToken.amount - student.GetToken.amount
      student.Buy(new Token(missingAmount, "USD"))
    }

    if (student.GetToken.amount >= requiredToken.amount) {
      student.token = student.GetToken - requiredToken
      teacher.token = teacher.GetToken + requiredToken
      println(s"${student.firstName} ${student.lastName} paid ${requiredToken.amount}${requiredToken.symb} to ${teacher.firstName} ${teacher.lastName}")
      true
    } else {
      println(s"Payment failed. ${student.firstName} still doesn't have enough tokens after visiting Exchange.")
      false
    }
  }
}
