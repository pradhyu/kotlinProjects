package com.oauth1;

import com.icoderman.woocommerce.HttpMethod;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * WooCommerce specific OAuth signature generator
 */

object OAuthSignature {
    private val UTF_8 = "UTF-8"
    private val HMAC_SHA256 = "HmacSHA256"
    private val SIGNATURE_METHOD_HMAC_SHA256 = "HMAC-SHA256"
    private val BASE_SIGNATURE_FORMAT = "%s&%s&%s"
    private val DELETE_PARAM_FORCE = "force"

    fun replaceSpecialChars( str: String):String  {
        return str.replace(SpecialSymbol.PLUS.plain, SpecialSymbol.PLUS.encoded)
                .replace(SpecialSymbol.STAR.plain, SpecialSymbol.STAR.encoded)
                .replace(SpecialSymbol.TILDE.encoded, SpecialSymbol.TILDE.plain)
                .replace(SpecialSymbol.COMMA.plain,SpecialSymbol.COMMA.encoded)
                .replace(SpecialSymbol.LEFT_SQUARE_BRACKET.plain,SpecialSymbol.LEFT_SQUARE_BRACKET.encoded)
                .replace(SpecialSymbol.RIGHT_SQUARE_BRACKET.plain,SpecialSymbol.RIGHT_SQUARE_BRACKET.encoded)
    }

    @JvmOverloads fun getAsMap(config:OAuthConfig, endpoint:String, httpMethod:HttpMethod, params:Map<String, String> = Collections.emptyMap()):Map<String, String> {
        if (config == null || endpoint == null || httpMethod == null)
        {
            return Collections.emptyMap()
        }
        var authParams = HashMap<String, String>()
        authParams.put(OAuthHeader.OAUTH_CONSUMER_KEY.value, config.consumerKey)
        authParams.put(OAuthHeader.OAUTH_TIMESTAMP.value, (System.currentTimeMillis() / 1000L).toString())
        authParams.put(OAuthHeader.OAUTH_NONCE.value, UUID.randomUUID().toString())
        authParams.put(OAuthHeader.OAUTH_SIGNATURE_METHOD.value, SIGNATURE_METHOD_HMAC_SHA256)
        authParams.putAll(params)
        // WooCommerce specified param
        if (HttpMethod.DELETE.equals(httpMethod))
        {
            authParams.put(DELETE_PARAM_FORCE, java.lang.Boolean.TRUE.toString())
        }
        var sortedMap = getSortedParameters(authParams)
        val oAuthSignature = generateOAuthSignature(config.consumerSecret, endpoint, httpMethod, sortedMap)
        sortedMap = sortedMap + Pair(OAuthHeader.OAUTH_SIGNATURE.value, oAuthSignature)
        return sortedMap.toSortedMap()
    }

    @JvmOverloads fun getAsQueryString(config:OAuthConfig, endpoint:String, httpMethod:HttpMethod, params:Map<String, String> = Collections.emptyMap()):String {
        if (config == null || endpoint == null || httpMethod == null)
        {
            return ""
        }
        var oauthParameters = getAsMap(config, endpoint, httpMethod, params)
        val encodedSignature = oauthParameters.get(OAuthHeader.OAUTH_SIGNATURE.value)!!
                .replace(SpecialSymbol.PLUS.plain, SpecialSymbol.PLUS.encoded)

        oauthParameters=oauthParameters + Pair(OAuthHeader.OAUTH_SIGNATURE.value ,encodedSignature)
        return mapToString(oauthParameters, SpecialSymbol.EQUAL.plain, SpecialSymbol.AMP.plain)
    }

    private fun generateOAuthSignature(customerSecret:String, endpoint:String, httpMethod:HttpMethod, parameters:Map<String, String>):String {
        val signatureBaseString = getSignatureBaseString(endpoint, httpMethod.name, parameters)
        // v1, v2
        val secret = customerSecret + SpecialSymbol.AMP.plain
        return signBaseString(secret, signatureBaseString)
    }

    private fun signBaseString(secret:String, signatureBaseString:String):String {
        val macInstance:Mac
        try
        {
            macInstance = Mac.getInstance(HMAC_SHA256)
            val secretKey = SecretKeySpec(secret.toByteArray(charset(UTF_8)), HMAC_SHA256)
            macInstance.init(secretKey)
            return Base64.encodeBase64String(macInstance.doFinal(signatureBaseString.toByteArray(charset(UTF_8))))
        }
        catch (e:NoSuchAlgorithmException) {
            throw RuntimeException(e)
        }
        catch (e:InvalidKeyException) {
            throw RuntimeException(e)
        }
        catch (e:UnsupportedEncodingException) {
            throw RuntimeException(e)
        }
    }
    private fun urlEncode(s:String):String {
        try
        {
            return URLEncoder.encode(s, UTF_8)
        }
        catch (e:UnsupportedEncodingException) {
            throw RuntimeException(e)
        }
    }
    private fun getSignatureBaseString(url:String, method:String, parameters:Map<String, String>):String {
        val requestURL = urlEncode(url)
        // 1. Percent encode every key and value that will be signed.
        var encodedParameters = percentEncodeParameters(parameters)
        // 2. Sort the list of parameters alphabetically by encoded key.
        encodedParameters = getSortedParameters(encodedParameters)
        val paramsString = mapToString(encodedParameters, SpecialSymbol.EQUAL.encoded, SpecialSymbol.AMP.encoded)
        return String.format(BASE_SIGNATURE_FORMAT, method, requestURL, paramsString)
    }

    fun mapToString(paramsMap:Map<String, String>, keyValueDelimiter:String, paramsDelimiter:String):String {
        return getSortedParameters(paramsMap).entries.stream()
                .map({ entry-> replaceSpecialChars(entry.key) + keyValueDelimiter + entry.value})
                .collect(Collectors.joining(paramsDelimiter))
    }
    private fun percentEncodeParameters(parameters:Map<String, String>):Map<String, String> {
        val encodedParamsMap = HashMap<String, String>()
        for (parameter in parameters.entries)
        {
            val key = parameter.key
            val value = parameter.value
            encodedParamsMap.put(percentEncode(key), percentEncode(value))
        }
        return encodedParamsMap
    }
    private fun percentEncode(s:String):String {
        try
        {
            return replaceSpecialChars(URLEncoder.encode(s, UTF_8))
                    // OAuth encodes some characters differently:
        }
        catch (e:UnsupportedEncodingException) {
            throw RuntimeException(e.message, e)
        }
    }
    private fun getSortedParameters(parameters:Map<String, String>):Map<String, String> {
        val sorted=parameters.toSortedMap()
        return sorted
    }
}