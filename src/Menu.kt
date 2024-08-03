class Menu {

    fun menuList() {

        val PizzamenuList = mutableListOf<String>()

        PizzamenuList.add("1.Chicken Tikka (Party Size), 2000")
        PizzamenuList.add("2.Chicken Tikka (Large Size), 1700")
        PizzamenuList.add("3.Chicken Tikka(Medium Size) ,1300")
        PizzamenuList.add("4.Chicken Tikka(Small Size), 800")
        PizzamenuList.add("5.Lazania (Party Size) , 2300")
        PizzamenuList.add("6.Lazania (Large Size) , 2000")
        PizzamenuList.add("7.Lazania (Medium Size) , 1600")
        PizzamenuList.add("8.Lazania (Small Size) , 1200")



        val ZingerBurgerList = mutableListOf<String>()
        ZingerBurgerList.add("9.Zinger Burger  , 499")
        ZingerBurgerList.add("10.Mighty Zinger , 699")
        ZingerBurgerList.add("11.Double Decker, 999")


        PizzamenuList.forEach {
            println(it)
        }

        ZingerBurgerList.forEach {
            println(it)
        }


    }


    fun AddOnes() {
        println("1. Add Extra Cheese (70 Rs)")
        println("2.Add Soft Drinks 345 ml (80 Rs)")
    }

}