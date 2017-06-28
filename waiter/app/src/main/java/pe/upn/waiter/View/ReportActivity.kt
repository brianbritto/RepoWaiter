package pe.upn.waiter.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_report.*
import lecho.lib.hellocharts.gesture.ContainerScrollType
import lecho.lib.hellocharts.gesture.ZoomType
import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener
import lecho.lib.hellocharts.model.Axis
import lecho.lib.hellocharts.model.Column
import lecho.lib.hellocharts.model.ColumnChartData
import lecho.lib.hellocharts.model.SubcolumnValue
import lecho.lib.hellocharts.util.ChartUtils
import pe.upn.waiter.R
import pe.upn.waiter.utils.toast
import java.util.*

class ReportActivity : AppCompatActivity() {

    var data: ColumnChartData? = null
    var hasAxes = true
    var hasAxesNames = true
    var hasLabels = true
    var hasLabelForSelected = true
    var isInteractive = true
    var zoomType : ZoomType = ZoomType.HORIZONTAL_AND_VERTICAL
    var isEnabled = true
    var type : ContainerScrollType = ContainerScrollType.HORIZONTAL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        initToolBar("Reporte de atenciones")

        chart.setOnValueTouchListener(ValueTouchListener())
        chart.setInteractive(isInteractive);
        chart.setZoomType(zoomType);
        chart.setContainerScrollEnabled(isEnabled, type);
        generateData()
    }

    private fun initToolBar(title: String) {
        setSupportActionBar(toolbar_report as Toolbar?)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setTitle(title)
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


    fun generateData() {
        val numSubcolumns = 1
        val numColumns = 10
        // Column can have many subcolumns, here by default I use 1 subcolumn in each of 8 columns.
        val columns = ArrayList<Column>()
        var values: MutableList<SubcolumnValue>
        for (i in 0..numColumns - 1) {

            values = ArrayList<SubcolumnValue>()
            if(i!=5)
                values.add(SubcolumnValue(Math.random().toFloat() * 40f + 5, ChartUtils.COLOR_RED))
            else
                values.add(SubcolumnValue(20f, ChartUtils.COLOR_GREEN))

            val column = Column(values)
            column.setHasLabels(hasLabels)
            column.setHasLabelsOnlyForSelected(hasLabelForSelected)
            columns.add(column)
        }

        data = ColumnChartData(columns)

        if (hasAxes) {
            val axisX = Axis()
            val axisY = Axis().setHasLines(true)
            axisX.textColor = ChartUtils.COLOR_VIOLET
            axisY.textColor = ChartUtils.COLOR_VIOLET
            axisX.textSize = 16
            axisY.textSize = 16
            if (hasAxesNames) {
                axisX.name = "Mozos"
                axisY.name = "N° Atenciones"
            }
            data?.setAxisXBottom(axisX)
            data?.setAxisYLeft(axisY)
        } else {
            data?.setAxisXBottom(null)
            data?.setAxisYLeft(null)
        }

        chart.columnChartData = data

    }

    private inner class ValueTouchListener : ColumnChartOnValueSelectListener {

        override fun onValueSelected(columnIndex: Int, subcolumnIndex: Int, value: SubcolumnValue) {
            applicationContext.toast("mozo #${columnIndex+1}")
        }

        override fun onValueDeselected() {

        }

    }

}
