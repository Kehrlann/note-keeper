package wf.garnier.notekeeper

import android.support.v7.widget.RecyclerView
import wf.garnier.notekeeper.note.list.NoteListActivity
import wf.garnier.notekeeper.testdoubles.FakeNoteKeeperApplication
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.RuntimeEnvironment
import android.content.Intent
import org.robolectric.Shadows.shadowOf
import wf.garnier.notekeeper.note.details.NoteDetailsActivity
import wf.garnier.notekeeper.note.details.NoteEditActivity
import wf.garnier.notekeeper.note.details.NoteEditActivityTest


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
@Config(application = FakeNoteKeeperApplication::class)
class NoteListActivityTest {
    @Test
    fun `displays a list of cards`() {
        val mainActivity = Robolectric.setupActivity(NoteListActivity::class.java)
        val recyclerView: RecyclerView = mainActivity.findViewById(R.id.note_list)
        assertThat(recyclerView).isNotNull
        assertThat(recyclerView.childCount).isEqualTo(3)
    }

    @Test
    fun `displays the card details when clicking on a card`() {
        val mainActivity = Robolectric.setupActivity(NoteListActivity::class.java)
        val recyclerView: RecyclerView = mainActivity.findViewById(R.id.note_list)
        recyclerView.findViewHolderForLayoutPosition(0).itemView.performClick()

        val expectedIntent = Intent(mainActivity, NoteDetailsActivity::class.java)
        val actual = shadowOf(RuntimeEnvironment.application).nextStartedActivity
        assertThat(actual.component).isEqualTo(expectedIntent.component)
        assertThat(actual.extras.getInt(NoteEditActivity.NOTE_ID_EXTRA)).isEqualTo(1)
    }
}
