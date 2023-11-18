var numGuess = ""
fun main() {
    val hod = (1..2).random()
    if (hod == 1)
        println("Вы ходите первым! Компьютер загадал 4-значное число. Попробуйте угадать его!")
    else
        println("Вы ходите вторым! Загадывайте 4-значное число. Компьютер попробует угадать его!")
    println("Введите свое секретное число: ")

    var fal = false
    while (!fal) {
        numGuess = readLine().toString()
        if (numGuess != null && isInputValid(numGuess)) {
            fal = true
        } else {
            println("Ошибка ввода. Попробуйте еще раз.")
        }
    }

    val com = getRandomNumber()

    var attempts = 0
    var guessed = false

    if (hod == 1) {
        while (!guessed) {
            print("Введите вашу попытку: ")
            val guess = readLine()
            if (guess != null && isInputValid(guess)) {
                attempts++
                val result_guess = compareNumbers(com, guess)
                println(
                    "Результат: быки - ${result_guess.bulls}, коровы - ${result_guess.cows}" +
                            "\n_______________________________"
                )
                if (result_guess.bulls == 4) {
                    println("Поздравляем, вы угадали число $com за $attempts попыток!")
                    guessed = true
                }

                val com_num = (0 .. 9999).random().toString().padStart(4,'0')
                println("Компьютер предполагает, что это число: ${com_num}")
                val result_com = compareNumbers(numGuess, com_num)
                println(
                    "Результат: быки - ${result_com.bulls}, коровы - ${result_com.cows}" +
                            "\n_______________________________"
                )
                if (result_com.bulls == 4) {
                    println("Поздравляем, вы угадали число $com за $attempts попыток!")
                    guessed = true
                }
            }
        }
    }
    else {
        while (!guessed) {

            val com_num = (0 .. 9999).random().toString().padStart(4,'0')
            val result_com = compareNumbers(numGuess, com_num)
            println("Компьютер предполагает, что это число: ${com_num}")
            println(
                "Результат: быки - ${result_com.bulls}, коровы - ${result_com.cows}" +
                        "\n_______________________________"
            )
            if (result_com.bulls == 4) {
                println("Поздравляем, вы угадали число $com за $attempts попыток!")
                guessed = true
            }

            print("Введите вашу попытку: ")
            val guess = readLine()
            if (guess != null && isInputValid(guess)) {
                attempts++
                val result_guess = compareNumbers(com, guess)
                println(
                    "Результат: быки - ${result_guess.bulls}, коровы - ${result_guess.cows}" +
                            "\n_______________________________"
                )
                if (result_guess.bulls == 4) {
                    println("Поздравляем, вы угадали число $com за $attempts попыток!")
                    guessed = true
                }
            }
        }
    }
}
fun getRandomNumber(): String {
    var number = ""
    do {
        number = (0 .. 9999).random().toString().padStart(4,'0')
    } while(number.toCharArray().distinct().size != 4)
    return number
}
fun isInputValid(input: String): Boolean {
    return input.length == 4 && input.toCharArray().distinct().size == 4 && input.all { it.isDigit() }
}

data class ComparisonResult(val bulls: Int, val cows: Int)
fun compareNumbers(com: String, guess: String): ComparisonResult {
    var bulls = 0
    var cows = 0

    for (i in com.indices) {
        if (com[i] == guess[i]) {
            bulls++
        } else if (guess.contains(com[i])) {
            cows++
        }
    }
    return ComparisonResult(bulls, cows)
}