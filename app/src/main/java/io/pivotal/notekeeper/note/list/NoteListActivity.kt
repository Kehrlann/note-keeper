package io.pivotal.notekeeper.note.list

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import io.pivotal.notekeeper.BaseActivity
import io.pivotal.notekeeper.NoteKeeperApplication
import io.pivotal.notekeeper.R
import io.pivotal.notekeeper.note.details.NoteActivity
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*


class NoteListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val noteService = (this.application as NoteKeeperApplication).noteService

        val that = this
        setContentView(R.layout.content_main)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        note_list.layoutManager = LinearLayoutManager(this)
        note_list.adapter = NoteListAdapter(
                noteService,
                { position ->
                    val intent = Intent(that, NoteActivity::class.java)
                    intent.putExtra(NoteActivity.NOTE_ID_EXTRA, position)
                    startActivity(intent)
                }
        )
    }

    override fun onResume() {
        super.onResume()
        // required so that the list view updates when we press back on a note details view
        note_list.adapter.notifyDataSetChanged()
    }
}