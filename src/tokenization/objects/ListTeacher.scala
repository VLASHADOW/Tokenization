package tokenization.objects

import tokenization.classes.{Teacher, Token}

import java.time.LocalDate

object ListTeacher {
  val teachers: List[Teacher] = List(
    new Teacher("T1", "Olena", "Koval", LocalDate.of(1985, 3, 20), "olena.koval@example.com", "+380671110001", new Token(0, "USD")),
    new Teacher("T2", "Petro", "Ivanenko", LocalDate.of(1979, 11, 2), "petro.ivanenko@example.com", "+380671110002", new Token(0, "USD")),
    new Teacher("T3", "Svitlana", "Polishchuk", LocalDate.of(1990, 5, 17), "svitlana.polishchuk@example.com", "+380671110003", new Token(0, "USD")),
    new Teacher("T4", "Oksana", "Lysenko", LocalDate.of(1982, 8, 29), "oksana.lysenko@example.com", "+380671110004", new Token(0, "USD")),
    new Teacher("T5", "Volodymyr", "Savchenko", LocalDate.of(1975, 1, 15), "volodymyr.savchenko@example.com", "+380671110005", new Token(0, "USD"))
  )

  CourseAssigner.assignCoursesToTeachers(teachers, ListCourses.courses)
}
