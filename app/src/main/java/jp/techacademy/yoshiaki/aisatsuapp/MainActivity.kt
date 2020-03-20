package jp.techacademy.yoshiaki.aisatsuapp

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.text.ParseException
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }

    //タイムダイアログ表示
    @SuppressLint("NewApi")
    public fun showTimePickerDialog() {
        val data1:String
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                var ans = aisat(hour.toString(),minute.toString()).ans
                text1.text=ans
            },
            13, 0, true
        )

        timePickerDialog.show()
    }




    class aisat(hour: String,minute:String) {
        constructor(data1:String,hour: String,minute: String) : this(hour,minute)
        var timej=hour.toInt()*60
        var ans2=aisatsu(timej)
        var ans=ans2

        fun aisatsu(timej:Int):String{
            this.timej=timej

            if(timej>=0&&timej<120) {
            ans2= "「こんばんわ」"

            }

            else if(timej>=120&&timej<600) {
            ans2 = "「おはよう」"

            }

            else if(timej>=600&&timej<1080) {
            ans2 = "「こんにちは」"

            }
            else if(timej>=1080&&timej<1440) {
            ans2 = "「こんばんは」"
            }
            return ans2
        }
    }
}





