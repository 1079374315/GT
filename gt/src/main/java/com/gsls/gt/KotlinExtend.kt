package com.gsls.gt

/**
 * kotlin GT 扩展类
 */

fun Any.log(msg: Any){
    GT.log(msg.toString())
}

fun Any.err(msg: Any){
    GT.log(msg.toString())
}

