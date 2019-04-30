package com.example.simpletimer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var stop = 0
    private var t = 0
    private val handel = Handler()
    private var s= 0
    private var m = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startTimer.setOnClickListener {
            when(t){
                0 ->
                {
                    viewM.text = "10"
                    viewS.text = "00"
                    t++
                    startTimer.text = "stop"
                    start()
                }
                1 ->
                {
                    t =2
                    stop =1
                    startTimer.text= "start"
                    handel.removeCallbacks(runnable)
                }
                2 ->
                {
                    t = 1
                    stop = 0
                    startTimer.text= "stop"
                    start()
                }
            }
        }


        reset.setOnClickListener {
            reset()
        }
    }

    private fun start(){
        if (m>= 0 && stop == 0) {
            handel.postDelayed(runnable, 1000)
        }
    }

    private fun reset(){
        stop =1
        startTimer.text= getString(R.string.min10)
        handel.removeCallbacks(runnable)
        viewM.text = "10"
        viewS.text = getString(R.string.s)
        s= 0
        m = 10
        t = 2
        start()
    }

    private val runnable = Runnable {

        if (m>=0 && s <= 0) {
            s = 60
            m--
        }

        if ( s >= 0) {
            s--
            viewM.text = m.toString()
            viewS.text = s.toString()
        }



        if(stop == 0) {
            start()
        }

    }

}

