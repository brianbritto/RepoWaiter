package pe.upn.waiter.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_table.view.*
import pe.upn.waiter.Model.Table
import pe.upn.waiter.R
import pe.upn.waiter.View.ListOrderActivity
import pe.upn.waiter.utils.inflate
import pe.upn.waiter.utils.navigate

/**
 * Created by brianbritto on 21/06/17.
 */
class TableAdapter(val tables: MutableList<Table>) : RecyclerView.Adapter<TableAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(parent?.inflate(R.layout.item_table))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(tables[position])

    override fun getItemCount() = tables.size


    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(table: Table) {
            itemView?.let{
                with(itemView) {
                    txt_table.text = "${table.number}"
                    if (table.state == "D")
                        imv_table.setBackgroundColor(R.color.holo_blue_dark)
                    else
                        imv_table.setBackgroundColor(R.color.holo_red_dark)
                    setOnClickListener { context.navigate<ListOrderActivity>() }
                }
            }
        }
    }
}