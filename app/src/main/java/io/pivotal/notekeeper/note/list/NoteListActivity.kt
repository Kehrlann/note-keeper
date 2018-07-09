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
                { position -> startActivity(Intent(that, NoteActivity::class.java)) }
        )
    }
}