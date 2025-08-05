import Utils.getAmountWithCurrency

case class Basket(productsBasket: Map[Product, Int],
                  subtotal: Double,
                  totalDiscounts: Double,
                  total: Double,
                  discountsList: List[String]) {
  //method that prints the subtotal, discounts and Total
  def printTicket(): Unit = {
    //subtotal
    val subtotalCurrencyText = getAmountWithCurrency(subtotal)
    println(s"Subtotal: $subtotalCurrencyText")
    //discounts
    if (totalDiscounts == 0) println("(No offers available)")
    discountsList.map(println)
    //Total price
    val total = subtotal - totalDiscounts
    val totalCurrencyText = getAmountWithCurrency(total)
    println(s"Total price: $totalCurrencyText")
  }
}

object Basket {
  //Basket constructor
  def apply(products: Array[String]): Basket = {
    val productsBasket = getBasket(products)
    val subtotal = getBasketSubtotal(productsBasket)
    val (totalDiscounts, listDiscountsDone) = getDiscounts(productsBasket)
    val total = subtotal - totalDiscounts
    new Basket(productsBasket,
      subtotal,
      totalDiscounts,
      total,
      listDiscountsDone
    )
  }

  //gets all the products and returns the quantity by each type of product (group by product)
  def getBasket(args: Array[String]) = {
    args
      .map(x => (Product(x), 1))
      .groupBy(_._1)
      .map(x => x._1 -> x._2.size)
  }

  //calculates the subtotal price for the basket
  def getBasketSubtotal(basket: Map[Product, Int]) = {
    basket
      .map(x => (x._1.Price.get * x._2))
      .sum
  }

  //calculates the total discounts for the basket
  def getDiscounts(basket: Map[Product, Int]) = {
    val Discounts = Offers()
      .availableOffers
      .map(_(basket))
    val listDiscountsDone = Discounts.filter(_.DiscountValue > 0).map(_.DiscountDescription).toList
    (Discounts.map(_.DiscountValue).sum, listDiscountsDone)
  }
}