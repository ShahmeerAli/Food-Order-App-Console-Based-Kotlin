class Address(
    private var Firstname: String = "null",
    private var MiddleName:String="null",
    private var LastName: String = "null,",
    private var contact: String = "null",
    private var street: Int = 0,
    private var area:String="null",
    private var city: String = "null",
    private var State: String = "null"

) {


    private fun setFirstName(name:String){
        Firstname=name
    }

    private fun getFirstName():String{
        return Firstname
    }

    private fun setLastName(LastName: String){
        this.LastName=LastName
    }

    private fun getLastName():String{
        return LastName
    }

    private fun setContact(contact:String){
        this.contact=contact
    }

    private fun getContact():String{
        return contact
    }


    private fun setStreet(street: Int){
        this.street=street
    }

    private fun getStreet():Int{
        return street
    }

    private fun setArea(area: String){
        this.area=area
    }

    private fun getArea():String{
        return area
    }

    private fun setCity(city: String){
        this.city=city
    }

    private fun getCity():String{
        return city
    }

    private fun setState(State: String){
        this.State=State
    }

    private fun getState():String{
        return State
    }



    override fun toString(): String {
        val details = "" +
                "\nName : ${Firstname}  ${MiddleName} ${LastName} " +
                "Contact : ${contact}" +
                " \nStreet : ${street}" +
                "  Area : ${area} City : ${city} \n State : ${State}  "

        return details
    }
}