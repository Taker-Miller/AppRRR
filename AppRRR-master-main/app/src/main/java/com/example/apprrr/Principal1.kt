package com.example.apprrr

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.Insets
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class Principal1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal1)

        val tb = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(tb)

        val tl = findViewById<TabLayout>(R.id.tablayaout)
        tl.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {}

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val position = tab.position
                when (position) {
                    1 -> {
                        val rt = Reutilizacion()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.contenedor, rt)
                            .commit()
                    }
                    0 -> {
                        val c = Comunidad()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.contenedor, c)
                            .commit()
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.principal)) { v, insets ->
            val systemBars: Insets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nav = findViewById<NavigationView>(R.id.nav)
        nav.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.op9 -> {
                    Toast.makeText(applicationContext, "vas al plastico", Toast.LENGTH_SHORT).show()
                    val plasticoFragment = PlasticoFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contenedor, plasticoFragment)
                        .commit()
                }
                R.id.op10 -> {
                    Toast.makeText(applicationContext, "vas al papel y carton", Toast.LENGTH_SHORT).show()
                    val papelycartonFragment = PapelycartonFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contenedor, papelycartonFragment)
                        .commit()
                }
                R.id.op11 -> {
                    Toast.makeText(applicationContext, "vas al vidrio", Toast.LENGTH_SHORT).show()
                    val vidrioFragment = VidrioFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contenedor, vidrioFragment)
                        .commit()
                }
                R.id.op12 -> {
                    Toast.makeText(applicationContext, "vas a latas", Toast.LENGTH_SHORT).show()
                    val latasFragment = LatasFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contenedor, latasFragment)
                        .commit()
                }
                R.id.op13 -> {
                    Toast.makeText(applicationContext, "vas a otros residuos", Toast.LENGTH_SHORT).show()
                    val otrosResiduosFragment = OtrosresiduosFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contenedor, otrosResiduosFragment)
                        .commit()
                }
            }
            false
        }

        val dl = findViewById<DrawerLayout>(R.id.principal)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val toggle = ActionBarDrawerToggle(
            this,
            dl,
            R.string.abrir_drawer,
            R.string.cerrar_drawer
        )
        dl.addDrawerListener(toggle)
        toggle.syncState()

        tb.setNavigationOnClickListener {
            if (dl.isDrawerOpen(GravityCompat.START)) {
                dl.closeDrawer(GravityCompat.START)
            } else {
                dl.openDrawer(GravityCompat.START)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.op2 -> {
                Toast.makeText(this, "vas a la reutilización", Toast.LENGTH_SHORT).show()
                val rt = Reutilizacion()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, rt)
                    .commit()
            }
            R.id.op3 -> {
                Toast.makeText(this, "vas a la comunidad", Toast.LENGTH_SHORT).show()
                val c = Comunidad()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, c)
                    .commit()
            }
            R.id.op4 -> {
                Toast.makeText(this, "vas al plástico", Toast.LENGTH_SHORT).show()
                val plasticoFragment = PlasticoFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, plasticoFragment)
                    .commit()
            }
            R.id.op5 -> {
                Toast.makeText(this, "vas al papel y cartón", Toast.LENGTH_SHORT).show()
                val papelycartonFragment = PapelycartonFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, papelycartonFragment)
                    .commit()
            }
            R.id.op6 -> {
                Toast.makeText(this, "vas al vidrio", Toast.LENGTH_SHORT).show()
                val vidrioFragment = VidrioFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, vidrioFragment)
                    .commit()
            }
            R.id.op7 -> {
                Toast.makeText(this, "vas a latas", Toast.LENGTH_SHORT).show()
                val latasFragment = LatasFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, latasFragment)
                    .commit()
            }
            R.id.op8 -> {
                Toast.makeText(this, "vas a otros residuos", Toast.LENGTH_SHORT).show()
                val otrosResiduosFragment = OtrosresiduosFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.contenedor, otrosResiduosFragment)
                    .commit()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
