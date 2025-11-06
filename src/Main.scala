package tokenization

import tokenization.classes.{Course, Human, Student, Teacher, Token}
import tokenization.objects.{CourseAssigner, Exchange, ListCourses, ListStudent, ListTeacher, TokenizationLogic}

import scala.util.Random

object Tokenization {
  def main(args: Array[String]): Unit = {
    val students = ListStudent.students
    val teachers = ListTeacher.teachers
    val courses = ListCourses.courses

    println("=== Teachers ===")
    teachers.foreach(t => println(t.displayInfo()))

    println("\n=== Students ===")
    students.foreach(s => println(s.displayInfo()))

    println("\n=== Enrolling all students ===")

    students.foreach { student =>
      val course = Random.shuffle(courses).head
      val teacherOpt = teachers.find(_.coursesTaught.exists(_.id == course.id))
      teacherOpt match {
        case Some(teacher) => student.enrollToCourse(course, teacher)
        case None => println(s"Для курсу ${course.title} немає викладача.")
      }
    }

    println("\n=== Grading students ===")

    teachers.foreach { teacher =>
      students.foreach { student =>
        teacher.coursesTaught.foreach { course =>
          if (student.enrolledCourses.exists(_.id == course.id)) {
            val grade = Random.between(60, 101)
            teacher.gradeStudent(student, course, grade)
          }
        }
      }
    }

    println("\n=== Final student info ===")
    students.foreach(s => println(s.displayInfo()))

    println("\n=== Final teacher info ===")
    teachers.foreach(t => println(t.displayInfo()))
  }
}
