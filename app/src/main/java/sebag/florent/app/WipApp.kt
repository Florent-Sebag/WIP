package sebag.florent.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import sebag.florent.data.di.dataModule
import sebag.florent.domain.di.domainModule
import sebag.florent.presentation.di.presentationModule

class WipApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WipApp)
            modules(
                dataModule,
                domainModule,
                presentationModule
            )
        }
    }
}