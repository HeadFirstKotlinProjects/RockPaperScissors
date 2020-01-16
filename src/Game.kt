fun main(){
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(gameChoice, userChoice)
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoise = ""

    while(!isValidChoice) {
        //Ask user for their choice
        print("Please enter one of the following:")
        for (item in optionsParam) print(" $item")
        println(".")

        //Read user input
        val userInput = readLine()

        //Validate user input
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoise = userInput
        }else println("You must enter a valid choice.")
    }
    return userChoise
}

fun printResult(gameChoice:String, userChoice:String){
    val result: String
    println("User's $userChoice vs CPU's $gameChoice")
    if ( userChoice == gameChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
            (userChoice == "Paper" && gameChoice == "Rock") ||
            (userChoice == "Scissors" && gameChoice == "Paper")) result = "You WIN!"
    else result = "You LOSE!"
    println(result)
}

