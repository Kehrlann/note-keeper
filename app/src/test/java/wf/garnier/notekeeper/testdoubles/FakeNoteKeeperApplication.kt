package wf.garnier.notekeeper.testdoubles

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import wf.garnier.notekeeper.NoteKeeperApplication
import wf.garnier.notekeeper.note.Note
import wf.garnier.notekeeper.note.NoteService

class FakeNoteKeeperApplication: NoteKeeperApplication() {
    override var noteService = mock<NoteService> {
        on { findNote(42) } doReturn Note(42, "Life, the Universe and Everything", "So long and thanks for all the fish")
        on { notes } doReturn (1..3).map { Note(it, "Life, volume $it", "So long and thanks for all the fish") }
    }
}