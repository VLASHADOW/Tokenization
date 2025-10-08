package tokenization.classes

import tokenization.objects.Exchange
import tokenization.traits.Trading

import java.time.{LocalDate, Period}

class Human(val id: String, val firstName: String, val lastName: String, val dateOfBirth: LocalDate, val email: String, val phoneNumber: String, var token:Token) extends Trading {

  def age: Int = Period.between(dateOfBirth, LocalDate.now()).getYears

  def GetToken: Token = token

  override def Buy(amount:Token): Unit = {
    Exchange.Buy(amount)
    token = token + amount
  }
  override def Sell(arg:Token): Unit = {
    if(token.amount >= arg.amount)
      token.amount += arg.amount
    else
      println("Not")
  }

  def displayInfo(): String = s"$firstName $lastName, $age years.\nContacts: $email, $phoneNumber."
}