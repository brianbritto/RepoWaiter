package pe.upn.waiter.Model.Repository

import pe.upn.waiter.Model.OrderDetail

/**
 * Created by brianbritto on 21/06/17.
 */
object OrderDetailDataSource {
    fun getOrdersDetail():MutableList<OrderDetail>{
        val files = mutableListOf<OrderDetail>()
        val menus = MenuDataSource.getMenu()

        for(i in 0..30){
            val file = OrderDetail(menus[i],i+1)
            files.add(file)
        }
        return files
    }
}