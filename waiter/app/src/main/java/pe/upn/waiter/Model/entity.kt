package pe.upn.waiter.Model

import java.util.*

/**
 * Created by brianbritto on 20/06/17.
 */

data class User(var userName: String, var password: String, var waiter: Waiter)

data class Waiter(var firstName: String, var lastName: String)

data class Table(var number:Int, var capacity: Int, var room: String, var state: String)

data class Menu(var name:String, var description:String, var price: Double, var state: Boolean = true)

data class OrderDetail(var menu:Menu, var amount:Int)

data class Order(var orderDetailList : MutableList<OrderDetail>, var date : Date = Date())
