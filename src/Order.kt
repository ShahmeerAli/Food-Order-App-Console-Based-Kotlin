
/*
 have made this  data class to
 see the history of the user and order
 */

data class Order(
   var address: Address,
    var order: List<String>,
    var Bill:Int,
    var Payment:PaymentMethod

    ) {
}