package ez.invoice.jason.themegenerator

import android.app.Application

class BaseApplication : Application() {

    companion object {
        private var instances: BaseApplication? = null
        fun getInstance(): BaseApplication {
            if(instances == null) {
                synchronized(BaseApplication) {
                    if (instances == null) {
                        instances = BaseApplication()
                    }
                }
            }
            return instances!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instances = this
    }
}