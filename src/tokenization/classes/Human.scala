package tokenization.classes

import tokenization.objects.Exchange
import tokenization.traits.Trading

import java.time.{LocalDate, Period}

abstract class Human(
                      val id: String,
                      val firstName: String,
                      val lastName: String,
                      val dateOfBirth: LocalDate,
                      val email: String,
                      val phoneNumber: String,
                      var token: Token
                    ) extends Trading {

  def age: Int = Period.between(dateOfBirth, LocalDate.now()).getYears

  def GetToken: Token = token

  override def Buy(amount: Token): Unit = {
    Exchange.Buy(amount)
    token = token + amount
  }

  override def Sell(amount: Token): Unit = {
    if (token.Amount >= amount.Amount) {
      token = token - amount
    } else {
      println(s"Not enough tokens to sell ${amount.Amount}${amount.Symb}.")
    }
  }

  def displayInfo(): String
}