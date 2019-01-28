package com.srnunios.android_keyword.system

object Constants {
    val code = "public class Heights {\n" +
            "\n" +
            "    /**\n" +
            "     * @param args the command line arguments\n" +
            "     */\n" +
            "    public static void main(String[] args) {\n" +
            "        // TODO code application logic here\n" +
            "        \n" +
            "       String text = \"auser1 home1b\\n\" +\n" +
            "                \"auser2 home2b\\n\" +\n" +
            "                \"auser3 home3b\";\n" +
            "\n" +
            "        Matcher m = Compile.KEYWORDS.matcher(text);\n" +
            "\n" +
            "        while (m.find()) {\n" +
            "            System.out.println(\"line = \" + m.group());\n" +
            "        }\n" +
            "    }\n" +
            "    \n" +
            "}"
    val code2 = "Scheme address web : https://github.com/EdvaldoMartins " +
            "\n\nScheme programming :" +
            " \n\nfun DoPostBlack(arg:Boolean){\n" +
            "\n\t\tif(arg){\n" +
            "\t\t\t\t_doPostBlack(MakeFriendAngry, arg)\t\n" +
            "\t\t\t\tEndFriendShip()\n" +
            "\t\t}else{\n" +
            "\t\t\tDoOtherMethod()\n" +
            "\t}\n" +
            "\n" +
            "}"+"\n\nScheme number : " +
            "\n AO06 0040 0000 0132 4958 1017 2" +
            "\n\ncustom my scheme" +
            "\nMobile Developer creative"

}