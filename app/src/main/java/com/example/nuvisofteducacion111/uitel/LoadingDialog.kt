package com.example.nuvisofteducacion111.uitel

import android.app.Activity
import android.app.AlertDialog
import com.example.nuvisofteducacion111.R

class LoadingDialog(val mActivity:Activity) {
    private lateinit var isdialog:AlertDialog
    fun starLoading(){
        val infalter = mActivity.layoutInflater
        val dialodView = infalter.inflate(R.layout.loading_item,null)
        val bulider = AlertDialog.Builder(mActivity)
       bulider.setView(dialodView)
        bulider.setCancelable(false)
        isdialog= bulider.create()
        isdialog.show()
    }
    fun isDismiss(){
        isdialog.dismiss()
    }
}