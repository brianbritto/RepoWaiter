package pe.upn.waiter.Presenter

import pe.upn.waiter.Contract.Presenter.ILoginPresenter
import pe.upn.waiter.Contract.View.ILoginView

/**
 * Created by brianbritto on 25/05/17.
 */
class LoginPresenter(val view:ILoginView): ILoginPresenter{

    override fun signIn(userName: String, password: String) {
        view.navigateToChooseTableActivity()
    }

}