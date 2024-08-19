data class Archive(val name: String) {
    val notes = mutableListOf<Note>()

    fun addNote(note: Note) = notes.add(note)

    fun getNoteTitles() = notes.map { it.title }
}

data class Note(val title: String, var content: String)
