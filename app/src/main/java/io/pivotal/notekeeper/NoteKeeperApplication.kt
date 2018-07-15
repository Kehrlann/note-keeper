package io.pivotal.notekeeper

import android.app.Application
import io.pivotal.notekeeper.note.HardCodedNoteService
import io.pivotal.notekeeper.note.NoteService

//@Component(modules = [AndroidInjectionModule::class, AppModule::class])
//interface AppComponent
//
//@Module
//class AppModule (){
//    companion object {
//        @JvmStatic
//        @Provides
//        fun provideNoteService(): NoteService = HardCodedNoteService()
//    }
//}

open class NoteKeeperApplication: Application() {
    open var noteService: NoteService = HardCodedNoteService()
}