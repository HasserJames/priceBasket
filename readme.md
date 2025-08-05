# Price Basket Project

## Pre-Requisites

1.- SBT has to be installed

2.- JDK has to be installed

Note: Both SBT and JDk can be downloaded from: https://www.scala-sbt.org/1.x/docs/es/Installing-sbt-on-Windows.html


## Usage
To run the program It is needed to compile It first

1.- Please clone the project from github using command line:
`git clone https://github.com/HasserJames/priceBasket.git`

2.- Using comand line go to the folder priceBasket

3.- Execute command: `sbt "run Apples Milk Bread"`

4.- To add more products just add them to the right. Example: `sbt "run Apples Milk Bread Soup"`

## Tests

To run all the tests execute from the priceBasket folder: `sbt test`

## Configurable/scalable Tests

You can find Configurable/scalable Tests in the file `src/test/scala/PriceBasketTests.scala`

There are 5 Configurable/Scalable Tests:

1.- Configurable/scalable test for X number of apples

2.- Configurable/scalable test for Y number of Milk

3.- Configurable/scalable test for Z number of Bread

4.- Configurable/scalable test for X number of Soup

5.- Configurable/scalable test for all products: X number of apples, Y number of Milk, Z number of Bread, Z number of Soup

To change the number of any product just update the following variables in the file `src/test/scala/PriceBasketTests.scala`:

numApples

numMilk

numBread

numSoup

