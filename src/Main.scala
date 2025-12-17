package tokenization

import tokenization.classes.Token
import tokenization.objects._
import scala.concurrent.{Future, Await, ExecutionContext}
import scala.concurrent.duration._
import scala.util.{Random, Success, Failure}

object Tokenization {
  implicit val ec: ExecutionContext = ExecutionContext.global
  def main(args: Array[String]): Unit = {
    Exchange.init(1000000.0, new Token(1000000, "USD"))

    val students = ListStudent.students
    val teachers = ListTeacher.teachers
    val courses = ListCourses.courses

    println("\n=== Початковий стан ===")
    teachers.foreach(t => println(t.displayInfo()))
    students.foreach(s => println(s.displayInfo()))

    println("\n=== [ПАРАЛЕЛЬНО] Реєстрація студентів на курси ===")

    val registrationFutures: List[Future[Unit]] = students.map { s =>
      Future {
        Thread.sleep(Random.nextInt(50))
        val course = Random.shuffle(courses).head
        val teacher = teachers.find(_.coursesTaught.contains(course))
        teacher.foreach(t => EnrollmentService.enrollStudentToCourse(s, t, course))
      }
    }

    Await.ready(Future.sequence(registrationFutures), Duration.Inf)


    println("\n=== [ПАРАЛЕЛЬНО] Викладачі виставляють оцінки ===")

    val gradingFutures: List[Future[Unit]] = teachers.map { t =>
      Future {
        Thread.sleep(Random.nextInt(50))
        t.coursesTaught.foreach { c =>
          val enrolled = students.filter(_.enrolledCourses.contains(c))
          enrolled.foreach(st => t.gradeStudent(st, c, Random.between(60, 100)))
        }
      }
    }

    Await.ready(Future.sequence(gradingFutures), Duration.Inf)


    println("\n=== Інформація перед стипендіями ===")
    students.foreach(s => println(s.displayInfo()))


    println("\n=== [ПАРАЛЕЛЬНО] Нарахування стипендій ===")
    val scholarshipFutures: List[Future[Unit]] = students.map { s =>
      Future {
        ScholarshipService.processScholarshipForStudent(s)
      }
    }

    Await.ready(Future.sequence(scholarshipFutures), Duration.Inf)

    println("\n=== Після стипендій ===")
    students.foreach(s => println(s.displayInfo()))
    println(s"\nФінальний баланс платформи: ${Platform.getBalance}")
  }
}