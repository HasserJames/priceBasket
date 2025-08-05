object Utils {
  val CONVERSION_UNIT = 100

  //returns the amount adding p or £ according to the value and converted when necessary
  def getAmountWithCurrency(amount: Double): String = {
    val totalCurrencyText = amount < CONVERSION_UNIT match {
      case true => s"${amount.toInt}p"
      case false => {
        val amountFormat = f"${amount / CONVERSION_UNIT}%1.2f"
        s"£$amountFormat"
      }
    }
    totalCurrencyText
  }
}
