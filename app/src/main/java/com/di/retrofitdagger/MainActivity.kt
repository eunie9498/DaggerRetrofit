package com.di.retrofitdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.di.retrofitdagger.di.DaggerNetworkComponent
import com.di.retrofitdagger.di.NetworkComponent
import com.di.retrofitdagger.retro.mainAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var api: mainAPI

    lateinit var component: NetworkComponent

    private val tvTitle: TextView by lazy {
        findViewById(R.id.tvTitle)
    }

    private val tvBlog: TextView by lazy {
        findViewById(R.id.tvBlog)
    }

    private val tvDate: TextView by lazy {
        findViewById(R.id.tvDate)
    }

    private val tvSum: TextView by lazy {
        findViewById(R.id.tvSum)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //di inject network
        component = DaggerNetworkComponent.builder().build()
        component.inject(this)

        testStart()
    }

    private fun testStart() {
        api.run {
            getTestData().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    tvTitle.text = it.title ?: "Empty Value"
                    tvBlog.text = it.blog ?: "Empty Value"
                    tvDate.text = it.date ?: "Empty Value"
                    tvSum.text = it.summary ?: "Empty Value"
                }, { e ->
                })
        }
    }
}