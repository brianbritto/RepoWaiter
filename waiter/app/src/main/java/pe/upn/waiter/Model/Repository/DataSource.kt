package pe.upn.waiter.Model.Repository

import pe.upn.waiter.Model.User
import pe.upn.waiter.Model.Waiter

/**
 * Created by brianbritto on 28/06/17.
 */
object DataSource {
    var usuarios: MutableList<User> = ArrayList<User>()

    fun loadUsers(){
        usuarios.clear()
        usuarios.add(User("brianbritto", "britto", Waiter("Brian","Britto")))
        usuarios.add(User("augustoluna", "luna", Waiter("Augusto","Luna")))
        usuarios.add(User("miguelrumay", "rumay", Waiter("Miguel","Rumay")))
    }

    fun agregarUsuario(usuario: User){
        usuarios.add(usuario)
    }
    fun login(username:String, password:String): Boolean{
        var esUsuario:Boolean = false
        for(usuario in usuarios){
            if(usuario.userName == username && usuario.password == password)
            {
                esUsuario = true
                break
            }

        }
        return esUsuario
    }

}