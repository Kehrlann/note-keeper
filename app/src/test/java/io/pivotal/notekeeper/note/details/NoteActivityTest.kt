package io.pivotal.notekeeper.note.details

import android.content.Intent
import android.widget.TextView
import io.pivotal.notekeeper.R
import io.pivotal.notekeeper.testdoubles.FakeNoteKeeperApplication
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(application = FakeNoteKeeperApplication::class)
class NoteActivityTest {
    @Test
    fun `it loads the content of the note`() {
        val buildActivity = Robolectric.buildActivity(NoteActivity::class.java, Intent().putExtra("NOTE_ID", 42)).setup().get()

        assertThat(buildActivity.findViewById<TextView>(R.id.note_title).text.toString()).isEqualTo("Life, the Universe and Everything")
        assertThat(buildActivity.findViewById<TextView>(R.id.note_content).text.toString()).isEqualTo("So long and thanks for all the fish")
    }
}
