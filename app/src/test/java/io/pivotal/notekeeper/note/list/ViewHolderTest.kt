package io.pivotal.notekeeper.note.list

import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.widget.TextView
import io.pivotal.notekeeper.R
import io.pivotal.notekeeper.note.Note
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class ViewHolderTest {

    private val view = LayoutInflater
            .from(RuntimeEnvironment.application.applicationContext)
            .inflate(R.layout.note_card, null, false) as ConstraintLayout

    @Test
    fun `displays a title and preview`() {
        val viewHolder = ViewHolder(view, null)
        viewHolder.note = Note(12, "Title", "My Text")

        assertThat(viewHolder.view.findViewById<TextView>(R.id.card_title).text).isEqualTo("Title")
        assertThat(viewHolder.view.findViewById<TextView>(R.id.card_preview).text).isEqualTo("My Text")
    }

    @Test
    fun `calls the xxClickListener when clicking on note`() {
        var handlerWasCalledWith: Int? = null
        val viewHolder = ViewHolder(view, { position -> handlerWasCalledWith = position })
        viewHolder.note = Note(12, "", "")

        viewHolder.onClick(view)

        assertThat(handlerWasCalledWith).isEqualTo(12)
    }
}
