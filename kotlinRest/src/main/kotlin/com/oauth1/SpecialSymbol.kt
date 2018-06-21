package com.oauth1;

/**
 * Enum with special symbols and their encoded representations
 */

enum class SpecialSymbol private constructor(plain:String, encoded:String) {
    AMP("&", "%26"),
    EQUAL("=", "%3D"),
    PLUS("+", "%2B"),
    STAR("*", "%2A"),
    TILDE("~", "%7E"),
    COMMA(",","%2C"),
    RIGHT_SQUARE_BRACKET("[", "%5B" ),
    LEFT_SQUARE_BRACKET("]","%5D");
    val plain:String
    val encoded:String
    init{
        this.plain = plain
        this.encoded = encoded
    }
}