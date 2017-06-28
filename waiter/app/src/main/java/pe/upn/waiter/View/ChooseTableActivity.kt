package pe.upn.waiter.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_choose_table.*
import pe.upn.waiter.Model.Repository.TableDataSource
import pe.upn.waiter.R
import pe.upn.waiter.adapter.TableAdapter
import pe.upn.waiter.utils.navigate

class ChooseTableActivity : AppCompatActivity() {

    val adapter by lazy { TableAdapter(TableDataSource.getTables()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_table)

        initToolBar("Elegir Mesa")
        rcy_tables.layoutManager = GridLayoutManager(applicationContext,3)
        rcy_tables.setHasFixedSize(true)
        rcy_tables.itemAnimator = DefaultItemAnimator()
        rcy_tables.adapter = adapter
    }

    private fun initToolBar(title: String) {
        setSupportActionBar(toolbar_CT as Toolbar?)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setTitle(title)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.item_menu_profile ->{
                navigate<ProfileActivity>()
                return true
            }
            R.id.item_menu_report ->{
                navigate<ReportActivity>()
                return true
            }
            R.id.item_menu_signout ->{
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
