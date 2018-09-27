package io.pivotal.notekeeper.note.details

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import io.pivotal.notekeeper.NoteKeeperApplication
import io.pivotal.notekeeper.R
import io.pivotal.notekeeper.kotlin.InitOnceProperty
import io.pivotal.notekeeper.note.Note
import io.pivotal.notekeeper.note.NoteService
import kotlinx.android.synthetic.main.note_content.*

class NoteActivity : AppCompatActivity() {

    lateinit var noteService: NoteService
    private var note: Note by InitOnceProperty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_content)
        noteService = (this.application as NoteKeeperApplication).noteService

        setNote()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val newTitle = note_title.text.toString()
        val newContent = note_content.text.toString()
        val newNote = note.copy(title = newTitle, text = newContent)
        noteService.saveNote(newNote)
    }

    private fun setNote() {
        note = noteService.findNote(intent.getIntExtra(NOTE_ID_EXTRA, NOTE_ID_DEFAULT))!!
        note_title.setText(note.title, TextView.BufferType.EDITABLE)
        note_content.setText(note.text, TextView.BufferType.EDITABLE)
    }

    companion object {
        val NOTE_ID_EXTRA = "NOTE_ID"
        val NOTE_ID_DEFAULT = -1
    }
}