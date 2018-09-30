package wf.garnier.notekeeper.note.list

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import wf.garnier.notekeeper.R.id.card_preview
import wf.garnier.notekeeper.R.id.card_title
import wf.garnier.notekeeper.note.Note

class ViewHolder(val view: ConstraintLayout,
                 private val listener: RecyclerViewClickListener?
) : RecyclerView.ViewHolder(view), View.OnClickListener {
    override fun onClick(v: View) {
        listener?.invoke(note.id)
    }

    var note = Note(-1, "", "")
        set(value) {
            view.findViewById<TextView>(card_title).text = value.title
            view.findViewById<TextView>(card_preview).text = value.text
            field = value
        }

    init {
        view.setOnClickListener(this)
    }
}