package com.kmm.moonflower.core.utilities

import platform.Foundation.NSString
import platform.Foundation.stringWithFormat

actual fun String.sharedFormat(vararg args: Any?): String {
    var returnString = ""
    val regEx = "%[sdf]".toRegex()
    if (regEx.containsMatchIn(this)) { // 포매팅 필요한경우만 처리
        val singleFormats = regEx.findAll(this).map {
            it.groupValues.first()
        }.toList()
        val newStrings = this.split(regEx)

        //  기호 순서와 아규먼트의 순서를 정해서 해당 위치에 값을 변환
        for (i in 0 until newStrings.size.coerceAtMost(args.size)) {
            val arg = args[i]
            returnString += when (arg) {
                is Double -> {
                    NSString.stringWithFormat(newStrings[i] + singleFormats[i], args[i] as Double)
                }
                is Int -> {
                    NSString.stringWithFormat(newStrings[i] + singleFormats[i], args[i] as Int)
                }
                else -> {
                    NSString.stringWithFormat(newStrings[i] + "%@", args[i])
                }
            }
        }
        return returnString + newStrings.drop(args.size).joinToString("") //기호 뒤의 문자들이 누락되는걸 방지
    } else {
        return this
    }
}

/*
 * 아래는 시도해 보았던 코드
 * actual fun String.formatString(vararg args: Any?): String {
 *      val formattedArgs = args.joinToString(separator = ",") {
 *         it.toString() // $@로 변환해서 사용시 데이터 타입 그대로 노출되기떄문에 스트링 값으로 변환
 *      }
 *     return NSString.stringWithFormat(this, formattedArgs as Any)
 * }
 *
 *  위의 코드 문제점 :
 *  1. %s,%d 를 그대로 사용하면 인트의 경우 다른 숫자 , 스트링의 경우 wõø 으로 문자 나옴,
 *  2. %s,%d를 $@로 바꿔서 변수에 대응 해보았는데 %기호가 하나일떈 동작하지만 여러개일떈 한번에 모든 파라미터가 사용됨
 *
 */