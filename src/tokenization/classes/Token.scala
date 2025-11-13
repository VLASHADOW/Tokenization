package tokenization.classes

class Token(var amount:Int, var symb:String) {
  private var _amount:Int = amount
  private var _symb:String = symb

  def Amount: Int = _amount
  def Symb: String = _symb

  def AddAmount(arg:Int): Unit = {
    _amount = _amount + arg
  }

  def TokenInfo(): String = "Amount: " + _amount + _symb

  def +(value:Token): Token = {
    if(this.symb == value.symb)
      new Token(this._amount + value._amount, this._symb)
    else
      throw new IllegalArgumentException("Not match token symb!")
  }

  def -(value:Token): Token = {
    if(this.symb == value.symb)
      new Token(this._amount - value._amount, this._symb)
    else
      throw new IllegalArgumentException("Not match token symb!")
  }

  override def toString: String = s"${_amount}${_symb}"
}
