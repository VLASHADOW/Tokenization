package tokenization.classes

class Course(val id: String, val title: String, val credits: Int, val price: Int) {
  override def toString: String = s"$id: $title ($credits credits, price: $price USD)"
}
