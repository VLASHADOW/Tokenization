package tokenization.objects

import tokenization.classes.Token
import tokenization.traits.Trading

object Exchange extends Trading {
  private var _fiat: Double = _
  private var _token: Token = _
  private var _initial: Boolean = false

  def init(fiat:Double, token:Token): Unit = {
    if(!_initial) {
      this._fiat = fiat
      this._token = token
      this._initial = true
    }
    else {
      println("...")
    }
  }

  def GetTokenPrice(): Double = _token.Amount / this._fiat
  def GetInf(): (Double, String) = (_fiat, _token.TokenInfo())

  override def Buy(arg:Token): Unit = {
    if (_token.amount >= arg.amount) {
      _token = _token - arg
      _fiat = arg.amount * GetTokenPrice()
    }
    else {

    }
  }
  override def Sell(arg:Token): Unit = {
    _token += arg
    _fiat -= arg.amount * GetTokenPrice()
  }
}
