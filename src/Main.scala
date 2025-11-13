package tokenization

import tokenization.classes.Token
import tokenization.objects._

import scala.util.Random

object Tokenization {
  def main(args: Array[String]): Unit = {
    Exchange.init(1000000.0, new Token(1000000, "USD"))

    val students = ListStudent.students
    val teachers = ListTeacher.teachers
    val courses = ListCourses.courses

    println("\n=== Початковий стан ===")
    teachers.foreach(t => println(t.displayInfo()))
    students.foreach(s => println(s.displayInfo()))

    println("\n=== Реєстрація студентів на курси ===")
    students.foreach { s =>
      val course = Random.shuffle(courses).head
      val teacher = teachers.find(_.coursesTaught.contains(course))
      teacher.foreach(t => EnrollmentService.enrollStudentToCourse(s, t, course))
    }

    println("\n=== Викладачі виставляють оцінки ===")
    teachers.foreach { t =>
      t.coursesTaught.foreach { c =>
        val enrolled = students.filter(_.enrolledCourses.contains(c))
        enrolled.foreach(st => t.gradeStudent(st, c, Random.between(60, 100)))
      }
    }

    println("\n=== Інформація перед стипендіями ===")
    students.foreach(s => println(s.displayInfo()))

    ScholarshipService.distributeScholarships(students)

    println("\n=== Після стипендій ===")
    students.foreach(s => println(s.displayInfo()))
    println(s"\nФінальний баланс платформи: ${Platform.getBalance}")
  }
}