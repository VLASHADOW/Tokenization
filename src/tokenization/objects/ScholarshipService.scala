package tokenization.objects

import tokenization.classes.{Student, Token}

object ScholarshipService {

  def distributeScholarships(students: List[Student]): Unit = {
    students.foreach(processScholarshipForStudent)
  }

  def processScholarshipForStudent(s: Student): Unit = {
    val eligibleGrades = s.grades.values.filter(_ >= 70)

    if (eligibleGrades.nonEmpty) {
      val avg = eligibleGrades.sum.toDouble / eligibleGrades.size
      val amount = calculateScholarship(avg)

      if (amount > 0 && Platform.hasBalance(amount)) {
        val scholarship = new Token(amount, "USD")

        Platform.synchronized {
          if (Platform.hasBalance(amount)) {
            Platform.subtractBalance(scholarship)
            s.token = s.token + scholarship
            println(f"[Thread-${Thread.currentThread().getId}] Стипендія: ${s.firstName} отримав $amount USD (avg: $avg%.1f)")
          }
        }
      }
    }
  }

  private def calculateScholarship(avg: Double): Int = avg match {
    case x if x >= 90 => 120
    case x if x >= 80 => 100
    case x if x >= 70 => 70
    case _ => 0
  }
}