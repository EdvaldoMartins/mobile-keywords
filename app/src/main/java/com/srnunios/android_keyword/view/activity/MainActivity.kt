package com.srnunios.android_keyword.view.activity

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.text.Editable
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.CharacterStyle
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import com.srnunios.android_keyword.ValueScheme
import com.srnunios.android_keyword.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import com.srnunios.android_keyword.ValueScheme.Companion.ValueSchemeType
import com.srnunios.android_keyword.system.Constants
import java.lang.StringBuilder
import java.util.regex.Pattern

class MainActivity : AppCompatActivity(), TextWatcher {

    private fun MYKEYWORDS(): Pattern {
        val key_words: StringBuilder = StringBuilder()
        key_words.append("\\b(")
        key_words.append("Mobile|")
        key_words.append("Developer|")
        key_words.append("Android|")
        key_words.append("Xamarin forms|")
        key_words.append("java|")
        key_words.append("kotlin|")
        key_words.append("C#|")
        key_words.append("firebase|")
        key_words.append("creative|")
        key_words.append(")\\b")
        return Pattern.compile(key_words.toString())
    }
    protected fun remove(e: Editable, type: Class<out CharacterStyle>) {
        val style = e.getSpans<CharacterStyle>(0, e.length, type as Class<CharacterStyle>?)
        var index = style.size - 1
        while (index >= 0){
            var span = style[index];
            e.removeSpan(span)
            index --;
        }
    }
    protected var schemeList = ArrayList<ValueScheme>()

    protected fun addScheme(scheme: ValueSchemeType, pattern: Pattern? = null) {
        when (scheme) {
            ValueSchemeType.KEYWORDS -> {
                schemeList!!.add(ValueScheme(this, scheme))
                schemeList!!.add(
                    ValueScheme(
                        this,
                        ValueSchemeType.NUMERO_COMPILE
                    )
                )
            }
            ValueSchemeType.PHONE -> schemeList!!.add(
                ValueScheme(
                    this,
                    scheme
                )
            )
            ValueSchemeType.NUMERO_COMPILE -> schemeList!!.add(
                ValueScheme(
                    this,
                    scheme
                )
            )
            ValueSchemeType.IP_ADDRESS -> schemeList!!.add(
                ValueScheme(
                    this,
                    scheme
                )
            )
            ValueSchemeType.EMAIL_ADDRESS -> schemeList!!.add(
                ValueScheme(
                    this,
                    scheme
                )
            )
            ValueSchemeType.WEB_URL -> schemeList!!.add(
                ValueScheme(
                    this,
                    scheme
                )
            )
            ValueSchemeType.DOMAIN_NAME -> schemeList!!.add(
                ValueScheme(
                    this,
                    scheme
                )
            )
            ValueSchemeType.MY_KEYWORDS -> schemeList!!.add(
                ValueScheme(
                    this,
                    scheme,
                    pattern!!
                )
            )
            ValueSchemeType.NULL -> {
                if (schemeList != null)
                    schemeList!!.clear()
            }
        }

    }

    override fun afterTextChanged(s: Editable?) {
        editor.removeTextChangedListener(this)
        if(s != null){
            remove(s,ForegroundColorSpan::class.java)
        }

        for (scheme in schemeList!!) {


            val m = scheme.pattern!!.matcher(s)
            while (m.find()) {

                s!!.setSpan(
                    ForegroundColorSpan(scheme.cor), m.start(), m.end()
                    , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)



                if(scheme.valueSchemeType == ValueSchemeType.MY_KEYWORDS){
                    s.setSpan(
                        StyleSpan(Typeface.BOLD_ITALIC), m.start(), m.end()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

                }else{
                    s.setSpan(
                        StyleSpan(Typeface.BOLD), m.start(), m.end()
                        , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                }

            }
        }
        editor.addTextChangedListener(this)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    fun logs(tag : String ,  msg : String){
        Log.println(Log.ERROR,tag,msg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addScheme(ValueSchemeType.KEYWORDS)
        addScheme(ValueSchemeType.PHONE)
        addScheme(ValueSchemeType.WEB_URL)
        addScheme(ValueSchemeType.MY_KEYWORDS,MYKEYWORDS())
        editor.addTextChangedListener(this)
        editor.setText(Constants.code2)
    }
}
