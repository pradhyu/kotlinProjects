package com.oauth1;

/**
 * Enum with OAuth headers
 */
enum class OAuthHeader private constructor(value:String) {
    OAUTH_CONSUMER_KEY("oauth_consumer_key"),
    OAUTH_TIMESTAMP("oauth_timestamp"),
    OAUTH_NONCE("oauth_nonce"),
    OAUTH_SIGNATURE_METHOD("oauth_signature_method"),
    OAUTH_SIGNATURE("oauth_signature");
    val value:String
    init{
        this.value = value
    }
}