package pe.upn.waiter.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_menu.view.*
import pe.upn.waiter.Model.OrderDetail
import pe.upn.waiter.R
import pe.upn.waiter.View.MenuDetailActivity
import pe.upn.waiter.utils.inflate
import pe.upn.waiter.utils.navigate

/**
 * Created by brianbritto on 21/06/17.
 */
class MenuAdapter(var ordersDetail: MutableList<OrderDetail>) : RecyclerView.Adapter<MenuAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(parent?.inflate(R.layout.item_menu))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(ordersDetail[position])

    override fun getItemCount() = ordersDetail.size


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(ordersDetail: OrderDetail) {
            itemView?.let{
                with(itemView) {
                    txt_nameLM.text = ordersDetail.menu.name
                    txt_priceLM.text = "${ordersDetail.menu.price}0"
                    //ordersDetail.amount = "${txt_amountLM}".toInt()
                    imv_removeLM.setOnClickListener {
                        if (ordersDetail.amount > 0)
                            ordersDetail.amount--
                        txt_amountLM.text = "${ordersDetail.amount}"
                    }
                    imv_addLM.setOnClickListener {
                        ordersDetail.amount++
                        txt_amountLM.text = "${ordersDetail.amount}"
                    }
                    setOnClickListener { context.navigate<MenuDetailActivity>() }
                }
            }
        }
    }
}