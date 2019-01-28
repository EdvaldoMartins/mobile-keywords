package com.srnunios.android_keyword

import android.content.Context
import java.util.regex.Pattern

/**
 * Created by Cajama on 02/02/2018.
 */
class ValueScheme {


    companion object {
        public enum class ValueSchemeType {
            KEYWORDS, PHONE, NUMERO_COMPILE,
            IP_ADDRESS, EMAIL_ADDRESS, WEB_URL, DOMAIN_NAME,MY_KEYWORDS,NULL
        }
    }

    public var pattern: Pattern? = null
    public var cor: Int = 0
    public var valueSchemeType: ValueSchemeType? = null


    constructor(c: Context, valueSchemeType: ValueSchemeType) {
        this.cor = Compile.color(c, valueSchemeType)
        this.pattern = Compile.panttern(valueSchemeType,null)
        this.valueSchemeType = valueSchemeType
    }

    constructor(c: Context, valueSchemeType: ValueSchemeType, pattern: Pattern) {
        this.cor = Compile.color(c, valueSchemeType)
        this.pattern = Compile.panttern(valueSchemeType,pattern)
        this.valueSchemeType = valueSchemeType
    }


}