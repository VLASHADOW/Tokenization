package tokenization.objects

import tokenization.classes.{Course, Student, Teacher}

import scala.util.Random

object CourseAssigner {

  def assignCoursesToTeachers(teachers: List[Teacher], courses: List[Course]): Unit = {
    teachers.foreach { teacher =>
      val numCourses = scala.util.Random.between(1, 3)
      val selected = scala.util.Random.shuffle(courses).take(numCourses)
      selected.foreach(teacher.assignCourse)
    }
  }

  def assignCoursesToStudents(students: List[Student], courses: List[Course]): Unit = {
    students.foreach { student =>
      val numCourses = Random.between(1, 4)
      val selected = Random.shuffle(courses).take(numCourses)
      selected.foreach(student.addCourse)
    }
  }

  def assignRandomGrades(students: List[Student]): Unit = {
    students.foreach { student =>
      student.enrolledCourses.foreach { courseId =>
        val grade = Random.between(60, 101)
        student.addGrade(courseId, grade)
      }
    }
  }
}
