package tokenization.classes

case class Course(id: String, title: String, credits: Int) {

  override def toString: String = s"$id: $title ($credits credits)"
}
