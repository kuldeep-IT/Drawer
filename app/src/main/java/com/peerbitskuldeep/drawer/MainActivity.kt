package com.peerbitskuldeep.drawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        var toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.draw_open,
            R.string.draw_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        //NavView
        navView.bringToFront()
        navView.setNavigationItemSelectedListener(this)
        navView.setCheckedItem(R.id.home_menu)

        //hide or show items
        var menu = navView.menu
        menu.findItem(R.id.logout_menu).setVisible(false)

        cardDept.setOnClickListener {
            dept()
        }

        cardProfile.setOnClickListener {
            details()
        }

        cardSetting.setOnClickListener {
            setting()
        }
    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.home_menu -> drawerLayout.closeDrawer(GravityCompat.START)

            R.id.myDetails_menu -> {
                details()
            }
            R.id.dept_menu -> {
              dept()
            }
            R.id.settings_menu -> {
                setting()
            }

        }

        return true
    }

    private fun dept()
    {
        Toast.makeText(this, "My Dept!!", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MyDept::class.java))
    }

    private fun setting()
    {
        Toast.makeText(this, "Settings!!", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, Settings::class.java))
    }

    private fun details()
    {
        Toast.makeText(this, "My Details!!", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MyDetails::class.java))
    }
}