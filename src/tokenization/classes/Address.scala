package tokenization.classes

class Address(private var _country: String, private var _city: String) {

  private def country: String = _country

  private def city: String = _city

  override def toString: String = s"$country, $city"
}