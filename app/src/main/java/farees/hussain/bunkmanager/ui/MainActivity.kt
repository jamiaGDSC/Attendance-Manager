package farees.hussain.bunkmanager.ui

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import farees.hussain.bunkmanager.R
import farees.hussain.bunkmanager.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.view.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var b : ActivityMainBinding
    private lateinit var viewModel: SubjectViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        viewModel = ViewModelProvider(this).get(SubjectViewModel::class.java)

        //navHeader settings
        var navHeader = b.navView.getHeaderView(0)
        var canBunkCount = navHeader.tvCanBunk
        var mustAttend = navHeader.tvMustAttend
        viewModel.subjectItems.observe(this) { it ->
            var bunkCount = 0
            var mustAttendCount = 0
            it.forEach {
                if((it.classesCanBeBunked ?: 0) > 0) bunkCount+= it.classesCanBeBunked ?: 0
                if((it.classesMustAttend ?: 0) > 0 && (it.classesCanBeBunked?:0)<=0) mustAttendCount+=it.classesMustAttend ?: 0
            }
            canBunkCount.apply {
                if(bunkCount>0) {
                    text = "Can Bunk : $bunkCount"
                    visibility = View.VISIBLE
                } else visibility = View.GONE
            }

            mustAttend.apply {
                if(mustAttendCount>0) {
                    text = "Must Attend : $mustAttendCount"
                    visibility = View.VISIBLE
                } else visibility = View.GONE
            }
        }

        //tool bar settings and navigation, drawer layout
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph, b.drawerLayout)
        NavigationUI.setupWithNavController(b.navView, navController)
        b.toolbar.apply {
            setupWithNavController(navController,appBarConfiguration)
            title = null
        }
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            b.toolbar.title = null
            when(destination.id){
                R.id.settingsFragment -> b.title.text = "Settings"
                R.id.classesFragment -> b.title.text = "Bunk Manager"
                R.id.timetableFragment -> b.title.text = "Time Table"
            }
        }

        // for notifications
        createNotificationChannel()
        makeNotification()

        //
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        b.toolbar.title = null
        return NavigationUI.navigateUp(navController,b.drawerLayout)
    }

    var CHANNEL_ID = "channelId"
    var CHANNEL_NAME = "makeAttendanceNow"

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
    private fun makeNotification(){
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run{
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }
        //todo fixing the notification icon color
        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Awesome Notification")
            .setContentText("This is content Text")
            .setSmallIcon(R.drawable.ic_app_icon)
            .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_app_icon))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .build()
        val notifcationManager = NotificationManagerCompat.from(this)
        notifcationManager.notify(0,  notification)
    }
}