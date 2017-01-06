package com.khaled;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ProcessNutritionixData {
	public void getItemNutritionfacts(String s){
		try {
			String encodedUrl;
			encodedUrl =URLEncoder.encode(s, "UTF-8");
			HttpResponse<JsonNode> response = Unirest.get("https://nutritionix-api.p.mashape.com/v1_1/search/"+encodedUrl+"?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat")
					.header("X-Mashape-Key", "0NfQvugXm6mshSsqKHXEADk2Scjnp1QS5uGjsn3qu5h2EJ3e8l")
					.header("Accept", "application/json")
					.asJson();
			System.out.println(response.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchItem(String s){
		try {
			String encodedUrl;
			//curl -XGET "https://api.nutritionix.com/v2/autocomplete?q=greek%20y" -H 'X-APP-ID: YOUR_APP_ID' -H 'X-APP-KEY: YOUR_APP_KEY'
			encodedUrl =URLEncoder.encode(s, "UTF-8");
			HttpResponse<JsonNode> response = Unirest.get("https://api.nutritionix.com/v2/autocomplete?q="+encodedUrl)
					.header("X-APP-ID", "da4eca4e")
					.header("x-app-key", "7c63ab447685ac1e66e8a5b16dc9aa42")
					.header("Accept", "application/json")
					.asJson();
			System.out.println(response.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
