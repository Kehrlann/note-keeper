package wf.garnier.notekeeper.note.details

import android.content.Intent
import android.widget.TextView
import com.nhaarman.mockito_kotlin.verify
import wf.garnier.notekeeper.R
import wf.garnier.notekeeper.note.Note
import wf.garnier.notekeeper.testdoubles.FakeNoteKeeperApplication
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(application = FakeNoteKeeperApplication::class)
class NoteActivityTest {

    val activity by lazy {
        Robolectric
                .buildActivity(
                        NoteActivity::class.java,
                        Intent().putExtra("NOTE_ID", 42))
                .setup()
                .get()
    }

    val noteServiceMock = (RuntimeEnvironment.application as FakeNoteKeeperApplication).noteService

    @Test
    fun `it loads the content of the note`() {
        assertThat(activity.findViewById<TextView>(R.id.note_title).text.toString()).isEqualTo("Life, the Universe and Everything")
        assertThat(activity.findViewById<TextView>(R.id.note_content).text.toString()).isEqualTo("So long and thanks for all the fish")
    }

    @Test
    fun `it saves the content of the note on back`() {
        val noteTitle = activity.findViewById<TextView>(R.id.note_title)
        noteTitle.text = "New title"
        val noteContent = activity.findViewById<TextView>(R.id.note_content)
        noteContent.text = "New content"

        activity.onBackPressed()

        verify(noteServiceMock).saveNote(Note(42, "New title", "New content"))
    }
}
