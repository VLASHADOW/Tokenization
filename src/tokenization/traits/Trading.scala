package tokenization.traits

import tokenization.classes.Token

trait Trading {
  def Buy(amount:Token): Unit
  def Sell(amount:Token): Unit
}
