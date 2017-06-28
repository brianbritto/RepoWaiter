package pe.upn.waiter.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_order_detail.view.*
import pe.upn.waiter.R
import pe.upn.waiter.Model.OrderDetail
import pe.upn.waiter.utils.inflate

/**
 * Created by brianbritto on 21/06/17.
 */
class OrderDetailAdapter(var orderDetails: MutableList<OrderDetail>) : RecyclerView.Adapter<OrderDetailAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(parent?.inflate(R.layout.item_order_detail))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(orderDetails[position])

    override fun getItemCount() = orderDetails.size


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(orderDetail: OrderDetail) {
            itemView?.let{
                with(itemView) {
                    txt_nameOD.text = orderDetail.menu.name
                    txt_amountOD.text = "${orderDetail.amount}"
                    txt_subTotalOD.text = "${orderDetail.amount * orderDetail.menu.price}"
                }
            }
        }
    }
}