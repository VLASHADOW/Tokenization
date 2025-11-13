package tokenization.objects

import tokenization.classes.{Student, Token}

object Platform {
  private var balance = new Token(100000, "USD")

  def getBalance: Token = balance

  def addRevenue(t: Token): Unit = balance = balance + t
  def subtractBalance(t: Token): Unit = balance = balance - t
  def hasBalance(amount: Int): Boolean = balance.Amount >= amount
}