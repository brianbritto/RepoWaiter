package pe.upn.waiter.Model.Repository

import pe.upn.waiter.Model.Menu

/**
 * Created by brianbritto on 21/06/17.
 */
object MenuDataSource {
    fun getMenu():MutableList<Menu>{
        val files = mutableListOf<Menu>()

        for(i in 0..30){
            val file = Menu("Ceviche de pescado", "Ceviche de pescado blanco fresco",
                            22.00+i, true)
            files.add(file)
        }
        return files
    }
}