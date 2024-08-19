class ArchiveMenu(private val archives: MutableList<Archive>) : BaseMenu("Список архивов") {

    override fun initializeMenu() {
        addItem("Создать архив") { createArchive() }
        archives.forEachIndexed { _, archive ->
            addItem(archive.name) { NoteMenu(archive).show() }
        }
        addItem("Выход") { stop() }
    }

    private fun createArchive() {
        val name = Utils.promptUniqueInput(
            "Введите имя архива (или 'Назад' для возврата): ",
            archives.map { it.name })
        if (name != null) {
            archives.add(Archive(name))
            println("Архив '$name' создан.")
        }
    }
}
