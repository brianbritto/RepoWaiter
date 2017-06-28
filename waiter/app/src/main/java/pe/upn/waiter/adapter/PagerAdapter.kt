package pe.upn.waiter.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import pe.upn.waiter.Model.OrderDetail
import pe.upn.waiter.fragment.MenuFragment

/**
 * Created by brianbritto on 21/06/17.
 */
class PagerAdapter(fm: FragmentManager, var tabCount: Int, var menus:HashMap<Int,MutableList<OrderDetail>>) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        var fragment : Fragment
        when (position) {
            0 -> fragment = MenuFragment(menus[0] as MutableList<OrderDetail>)
            1 -> fragment = MenuFragment(menus[1] as MutableList<OrderDetail>)
            2 -> fragment = MenuFragment(menus[2] as MutableList<OrderDetail>)
            else -> return null
        }

        return fragment
    }

    //Overriden method getCount to get the number of tabs
    override fun getCount(): Int {
        return tabCount
    }


}