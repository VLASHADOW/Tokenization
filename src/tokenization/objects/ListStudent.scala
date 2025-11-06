package tokenization.objects

import tokenization.classes.{Student, Token}

import java.time.LocalDate

object ListStudent {
  val students: List[Student] = List(
    new Student("S1", "Andrii", "Shevchenko", LocalDate.of(2001, 3, 12), "andrii.shevchenko@example.com", "+380501234001", new Token(100, "USD")),
    new Student("S2", "Olha", "Bondarenko", LocalDate.of(2003, 7, 25), "olha.bondarenko@example.com", "+380501234002", new Token(100, "USD")),
    new Student("S3", "Maksym", "Koval", LocalDate.of(2002, 1, 5), "maksym.koval@example.com", "+380501234003", new Token(100, "USD")),
    new Student("S4", "Kateryna", "Melnyk", LocalDate.of(2001, 9, 18), "kateryna.melnyk@example.com", "+380501234004", new Token(100, "USD")),
    new Student("S5", "Dmytro", "Tkachenko", LocalDate.of(2004, 4, 2), "dmytro.tkachenko@example.com", "+380501234005", new Token(100, "USD")),
    new Student("S6", "Iryna", "Lytvyn", LocalDate.of(2002, 6, 10), "iryna.lytvyn@example.com", "+380501234006", new Token(100, "USD")),
    new Student("S7", "Oleh", "Horbenko", LocalDate.of(2000, 12, 30), "oleh.horbenko@example.com", "+380501234007", new Token(100, "USD")),
    new Student("S8", "Natalia", "Vasylenko", LocalDate.of(2003, 8, 20), "natalia.vasylenko@example.com", "+380501234008", new Token(100, "USD")),
    new Student("S9", "Serhii", "Rudenko", LocalDate.of(2001, 5, 15), "serhii.rudenko@example.com", "+380501234009", new Token(100, "USD")),
    new Student("S10", "Yuliia", "Mazur", LocalDate.of(2002, 11, 1), "yuliia.mazur@example.com", "+380501234010", new Token(100, "USD"))
  )

  CourseAssigner.assignCoursesToStudents(students, ListCourses.courses)
}
