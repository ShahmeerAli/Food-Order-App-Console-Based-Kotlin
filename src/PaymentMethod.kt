sealed class PaymentMethod {

    class BankTransfer : PaymentMethod() {
        fun showPayment(): String {
            return "Paid Through Bank Transfer"
        }

        /*
        overriding the toString to avoid
        hexadecimal values in the payment method
        because if not override here
        will lead to unwanted hexadecimal values in the output
        example :Payment=PaymentMethod$Cash@5a2e4553
         */

        override fun toString(): String {
            return showPayment()
        }
    }

    class Cash : PaymentMethod() {
        fun showPayment(): String {
            return "Paid in Cash"
        }

        override fun toString(): String {
            return showPayment()
        }
    }
}
