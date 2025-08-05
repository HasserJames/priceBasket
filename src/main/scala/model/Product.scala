case class Product(Name: String, Price: Option[Double], ProductUnit: Option[String])

object Product {
  //TO DO, get price list from file or database
  val MAP_PRODUCT_PRICE: Map[String, Double] = Map(
    "soup" -> 65,
    "bread" -> 80,
    "milk" -> 130,
    "apples" -> 100
  )
  //TO DO, get unit list from file or database
  val MAP_PRODUCT_UNIT: Map[String, String] = Map(
    "soup" -> "tin",
    "bread" -> "loaf",
    "milk" -> "bottle",
    "apples" -> "bag"
  )
  //Product constructor
  def apply(Name: String): Product = {
    new Product(Name.toLowerCase(), getProductPrice(Name), getProductUnit(Name))
  }

  def getProductPrice(ProductName: String): Option[Double] = {
    MAP_PRODUCT_PRICE
      .get(ProductName.toLowerCase)
  }

  def getProductUnit(ProductName: String): Option[String] = {
    MAP_PRODUCT_UNIT
      .get(ProductName.toLowerCase)
  }
}