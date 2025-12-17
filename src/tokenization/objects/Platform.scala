package tokenization.objects

import tokenization.classes.Token

object Platform {
  private var balance = new Token(100000, "USD")

  def getBalance: Token = this.synchronized { balance }

  // Синхронізуємо зміни балансу
  def addRevenue(t: Token): Unit = this.synchronized {
    balance = balance + t
  }

  def subtractBalance(t: Token): Unit = this.synchronized {
    balance = balance - t
  }

  def hasBalance(amount: Int): Boolean = this.synchronized {
    balance.Amount >= amount
  }
}