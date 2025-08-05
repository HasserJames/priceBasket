object PriceBasketApp extends App {
  //Creates the basket getting all products and prints the ticket
  val basket = Basket(args)
  basket.printTicket()
}

