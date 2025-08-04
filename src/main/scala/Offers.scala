import Utils.getAmountWithCurrency

case class Offers(availableOffers: Seq[Map[Product, Int] => Discount])

object Offers {
  def apply(): Offers = {
    new Offers(Seq(getApplesDiscount, getBreadLoafDiscount))
  }

  //Apples have a 10% discount off their normal price this week
  val getApplesDiscount = (basket: Map[Product, Int]) => {
    val APPLES_DISCOUNT = 0.1 // TODO, get this from data base or file
    val apples = Product("Apples")
    val appleDiscount = basket.get(apples) match {
      case Some(applesQuantity) => apples.Price.get * APPLES_DISCOUNT * applesQuantity
      case _ => 0
    }
    val strDiscountDescription = if (appleDiscount > 0) {s"Apples 10% off: ${getAmountWithCurrency(appleDiscount)}"} else ""
    Discount(appleDiscount, strDiscountDescription)
  }

  //Buy 2 tins of soup and get a loaf of bread for half price
  val getBreadLoafDiscount = (basket: Map[Product, Int]) => {
    //get number of Soups
    val soup = Product("Soup")
    val soupNumber = basket.get(soup) match {
      case Some(soupQuantity) => soupQuantity
      case _ => 0
    }
    val breadToDiscount = (soupNumber / 2)
    //Get number of Breads
    val bread = Product("Bread")
    val breadNumber = basket.get(bread) match {
      case Some(breadQuantity) => breadQuantity
      case _ => 0
    }
    val breadLoafDiscount = Math.min(breadToDiscount, breadNumber) * (bread.Price.get / 2)
    if (breadLoafDiscount > 0) println(s"Bread 50% off: ${getAmountWithCurrency(breadLoafDiscount)}")

    val strDiscountDescription = if (breadLoafDiscount > 0) {s"Bread 50% off: ${getAmountWithCurrency(breadLoafDiscount)}"} else ""
    Discount(breadLoafDiscount, strDiscountDescription)
  }

}