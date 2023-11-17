fun main() {

    println("Быки и коровы")
    var chisl_com = enter_com()
    println(chisl_com)

    var input: String
    var isValid = false

    do {
        print("Введите 4-значное число без повторяющихся цифр: ")
        input = readLine() ?: ""

        isValid = input.length == 4 && input.all { it.isDigit() } && input.toSet().size == 4

        if (!isValid) {
            println("Некорректный ввод. Пожалуйста, повторите попытку.")
        }
    } while (!isValid)

    val number_pol = input.toInt()
    println("Введенное число: $number_pol")

}
class _pol {
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

val gener_pol = mutableSetOf<String>()
fun enter_pol(): String {
    var  number_pol = ""
    do {
        number_pol = (0 .. 9999).random().toString().padStart(4,'0')
    } while (number_pol in gener_pol)
    gener_pol.add(number_pol)
    return number_pol
}