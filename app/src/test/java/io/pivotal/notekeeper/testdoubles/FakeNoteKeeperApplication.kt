package io.pivotal.notekeeper.testdoubles

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.pivotal.notekeeper.NoteKeeperApplication
import io.pivotal.notekeeper.note.Note
import io.pivotal.notekeeper.note.NoteService

class FakeNoteKeeperApplication: NoteKeeperApplication() {
    override var noteService = mock<NoteService> {
        on { note(42) } doReturn Note(42, "Life, the Universe and Everything", "So long and thanks for all the fish")
        on { notes } doReturn (1..3).map { Note(it, "Life, volume $it", "So long and thanks for all the fish") }
    }
}