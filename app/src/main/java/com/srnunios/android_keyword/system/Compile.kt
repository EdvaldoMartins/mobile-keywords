package com.srnunios.android_keyword

import android.content.Context
import android.support.v4.content.ContextCompat
import android.util.Patterns
import com.srnunios.android_keyword.ValueScheme.Companion.ValueSchemeType
import java.lang.StringBuilder
import java.util.regex.Pattern

/**
 * Created by Cajama on 02/02/2018.
 */
object Compile {



    private fun KEYWORDS(): Pattern {


        val key_words: StringBuilder = StringBuilder()
        key_words.append("\\b(");
        key_words.append("private|")
        key_words.append("protected|")
        key_words.append("public|")
        key_words.append("abstract|")
        key_words.append("class|")
        key_words.append("extends|")
        key_words.append("final|")
        key_words.append("implements|")
        key_words.append("interface|")
        key_words.append("native|")
        key_words.append("new|")
        key_words.append("static|")
        key_words.append("strictfp|")
        key_words.append("synchronized|")
        key_words.append("transient|")
        key_words.append("volatile|")
        key_words.append("break|")
        key_words.append("case|")
        key_words.append("continue|")
        key_words.append("default|")
        key_words.append("do|")
        key_words.append("else|")
        key_words.append("for|")
        key_words.append("if|")
        key_words.append("instanceof|")
        key_words.append("return|")
        key_words.append("while|")
        key_words.append("assert|")
        key_words.append("catch|")
        key_words.append("finally|")
        key_words.append("throw|")
        key_words.append("throws|")
        key_words.append("try|")
        key_words.append("import|")
        key_words.append("package|")
        key_words.append("boolean|")
        key_words.append("Boolean|")
        key_words.append("byte|")
        key_words.append("char|")
        key_words.append("double|")
        key_words.append("float|")
        key_words.append("int|")
        key_words.append("Int|")
        key_words.append("long|")
        key_words.append("Long|")
        key_words.append("short|")
        key_words.append("Short|")
        key_words.append("super|")
        key_words.append("this|")
        key_words.append("void|")
        key_words.append("const|")
        key_words.append("goto|")
        key_words.append("true|")
        key_words.append("True|")
        key_words.append("false|")
        key_words.append("False|")

        key_words.append("__halt_compiler|")
        key_words.append("abstract|")
        key_words.append("and|")
        key_words.append("array|")
        key_words.append("as|")
        key_words.append("callable|")
        key_words.append("clone|")
        key_words.append("const|")
        key_words.append("declare|")
        key_words.append("default|")
        key_words.append("die|")
        key_words.append("do|")
        key_words.append("echo|")
        key_words.append("elseif|")
        key_words.append("empty|")
        key_words.append("enddeclare|")
        key_words.append("endfor|")
        key_words.append("endforeach|")
        key_words.append("endif|")
        key_words.append("endswitch|")
        key_words.append("endwhile|")
        key_words.append("eval|")
        key_words.append("exit|")
        key_words.append("extends|")
        key_words.append("final|")
        key_words.append("foreach|")
        key_words.append("function|")
        key_words.append("global|")
        key_words.append("if|")
        key_words.append("include|")
        key_words.append("include_once|")
        key_words.append("instanceof|")
        key_words.append("insteadof|")
        key_words.append("isset|")
        key_words.append("list|")
        key_words.append("namespace|")
        key_words.append("or|")
        key_words.append("print|")
        key_words.append("require|")
        key_words.append("require_once|")
        key_words.append("trait|")
        key_words.append("try|")
        key_words.append("unset|")
        key_words.append("use|")
        key_words.append("var|")
        key_words.append("while|")
        key_words.append("xor|")
        key_words.append("__CLASS__|")
        key_words.append("__DIR__|")
        key_words.append("__FILE__|")
        key_words.append("__FUNCTION__|")
        key_words.append("__LINE__|")
        key_words.append("__METHOD__|")
        key_words.append("__NAMESPACE__|")
        key_words.append("__TRAIT__|")

        key_words.append("fun|")
        key_words.append("in|")
        key_words.append("!in|")
        key_words.append("is|")
        key_words.append("!is|")
        key_words.append("object|")
        key_words.append("typealias|")
        key_words.append("typeof|")
        key_words.append("val|")
        key_words.append("var|")
        key_words.append("when|")
        key_words.append("while|")
        key_words.append("constructor|")
        key_words.append("delegate|")
        key_words.append("dynamic|")
        key_words.append("field|")
        key_words.append("file|")
        key_words.append("get|")
        key_words.append("init|")
        key_words.append("param|")
        key_words.append("property|")
        key_words.append("receiver|")
        key_words.append("set|")
        key_words.append("setparam|")
        key_words.append("enum|")
        key_words.append("expect")
        key_words.append(")\\b")
        return Pattern.compile(key_words.toString())
    }

    public fun panttern(sc: ValueSchemeType, my_p: Pattern?): Pattern {

        when (sc) {
            ValueSchemeType.KEYWORDS -> return KEYWORDS()
            ValueSchemeType.PHONE -> return Patterns.PHONE
            ValueSchemeType.NUMERO_COMPILE -> return return Pattern.compile(
                    "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)" +
                            "([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|" +
                            "(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))" +
                            "[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*"
            )
            ValueSchemeType.IP_ADDRESS -> return Patterns.IP_ADDRESS
            ValueSchemeType.EMAIL_ADDRESS -> return Patterns.EMAIL_ADDRESS
            ValueSchemeType.WEB_URL -> return Patterns.WEB_URL
            ValueSchemeType.KEYWORDS -> return Patterns.DOMAIN_NAME
            ValueSchemeType.MY_KEYWORDS -> return if (my_p != null) my_p else Pattern.compile("")
            else -> return KEYWORDS()
        }
    }

    public fun color(context: Context, codeInput: ValueSchemeType): Int {
        when (codeInput) {
            ValueSchemeType.KEYWORDS -> return ContextCompat.getColor(context, R.color.key_words)
            ValueSchemeType.PHONE -> return ContextCompat.getColor(context, R.color.numero)
            ValueSchemeType.NUMERO_COMPILE -> return ContextCompat.getColor(context, R.color.white)
            ValueSchemeType.IP_ADDRESS -> return ContextCompat.getColor(context, R.color.ip_address)
            ValueSchemeType.EMAIL_ADDRESS -> return ContextCompat.getColor(context, R.color.email)
            ValueSchemeType.WEB_URL -> return ContextCompat.getColor(context, R.color.domain_name)
            ValueSchemeType.DOMAIN_NAME -> return ContextCompat.getColor(context, R.color.domain_name)
            ValueSchemeType.MY_KEYWORDS -> return ContextCompat.getColor(context, R.color.my_key_words)
            else -> return 0
        }
    }

}