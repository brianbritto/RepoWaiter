package pe.upn.waiter.View

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_list_menu.*
import pe.upn.waiter.Model.OrderDetail
import pe.upn.waiter.Model.Repository.OrderDetailDataSource
import pe.upn.waiter.R
import pe.upn.waiter.adapter.PagerAdapter

class ListMenuActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {

    var menus : HashMap<Int, MutableList<OrderDetail>> = HashMap(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_menu)

        for (i in 0..2) menus[i] = OrderDetailDataSource.getOrdersDetail()

        initToolBar("Lista de menu")
        viewpager_LM.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs_LM))
        tabs_LM.setOnTabSelectedListener(this)
        viewpager_LM.adapter = PagerAdapter(supportFragmentManager, tabs_LM.tabCount,menus)
    }

    private fun initToolBar(title: String) {
        setSupportActionBar(toolbar_LM as Toolbar?)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setTitle(title)
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.item_menu_add -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.add_menu, menu)
        return true
    }

    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }

    override fun onTabSelected(tab: TabLayout.Tab) {
        viewpager_LM.setCurrentItem(tab.position)
    }
}
