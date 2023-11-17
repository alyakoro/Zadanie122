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

val gener_com = mutableSetOf<String>()
fun enter_com(): String {
    var  number_com = ""
    do {
        number_com = (0 .. 9999).random().toString().padStart(4,'0')
    } while (number_com in gener_com)
    gener_com.add(number_com)
    return number_com
}
