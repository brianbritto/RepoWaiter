package pe.upn.waiter.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_list_order.*
import pe.upn.waiter.Model.Repository.OrderDetailDataSource
import pe.upn.waiter.R
import pe.upn.waiter.adapter.OrderDetailAdapter
import pe.upn.waiter.utils.navigate

class ListOrderActivity : AppCompatActivity() {

    val adapter by lazy { OrderDetailAdapter(OrderDetailDataSource.getOrdersDetail()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_order)

        initToolBar("Lista de pedidos")
        fab_addOrder.setOnClickListener { navigate<ListMenuActivity>() }
        rcy_orders.layoutManager = LinearLayoutManager(applicationContext)
        rcy_orders.setHasFixedSize(true)
        rcy_orders.adapter = adapter

    }

    private fun initToolBar(title: String) {
        setSupportActionBar(toolbar_LO as Toolbar?)
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
            R.id.item_menu_check -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.check_menu, menu)
        return true
    }
}
