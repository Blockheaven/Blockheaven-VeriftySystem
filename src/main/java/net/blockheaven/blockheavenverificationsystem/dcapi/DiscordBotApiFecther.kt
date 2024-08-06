package net.blockheaven.blockheavenverificationsystem.dcapi

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

class DiscordBotApiFecther(url: String, api_key: String, code: String, role: String) {

    private val url: String
    private val api_key: String
    private val jsonData: String
    private val code: String
    private val role: String

    init {
        this.url = url
        this.api_key = api_key
        this.code = code
        this.role = role
        this.jsonData = "{" +
        "\"code\": \"" + code +  "\"," +
        "\"role\": \"" + role +"\"," +
        "}";
    }

    fun sendVerifyRequest() {

        try {

            val httpclient = HttpClients.createDefault()
            val request = HttpPost(url)
            request.setHeader("Content-Type", "application/json")
            request.setHeader("x-api-key", api_key)

            val entity = StringEntity(jsonData)
            request.entity = entity

            val resp = httpclient.execute(request)
            val respEnity = resp.entity
            val respStr = EntityUtils.toString(respEnity)

        } catch (e: Exception) {
            throw RuntimeException("Error while sending verify_request: $e")
        }

    }

}