package com.example.metadiumiot

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import androidx.appcompat.widget.AppCompatButton

class HomeDialog (context: Context)
{
    private val dialog = Dialog(context)
    private lateinit var onClickListener: OnDialogClickListener

    fun setOnClickListener(listener: OnDialogClickListener)
    {
        onClickListener = listener
    }

    fun showDialog()
    {
        dialog.setContentView(R.layout.place_dialog)
        dialog.window!!.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
        dialog.show()

//        val edit_name = dialog.findViewById<EditText>(R.id.name_edit)
        val finish_button = dialog.findViewById<AppCompatButton>(R.id.finish_button)
        val cancel_button = dialog.findViewById<AppCompatButton>(R.id.cancel_button)

        finish_button.setOnClickListener {
            dialog.dismiss()
        }
        cancel_button.setOnClickListener {
            dialog.dismiss()
        }

    }

    interface OnDialogClickListener
    {
        fun onClicked(name: String)
    }

}