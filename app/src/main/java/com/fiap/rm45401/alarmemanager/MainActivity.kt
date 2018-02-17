package com.fiap.rm45401.alarmemanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btIniciar.setOnClickListener{
            dispararAlarme()
        }
    }

    fun dispararAlarme() {
        val tempo = Integer.parseInt(etSegundos.text.toString())

        val intent = Intent(this, AlarmeReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        val alarmeManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        alarmeManager.set(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (tempo * 1000),
                pendingIntent)
    }
}
