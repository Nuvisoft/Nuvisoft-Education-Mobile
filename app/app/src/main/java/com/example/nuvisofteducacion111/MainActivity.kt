package com.example.nuvisofteducacion111
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.nuvisofteducacion111.uitel.LoadingDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toogle =
            ActionBarDrawerToggle(this, Drawer_Layout, R.string.open_drawer, R.string.close_drawer)
        Drawer_Layout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, HomeFragment())
                        commit()
                    }
                }
                R.id.nav_asignaturas -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, AsignaturaFragment())
                        commit()
                    }
                }
                R.id.nav_notasactuales -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, NotaActualFragment())
                        commit()
                    }
                }
                R.id.nav_notasfinales -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, NotaFinalFragment())
                        commit()
                    }
                }
                R.id.nav_primer_parcial -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, PrimerParcialFragment())
                        commit()
                    }
                }
                R.id.nav_segundo_parcial -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, SegundoParcialFragment())
                        commit()
                    }
                }
                R.id.nav_tercer_parcial -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, TercerParcialFragment())
                        commit()
                    }
                }
                R.id.nav_cuarto_parcial -> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.fragmentContainerView, CuartoParcialFragment())
                        commit()
                    }


                }

            }
            Drawer_Layout.closeDrawer(GravityCompat.START)
            true


            val loading = LoadingDialog(mActivity = this)
            loading.starLoading()
            val handler = Handler()
            handler.postDelayed(object : Runnable {
                override fun run() {
                    loading.isDismiss()
                }

            }, 500)
        }



    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}







