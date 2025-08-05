import org.scalatest.funsuite.AnyFunSuite

class PriceBasketTests extends AnyFunSuite {
  // these values are used for the configurable/scalable tests
  val numApples = 101
  val listApples = List.fill(numApples)("Apples")
  val ApplesPrice = 100
  val AppleOffer = 0.9

  val numMilk = 200
  val listMilk = List.fill(numMilk)("Milk")
  val milkPrice = 130

  val numBread = 300
  val listBread = List.fill(numBread)("Bread")
  val breadPrice = 80

  val numSoup = 400
  val listSoup = List.fill(numSoup)("Soup")
  val soupPrice = 65

  test("Subtotal for Apples Milk Bread should be £3.10 and Total £3") {
    val ArrayProducts = Array("Apples", "Milk", "Bread")
    val basket = Basket(ArrayProducts)
    val basketSubtotal = basket.subtotal
    val basketTotal = basket.total
    assert(basketSubtotal == 310)
    assert(basketTotal == 300)

  }

  test("Subtotal and total for Milk should be £1.30") {
    val ArrayProducts = Array("Milk")
    val basket = Basket(ArrayProducts)
    val basketSubtotal = basket.subtotal
    val basketTotal = basket.total
    assert(basketSubtotal == 130)
    assert(basketTotal == 130)
  }

  test("empty basket Subtotal should be 0") {
    val ArrayProducts = Array.empty[String]
    val basket = Basket(ArrayProducts)
    val basketSubtotal = basket.subtotal
    val basketTotal = basket.total
    assert(basketSubtotal == 0)
    assert(basketTotal == 0)
  }

  test(s"configurable/scalable test for $numApples apples") {
    val ArrayProducts = listApples.toArray
    val basket = Basket(ArrayProducts)
    val basketSubtotal = basket.subtotal
    val basketTotal = basket.total
    assert(basketSubtotal == numApples * 100)
    assert(basketTotal == numApples * 90)
  }
  test(s"configurable/scalable test for $numMilk Milk") {
    val ArrayProducts = listMilk.toArray
    val basket = Basket(ArrayProducts)
    val basketSubtotal = basket.subtotal
    val basketTotal = basket.total
    assert(basketSubtotal == numMilk * 130)
    assert(basketTotal == numMilk * 130)
  }

  test(s"configurable/scalable test for $numBread Bread") {
    val ArrayProducts = listBread.toArray
    val basket = Basket(ArrayProducts)
    val basketSubtotal = basket.subtotal
    val basketTotal = basket.total
    assert(basketSubtotal == numBread * 80)
    assert(basketTotal == numBread * 80)
  }

  test(s"configurable/scalable test for $numSoup Soup") {
    val ArrayProducts = listSoup.toArray
    val basket = Basket(ArrayProducts)
    val basketSubtotal = basket.subtotal
    val basketTotal = basket.total
    assert(basketSubtotal == numSoup * 65)
    assert(basketTotal == numSoup * 65)
  }

  test(s"configurable/scalable test for all products: $numApples apples, $numMilk Milk, $numBread Bread, $numSoup Soup") {
    val ArrayApples = listApples.toArray
    val ArrayMilk = listMilk.toArray
    val ArrayBread = listBread.toArray
    val ArraySoup = listSoup.toArray

    val basket = Basket(ArrayApples ++ ArrayMilk ++ ArrayBread ++ ArraySoup)
    val basketSubtotal = basket.subtotal
    val basketTotal = basket.total

    assert(basketSubtotal ==
      numSoup * soupPrice +
        numBread * breadPrice +
        numMilk * milkPrice +
        numApples * ApplesPrice)

    val breadToDiscount = (numSoup / 2)
    assert(basketTotal ==
      numSoup * soupPrice +
        numBread * breadPrice - (Math.min(breadToDiscount, numBread) * (breadPrice / 2)) +
        numMilk * milkPrice +
        numApples * ApplesPrice * AppleOffer)
  }
}