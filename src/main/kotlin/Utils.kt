object Utils {

    fun promptInput(prompt: String): String {
        print(prompt)
        return readlnOrNull()?.trim().orEmpty()
    }

    fun promptUniqueInput(prompt: String, existingItems: List<String>): String? {
        while (true) {
            val input = promptInput(prompt)
            if (input.equals("Назад", ignoreCase = true)) return null
            if (input.isNotEmpty() && !existingItems.contains(input)) return input
            println("Значение уже существует или некорректно. Попробуйте другое.")
        }
    }

    fun promptMenuSelection(prompt: String, pointsCount: Int): Int {
        while (true) {
            print(prompt)
            val input = readlnOrNull()?.toIntOrNull()
            if (input in 0 until pointsCount) return input ?: 0
            println("Некорректный ввод. Пожалуйста, выберите значение от 0 до ${pointsCount - 1}.")
        }
    }
}
