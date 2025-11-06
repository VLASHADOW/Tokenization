package tokenization.objects

import tokenization.classes.Course

object ListCourses {
  val courses: List[Course] = List(
    new Course("C1", "Scala Basics", 100, 30),
    new Course("C2", "Functional Programming", 120, 40),
    new Course("C3", "Databases for Developers", 90, 25),
    new Course("C4", "Distributed Systems", 150, 50),
    new Course("C5", "Frontend with React", 110, 35)
  )
}
