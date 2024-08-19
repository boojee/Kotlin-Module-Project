class ViewNoteMenu(private val archive: Archive, private val noteIndex: Int) :
    BaseMenu("Содержание заметки: ${archive.notes[noteIndex].content}") {

    override fun initializeMenu() {
        addItem("Редактировать заметку") { editNoteContent() }
        addItem("Назад") { stop() }
    }

    private fun editNoteContent() {
        val content = Utils.promptInput("Введите новый текст заметки (или 'Назад' для возврата): ")
        if (content.isNotEmpty()) {
            archive.notes[noteIndex].content = content
            updateTitle("Содержание заметки: $content")
            println("Заметка обновлена.")
        }
    }
}
