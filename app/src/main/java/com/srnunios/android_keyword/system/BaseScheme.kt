//package com.srnunios.android_keyword
//
//import android.content.Context
//import android.graphics.Typeface
//import android.text.Editable
//import android.text.Spanned
//import android.text.TextWatcher
//import android.text.style.CharacterStyle
//import android.text.style.ForegroundColorSpan
//import android.text.style.StyleSpan
//import android.util.AttributeSet
//import android.widget.EditText
//import android.widget.LinearLayout
//import com.idea.nunioz.kitcode_input.view.SchemeView
//import java.lang.StringBuilder
//import java.util.ArrayList
//import java.util.regex.Pattern
//import kotlin.reflect.KClass
//
//open class BaseScheme : EditText {
//
//    protected var scheme_key_words: Boolean = false
//    protected var scheme_my: Boolean = false
//    protected var scheme_phone: Boolean = false
//    protected var scheme_email: Boolean = false
//    protected var scheme_url: Boolean = false
//    protected var scheme_domain: Boolean = false
//    protected var scheme_ip: Boolean = false
//    protected var value: String = String()
//
//    protected var _viewScheme: SchemeView? = null
//    protected var schemeList: ArrayList<ValueScheme>? = null
//    private var my_keywords: ArrayList<String> = ArrayList()
//
//
//    constructor(context: Context?) : super(context) {
//        this.my_keywords = ArrayList()
//    }
//
//    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
//        this.my_keywords = ArrayList()
//    }
//
//    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
//            : super(context, attrs, defStyleAttr) {
//        this.my_keywords = ArrayList()
//    }
//
//
//    protected val watcher = object : TextWatcher {
//        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//            _viewScheme!!.beforeTextChanged(s, start, count, after)
//        }
//
//        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//            _viewScheme!!.onTextChanged(s, start, before, count)
//        }
//
//        override fun afterTextChanged(editable: Editable) {
//          //  _viewScheme!!.removeSpan(editable,   ForegroundColorSpan::class.objectInstance)
//            for (scheme in schemeList!!) {
//                val m = scheme.pattern!!.matcher(editable)
//                while (m.find()) {
//                    editable.setSpan(
//                            ForegroundColorSpan(scheme.cor), m.start(), m.end()
//                            , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//
////                    editable.setSpan(
////                            StyleSpan(Typeface.BOLD), m.start(), m.end()
////                            , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//                }
//            }
//            _viewScheme!!.afterTextChanged(editable)
//        }
//    }
//
//    protected fun inputScheme(scheme: ValueSchemeType) {
//        addScheme(scheme, Pattern.compile(""))
//    }
//
//    protected fun inputScheme(scheme: ValueSchemeType, pattern: Pattern) {
//        if (this.schemeList == null) {
//            return
//        } else {
//            for (cs in schemeList!!) {
//                if (cs.sc === scheme) {
//                    return
//                }
//            }
//            addScheme(scheme, pattern)
//        }
//    }
//
//    protected fun addScheme(scheme: ValueSchemeType, pattern: Pattern) {
//
//
//        when (scheme) {
//            ValueSchemeType.KEYWORDS -> {
//                schemeList!!.add(ValueScheme(context, scheme))
//                schemeList!!.add(ValueScheme(context, ValueSchemeType.NUMERO_COMPILE))
//            }
//            ValueSchemeType.PHONE -> schemeList!!.add(ValueScheme(context, scheme))
//            ValueSchemeType.NUMERO_COMPILE -> schemeList!!.add(ValueScheme(context, scheme))
//            ValueSchemeType.IP_ADDRESS -> schemeList!!.add(ValueScheme(context, scheme))
//            ValueSchemeType.EMAIL_ADDRESS -> schemeList!!.add(ValueScheme(context, scheme))
//            ValueSchemeType.WEB_URL -> schemeList!!.add(ValueScheme(context, scheme))
//            ValueSchemeType.DOMAIN_NAME -> schemeList!!.add(ValueScheme(context, scheme))
//            ValueSchemeType.MY_KEYWORDS -> schemeList!!.add(ValueScheme(context, scheme, pattern))
//            ValueSchemeType.NULL -> {
//                if (schemeList != null)
//                    schemeList!!.clear()
//            }
//        }
//
//    }
//
//    public fun addKeyWords(str: String) {
//        this.my_keywords!!.add(str)
//    }
//
//    protected fun getKeyWords(): Pattern {
//        var ls: StringBuilder? = null
//        ls = StringBuilder()
//        for (str: String in my_keywords!!) {
//            ls.append(str)
//        }
//        return Pattern.compile(ls.toString())
//    }
//
//    public fun addKeyWords(list: List<String>) {
//        this.my_keywords = ArrayList(list)
//    }
//
//    protected fun removeSchemes() {
//        this.my_keywords!!.clear()
//    }
//
//    public fun scheme(sc: ValueSchemeType): BaseScheme {
//
//        if (sc == ValueSchemeType.NUMERO_COMPILE || sc == ValueSchemeType.KEYWORDS && !scheme_key_words) {
//            scheme_key_words = true
//        }
//        if (sc == ValueSchemeType.EMAIL_ADDRESS && !scheme_email) {
//            scheme_email = true
//        }
//        if (sc == ValueSchemeType.PHONE && !scheme_phone) {
//            scheme_phone = true
//        }
//        if (sc == ValueSchemeType.WEB_URL && !scheme_url) {
//            scheme_url = true
//        }
//        if (sc == ValueSchemeType.DOMAIN_NAME && !scheme_domain) {
//            scheme_domain = true
//        }
//        if (sc == ValueSchemeType.IP_ADDRESS && !scheme_ip) {
//            scheme_ip = true
//        }
//        if (sc == ValueSchemeType.MY_KEYWORDS && !scheme_my) {
//            scheme_my = true
//        }
////        Log.println(Log.ERROR,"scheme ","metodo scheme scheme_key_words "+scheme_key_words)
////        Log.println(Log.ERROR,"scheme ","metodo scheme scheme_domain "+scheme_domain)
////        Log.println(Log.ERROR,"scheme ","metodo scheme scheme_email "+scheme_email)
////        Log.println(Log.ERROR,"scheme ","metodo scheme scheme_ip "+scheme_ip)
////        Log.println(Log.ERROR,"scheme ","metodo scheme scheme_url "+scheme_url)
////        Log.println(Log.ERROR,"scheme ","metodo scheme scheme_my "+scheme_my)
////        Log.println(Log.ERROR,"scheme ","metodo scheme scheme_phone "+scheme_phone)
//        return this
//    }
//
//
//    interface MTD {
//        fun setValue(str: String): BaseScheme
//        fun main(attrs: AttributeSet?)
//        fun applyAttrs(attrs: AttributeSet?)
//    }
//
//    protected fun remove(e: Editable, type: Class<out CharacterStyle>) {
//        val style = e.getSpans<CharacterStyle>(0, e.length, type as Class<CharacterStyle>?)
//        for (span in style) {
//            e.removeSpan(span)
//        }
//    }
//}