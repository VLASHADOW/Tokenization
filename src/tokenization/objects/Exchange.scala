package tokenization.objects

import tokenization.classes.Token
import tokenization.traits.Trading

object Exchange extends Trading {
  private var _fiat: Double = _
  private var _token: Token = _
  private var _initial: Boolean = false

  def init(fiat: Double, token: Token): Unit = this.synchronized {
    if (!_initial) {
      this._fiat = fiat
      this._token = token
      this._initial = true
    } else {
      println("Exchange already initialized.")
    }
  }

  def GetTokenPrice(): Double = this.synchronized {
    _token.Amount / this._fiat
  }

  override def Buy(arg: Token): Unit = this.synchronized {
    if (_token.Amount >= arg.Amount) {
      val newAmount = _token.Amount - arg.Amount
      _token = new Token(newAmount, _token.Symb)

      _fiat = _fiat + (arg.Amount * (_token.Amount.toDouble / _fiat))
    } else {
      println("Exchange: Not enough tokens!")
    }
  }

  override def Sell(arg: Token): Unit = this.synchronized {
    val newAmount = _token.Amount + arg.Amount
    _token = new Token(newAmount, _token.Symb)
  }
}