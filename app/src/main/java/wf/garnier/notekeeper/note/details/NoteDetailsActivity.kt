package wf.garnier.notekeeper.note.details

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.note_details.*
import wf.garnier.notekeeper.NoteKeeperApplication
import wf.garnier.notekeeper.R
import wf.garnier.notekeeper.kotlin.InitOnceProperty
import wf.garnier.notekeeper.note.Note
import wf.garnier.notekeeper.note.NoteService

class NoteDetailsActivity : AppCompatActivity() {

    lateinit var noteService: NoteService
    private var note: Note by InitOnceProperty()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_details)
        noteService = (this.application as NoteKeeperApplication).noteService

        setNote()
    }

    private fun setNote() {
        note = noteService.findNote(intent.getIntExtra(NoteEditActivity.NOTE_ID_EXTRA, NoteEditActivity.NOTE_ID_DEFAULT))!!
        note_title.setText(note.title, TextView.BufferType.EDITABLE)
        note_content.setText(note.text, TextView.BufferType.EDITABLE)
    }
}
