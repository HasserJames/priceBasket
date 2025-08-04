object Utils {
  val CONVERSION_UNIT = 100

  def getAmountWithCurrency(amount: Double): String = {

    val totalCurrencyText = amount < CONVERSION_UNIT match {
      case true => s"${amount}p"
      case false => s"£${amount / CONVERSION_UNIT}"
    }
    totalCurrencyText
  }
}
