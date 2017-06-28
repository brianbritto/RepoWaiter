package pe.upn.waiter.View

import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.elmargomez.typer.Font
import com.elmargomez.typer.Typer
import kotlinx.android.synthetic.main.activity_menu_detail.*
import pe.upn.waiter.R


class MenuDetailActivity : AppCompatActivity() {

    val EXTRA_IMAGE: String = "pe.upn.waiter.extraImage"
    val EXTRA_TITLE = "pe.upn.waiter.extraTitle"
    var itemTitle : String = "Ceviche de pescado"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_detail)

        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE)
        supportPostponeEnterTransition()

        collapsing_toolbar.title = itemTitle
        val font = Typer.set(this).getFont(Font.ROBOTO_MEDIUM)
        collapsing_toolbar.setExpandedTitleTypeface(font)

        initToolBar()
        supportStartPostponedEnterTransition()

    }

    private fun initToolBar() {
        setSupportActionBar(toolbar_MD as Toolbar?)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
