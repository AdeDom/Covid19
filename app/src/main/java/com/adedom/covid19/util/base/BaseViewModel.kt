package com.adedom.covid19.util.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adedom.covid19.util.ApiException
import com.adedom.covid19.util.NoInternetException
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel : ViewModel(), CoroutineScope {

    private var job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    protected fun <T : Any> ioThenMain(work: suspend () -> T?, callback: suspend (T?) -> Unit) {
        launch {
            try {
                val data = CoroutineScope(Dispatchers.IO).async rt@{
                    return@rt work.invoke()
                }.await()
                callback(data)
            } catch (e: ApiException) {
                _error.value = e.message
            } catch (e: NoInternetException) {
                _error.value = e.message
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}
