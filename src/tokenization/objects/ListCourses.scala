package tokenization.objects

import tokenization.classes.Course

object ListCourses {
  val courses: List[Course] = List(
    new Course("C1", "Scala Basics", 100),
    new Course("C2", "Functional Programming", 120),
    new Course("C3", "Databases for Developers", 90),
    new Course("C4", "Distributed Systems", 150),
    new Course("C5", "Frontend with React", 110)
  )
}
