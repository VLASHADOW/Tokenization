package tokenization.classes

import tokenization.objects.CourseAssigner
import tokenization.objects.ListCourses

class Course(val id: String, val title: String, val credits: Int, val price: Int, val duration: Int) {
  private var listStudents: List[Student] = List.empty
  private var listTeachers: List[Teacher] = List.empty

  def GetListStudents: List[Student] = listStudents

  def AssignStudentsToCourse(students: List[Student]): Unit = {
    CourseAssigner.assignCoursesToStudents(listStudents, ListCourses.courses)
  }

  def AssignTeacherToCourse(teacher: Teacher): Unit = {
    CourseAssigner.assignCoursesToTeachers(listTeachers, ListCourses.courses)
  }

  override def toString: String = s"$id: $title ($credits credits, price: $price USD)"
}
