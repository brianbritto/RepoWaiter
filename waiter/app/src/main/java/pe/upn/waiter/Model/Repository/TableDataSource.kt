package pe.upn.waiter.Model.Repository

import pe.upn.waiter.Model.Table

/**
 * Created by brianbritto on 21/06/17.
 */
object TableDataSource {
    fun getTables():MutableList<Table>{
        val files = mutableListOf<Table>()

        for(i in 1..30){
            val file = Table(i,6,"VIP","D")
            files.add(file)
        }
        return files
    }
}