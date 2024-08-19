abstract class BaseMenu(private var title: String) {

    private var isRunning = true
    private val items = mutableListOf<Pair<String, () -> Unit>>()

    fun addItem(label: String, action: () -> Unit) {
        items.add(label to action)
    }

    fun show() {
        isRunning = true
        while (isRunning) {
            items.clear()
            initializeMenu()
            displayMenu()
            items[Utils.promptMenuSelection("Введите число: ", items.size)].second()
        }
    }

    fun stop() {
        isRunning = false
    }

    abstract fun initializeMenu()

    fun updateTitle(newTitle: String) {
        title = newTitle
    }

    private fun displayMenu() {
        println("\n$title")
        items.forEachIndexed { index, (label, _) -> println("$index. $label") }
    }
}
