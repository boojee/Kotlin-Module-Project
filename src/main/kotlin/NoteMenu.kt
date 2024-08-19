class NoteMenu(private val archive: Archive) : BaseMenu("Заметки в архиве \"${archive.name}\"") {

    override fun initializeMenu() {
        addItem("Создать заметку") { createNote() }
        archive.notes.forEachIndexed { index, note ->
            addItem(note.title) { ViewNoteMenu(archive, index).show() }
        }
        addItem("Назад") { stop() }
    }

    private fun createNote() {
        while (true) {
            val title = Utils.promptUniqueInput(
                "Введите название заметки (или 'Назад' для возврата): ",
                archive.getNoteTitles()
            )
            if (title == null) return

            val content =
                Utils.promptInput("Введите содержание заметки (или 'Назад' для возврата): ")
            if (content.equals("Назад", ignoreCase = true)) {
                continue
            }

            archive.addNote(Note(title, content))
            println("Заметка '$title' создана.")
            break
        }
    }
}
