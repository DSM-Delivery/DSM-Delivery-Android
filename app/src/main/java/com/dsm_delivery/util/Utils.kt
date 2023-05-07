package com.dsm_delivery.util

import android.widget.Toast

fun makeToast(context: Int, text: Int){
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
}