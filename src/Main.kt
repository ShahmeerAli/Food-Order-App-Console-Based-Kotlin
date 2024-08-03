import java.util.Scanner
import java.util.Timer
import java.util.TimerTask

/*
 declaring these variables/classes
 inside the class and outside the main function
  to use them throughout the main class
 */

val scanner = Scanner(System.`in`)

/*
   Total Bill Variable
 */
var Bill: Int = 0
val CartList = mutableListOf<String>()

/*
  data class usage in OrderHistory
  list
 */
val OrderHistory = mutableListOf<Order>()

/*
  menu class
 */
val menu = Menu()
fun main() {


    val timer = Timer()


    do {
        println("********************************************Welcome**************************************************")
        println("Press 1 to order ")
        println("Press 2 to See Cart")
        println("Press 3 to Checkout")
        println("Press 4 to see the Order History")
        println("Press 7 to Leave the App")

        val option = scanner.nextInt()


        when (option) {
            1 -> {
                //displaying the food menu
                do {
                    println("Select Item from the Menu")
                    println("Press 0 to Go Back to the Main Menu")

                    menu.menuList()
                    val FoodOption = scanner.nextInt()
                    when (FoodOption) {
                        1 -> {
                            CartList.add("Chicken Tikka (Party Size) , 2000")
                            Bill += 2000
                        }

                        2 -> {
                            CartList.add("Chicken Tikka (Large Size), 1700")
                            Bill += 1700
                        }

                        3 -> {
                            CartList.add("Chicken Tikka(Medium Size) ,1300 ")
                            Bill += 1300
                        }

                        4 -> {
                            CartList.add("Chicken Tikka(Small Size), 800")
                            Bill += 800
                        }

                        5 -> {
                            CartList.add("Lazania (Party Size) , 2300")
                            Bill += 2300
                        }

                        6 -> {
                            CartList.add("Lazania (Large Size), 2000")
                            Bill += 2000
                        }

                        7 -> {
                            CartList.add("Lazania (Medium Size), 1600")
                            Bill += 1600
                        }

                        8 -> {
                            CartList.add("Lazania (Small Size) , 1200")
                            Bill += 1200
                        }

                        9 -> {
                            CartList.add("Zinger Burger , 499")
                            Bill += 499
                        }

                        10 -> {
                            CartList.add("Mighty Zinger, 699")
                            Bill += 699
                        }

                        11 -> {
                            CartList.add("Double Decker, 999")
                            Bill += 999
                        }

                        else -> {
                            println("The Item you selected does not Exist")
                        }

                    }


                } while (FoodOption != 0)

            }

            2 -> {
                /*
                for cart
                additional functionalities can be added
                depending on the demand
                 */
                var count: Int = 0

                println("Press 1 for additional  Add-ons")
                println("Press 2 to See the Cart")

                val option: Int = scanner.nextInt()
                if (option == 1) {
                    menu.AddOnes()
                    var addOnes: Int = scanner.nextInt()
                    when (addOnes) {
                        1 -> {
                            CartList.add("Extra-Cheese , 40")
                            Bill += 70
                        }

                        2 -> {
                            CartList.add("Soft-Drink, 80")
                            Bill += 80
                        }
                    }

                }


                CartList.forEach {
                    println(it)
                    count += 1
                }




                println("Total Bill: ")
                println(Bill)
                println("Total Items:")
                println(count)

            }

            3 -> {
                //for checkout
                if (CartList.isEmpty()) {

                    timer.schedule(object : TimerTask() {
                        override fun run() {
                            println("To Checkout First Add Something to Cart")
                            println("Redirected to Main Menu")

                        }


                    }, 1000)

                    main()
                } else {
                    println("To Checkout Please Enter your Details")
                    val userdetails = UserAddress()


                    /*
                     Calling the payment method from sealed payment
                     class
                     */

                    println("Enter Payment Method")
                    println("1. Bank Transfer")
                    println("2. Cash on Delivery")

                    val bank = PaymentMethod.BankTransfer()
                    val cash = PaymentMethod.Cash()
                    val payment = scanner.nextInt()

                    when (payment) {
                        1 -> {
                            val order = Order(userdetails, CartList.toList(), Bill, bank)
                            OrderHistory.add(order)
                        }

                        2 -> {
                            val order = Order(userdetails, CartList.toList(), Bill, cash)
                            OrderHistory.add(order)
                        }

                        else -> {
                            println("Unknown Payment Method")
                            main()
                        }
                    }

                    println("Confirm Checkout")
                    println("1.Yes")
                    println("2.No")
                    val answer: Int = scanner.nextInt()
                    when (answer) {
                        1 -> {
                            println(
                                "**************************************\n Your Order Has been Received \n*****************************************"
                            )
                            CartList.clear()
                        }

                        else -> {
                            println("Order Still Pending ")
                        }
                    }


                }

            }

            4 -> {
                println("**************************\nThis section is Specifically for the Admin\n****************************")
                println("Press 1 to continue")
                println("Press any digit to go back")
                val value: Int = scanner.nextInt()
                if (value == 1) {
                    println("Enter the Passkey")
                    val passKey: String = scanner.next()
                    if (passKey.contains("1234")) {
                        OrderHistory.forEach {
                            println(it)
                        }
                    } else {
                        println("Invalid Key")
                        main()
                    }
                } else {
                    main()
                }
            }

            7 -> {
                break
            }
        }


    } while (option != 7)


}


/*
  Now adding methods for userdetails and Payment
 */

private fun UserAddress(): Address {
    /*
      TOO MANY "scanner.nextLine()" have been added
      to avoid buffer in code
      this is specifically for intelliJ idea
      if you use different IDE you should remove
      the additional scanner.nextLine()
     */

    var street: Int = 0;
    println("Enter Your FirstName : ")
    val name: String = scanner.nextLine()
    scanner.nextLine()
    println("Enter your middle name")
    val middlename: String = scanner.nextLine()
    println("Enter your LastName : ")
    val lastName: String = scanner.nextLine()

    println("Enter your Contact No : ")
    var contact: String = scanner.nextLine()
    while (contact.length < 11) {
        println("Phone Number Cannot be less than 11 Digits ")
        contact = scanner.nextLine()
    }

    try {
        println("Enter your Street No : ")
        street = scanner.nextInt()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    println("Enter your Area : ")
    var area: String = scanner.nextLine()
    scanner.nextLine()

    println("Enter your City  : ")
    var city: String = scanner.nextLine()
    println("Enter your State : ")
    var state: String = scanner.nextLine()

    val address = Address(name, middlename, lastName, contact, street, area, city, state)

    return address


}

private fun PaymentMeth(paymentMethod: PaymentMethod): Any {

    /*
     this program uses sealed class
     */
    return when (paymentMethod) {
        is PaymentMethod.BankTransfer -> paymentMethod.showPayment()
        is PaymentMethod.Cash -> paymentMethod.showPayment()


    }
}



