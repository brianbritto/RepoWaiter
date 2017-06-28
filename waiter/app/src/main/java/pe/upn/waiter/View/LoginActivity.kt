package pe.upn.waiter.View

import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import pe.upn.waiter.Contract.Presenter.ILoginPresenter
import pe.upn.waiter.Contract.View.ILoginView
import pe.upn.waiter.Model.Repository.DataSource
import pe.upn.waiter.Presenter.LoginPresenter
import pe.upn.waiter.utils.navigate
import pe.upn.waiter.utils.toast

class LoginActivity : AppCompatActivity() , ILoginView {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(pe.upn.waiter.R.layout.activity_login)

        val presenter : ILoginPresenter = LoginPresenter(this)
        btn_signIn.setOnClickListener { login(edt_userName.text.toString(), edt_password.text.toString()) }
    }

    override fun navigateToChooseTableActivity() {
        navigate<ChooseTableActivity>()
    }

    fun login(userName:String, password:String){
        DataSource.loadUsers()
        if (DataSource.login(userName, password)){
            toast("Bienvenido $userName")
            navigate<ChooseTableActivity>()
        }
        else
            toast("Usuario y/o contraseña incorrecta")
    }
}
