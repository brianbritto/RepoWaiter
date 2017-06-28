package pe.upn.waiter.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_menu.*
import pe.upn.waiter.R
import pe.upn.waiter.adapter.MenuAdapter
import pe.upn.waiter.Model.OrderDetail
import pe.upn.waiter.Model.Repository.OrderDetailDataSource

/**
 * Created by brianbritto on 21/06/17.
 */
class MenuFragment(var ordersDetail: MutableList<OrderDetail>) :Fragment() {

    val adapter by lazy { MenuAdapter(OrderDetailDataSource.getOrdersDetail()) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        rcy_menus.layoutManager = LinearLayoutManager(context)
        rcy_menus.setHasFixedSize(true)
        rcy_menus.itemAnimator = DefaultItemAnimator()
        rcy_menus.adapter = adapter
    }
}