package tokenization.objects

import tokenization.classes.{Student, Token}

object ScholarshipService {
  def distributeScholarships(students: List[Student]): Unit = {
    println("\n=== Нарахування стипендій ===")
    students.foreach { s =>
      val eligibleGrades = s.grades.values.filter(_ >= 70)
      if (eligibleGrades.nonEmpty) {
        val avg = eligibleGrades.sum.toDouble / eligibleGrades.size
        val amount = calculateScholarship(avg)
        if (amount > 0 && Platform.hasBalance(amount)) {
          val scholarship = new Token(amount, "USD")
          Platform.subtractBalance(scholarship)
          s.token = s.token + scholarship
          println(f"${s.firstName} ${s.lastName} отримав стипендію $amount USD (середній бал: $avg%.1f)")
        }
      }
    }
    println(s"Баланс платформи після виплат: ${Platform.getBalance}")
  }

  private def calculateScholarship(avg: Double): Int = avg match {
    case x if x >= 90 => 120
    case x if x >= 80 => 100
    case x if x >= 70 => 70
    case _ => 0
  }
}
