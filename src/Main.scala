package tokenization

import tokenization.classes.{Course, Human, Student, Teacher, Token}
import tokenization.objects.{CourseAssigner, Exchange}

import java.time.{LocalDate, Period}

object Tokenization {
  def main(args: Array[String]): Unit = {
    /* val students = List(
      new Student("S1", "Andrii", "Shevchenko", LocalDate.of(2001, 3, 12), "andrii.shevchenko@example.com", "+380501234001"),
      new Student("S2", "Olha", "Bondarenko", LocalDate.of(2003, 7, 25), "olha.bondarenko@example.com", "+380501234002"),
      new Student("S3", "Maksym", "Koval", LocalDate.of(2002, 1, 5), "maksym.koval@example.com", "+380501234003"),
      new Student("S4", "Kateryna", "Melnyk", LocalDate.of(2001, 9, 18), "kateryna.melnyk@example.com", "+380501234004"),
      new Student("S5", "Dmytro", "Tkachenko", LocalDate.of(2004, 4, 2), "dmytro.tkachenko@example.com", "+380501234005"),
      new Student("S6", "Iryna", "Lytvyn", LocalDate.of(2002, 6, 10), "iryna.lytvyn@example.com", "+380501234006"),
      new Student("S7", "Oleh", "Horbenko", LocalDate.of(2000, 12, 30), "oleh.horbenko@example.com", "+380501234007"),
      new Student("S8", "Natalia", "Vasylenko", LocalDate.of(2003, 8, 20), "natalia.vasylenko@example.com", "+380501234008"),
      new Student("S9", "Serhii", "Rudenko", LocalDate.of(2001, 5, 15), "serhii.rudenko@example.com", "+380501234009"),
      new Student("S10", "Yuliia", "Mazur", LocalDate.of(2002, 11, 1), "yuliia.mazur@example.com", "+380501234010")
    )

    val teachers = List(
      new Teacher("T1", "Olena", "Koval", LocalDate.of(1985, 3, 20), "olena.koval@example.com", "+380671110001"),
      new Teacher("T2", "Petro", "Ivanenko", LocalDate.of(1979, 11, 2), "petro.ivanenko@example.com", "+380671110002"),
      new Teacher("T3", "Svitlana", "Polishchuk", LocalDate.of(1990, 5, 17), "svitlana.polishchuk@example.com", "+380671110003"),
      new Teacher("T4", "Oksana", "Lysenko", LocalDate.of(1982, 8, 29), "oksana.lysenko@example.com", "+380671110004"),
      new Teacher("T5", "Volodymyr", "Savchenko", LocalDate.of(1975, 1, 15), "volodymyr.savchenko@example.com", "+380671110005")
    )

    val courses = List(
      new Course("C1", "Scala Basics", 100),
      new Course("C2", "Functional Programming", 120),
      new Course("C3", "Databases for Developers", 90),
      new Course("C4", "Distributed Systems", 150),
      new Course("C5", "Frontend with React", 110)
    )

    CourseAssigner.assignCoursesToTeachers(teachers, courses)
    CourseAssigner.assignCoursesToStudents(students, courses)
    CourseAssigner.assignRandomGrades(students)

    println("=== TEACHERS ===")
    teachers.foreach(t => println(t.displayInfo()))
    println("\n=== STUDENTS ===")
    students.foreach(s => println(s.displayInfo())) */
    println("\n======================================TOKENIZATION======================================")
    var token:Token = new Token(10000000, "ed")
    Exchange.init(10000, token)

    var human1:Human = new Human("S1", "Andrii", "Shevchenko", LocalDate.of(2001, 3, 12), "andrii.shevchenko@example.com", "+380501234001", new Token(100, "ed"))
    println(human1.GetToken.TokenInfo())
    human1.Buy(new Token(100, "ed"))
    println(human1.GetToken.TokenInfo())


    var human2:Human = new Human("S2", "Olha", "Bondarenko", LocalDate.of(2003, 7, 25), "olha.bondarenko@example.com", "+380501234002", new Token(1000, "ed"))
    var human3:Human = new Human("S3", "Maksym", "Koval", LocalDate.of(2002, 1, 5), "maksym.koval@example.com", "+380501234003", new Token(100, "ed"))

    println(Exchange.GetInf())
  }
}
