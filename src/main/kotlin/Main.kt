fun main() {

    println("Быки и коровы")
    var chisl_com = enter_com()
    println(chisl_com)
    var chisl_pol = enter_pol().chisl_pol
}
class enter_pol {
    var  chisl_pol = ""
    init {
        var valid = false
        do {
            try {
                chisl_pol = readLine().toString()
                chisl_pol.toInt()
                if (chisl_pol.length == 4)
                    valid = true
                else
                    println("Ошибка. Введите четырехзначное число.")
            } catch (e: NumberFormatException) {
                println("Ошибка. Введите целое число.")
            }
        } while (!valid)
    }
}

val gener_com = mutableSetOf<String>()
fun enter_com(): String {
    var  number_com = ""
    do {
        number_com = (0 .. 9999).random().toString().padStart(4,'0')
    } while (number_com in gener_com)
    gener_com.add(number_com)
    return number_com
}