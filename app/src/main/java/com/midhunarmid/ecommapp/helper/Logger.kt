package com.midhunarmid.ecommapp.helper

import android.util.Log

/**
 * This class is created to provide the simple [Log] methods.
 * The logging will work only if the *isDebugMode* flag variable of this class is set to true.
 * <br></br><br></br>
 * **Usage Examples:**
 * <br></br>
 * `
 *  * Logger.i(tag, msg)
 *  * Logger.e(tag, msg)
 *  * Logger.d(tag, msg)
 *  * Logger.v(tag, msg)
 *  * Logger.w(tag, msg)
` *
 * <br></br><br></br>
 *
 * @author Midhun
 */
object Logger {
    fun i(tag: String?, msg: String?) {
        debugMode {
            Log.i(tag ?: "NULL TAG", msg ?: "NULL MESSAGE")
        }
    }

    fun e(tag: String?, msg: String?) {
        debugMode {
            Log.e(tag ?: "NULL TAG", msg ?: "NULL MESSAGE")
        }
    }

    fun d(tag: String?, msg: String?) {
        debugMode {
            Log.d(tag ?: "NULL TAG", msg ?: "NULL MESSAGE")
        }
    }

    fun v(tag: String?, msg: String?) {
        debugMode {
            Log.v(tag ?: "NULL TAG", msg ?: "NULL MESSAGE")
        }
    }

    fun w(tag: String?, msg: String?) {
        debugMode {
            Log.w(tag ?: "NULL TAG", msg ?: "NULL MESSAGE")
        }
    }

    fun printStackTrace(e: Exception?) {
        debugMode {
            e?.printStackTrace()
        }
    }

    fun printStackTrace(t: Throwable?) {
        debugMode {
            t?.printStackTrace()
        }
    }
}
