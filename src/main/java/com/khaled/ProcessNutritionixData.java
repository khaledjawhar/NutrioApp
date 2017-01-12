package com.khaled;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ProcessNutritionixData {
	public void readNutritionfacts(String s){
		try {
			String encodedUrl;
			encodedUrl =URLEncoder.encode(s, "UTF-8");
			HttpResponse<JsonNode> response = Unirest.get("https://nutritionix-api.p.mashape.com/v1_1/search/"+encodedUrl+"?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat%2Cnf_protein%2Cnf_total_carbohydrate%2Cnf_cholesterol%2Cnf_sodium%2Cnf_dietary_fiber%2Cnf_sugars%2Cnf_vitamin_a_dv%2Cnf_vitamin_c_dv%2Cnf_calcium_dv%2Cnf_iron_dv")
					.header("X-Mashape-Key", "0NfQvugXm6mshSsqKHXEADk2Scjnp1QS5uGjsn3qu5h2EJ3e8l")
					.header("Accept", "application/json")
					.asJson();
			JSONArray jsonArray = response.getBody().getObject().getJSONArray("hits");
			  for (int i = 0; i < jsonArray.length(); i++)
		        {
		            JSONObject jsonObj = jsonArray.getJSONObject(i);
		            JSONObject fields =jsonObj.getJSONObject("fields");
                    System.out.println(jsonObj.get("fields"));
		        }
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Food> searchItem(String s)    {
	    ArrayList<Food> items = new ArrayList<Food>();
	    try {
			String encodedUrl;
			encodedUrl =URLEncoder.encode(s, "UTF-8");
			HttpResponse<JsonNode> response = Unirest.get("https://nutritionix-api.p.mashape.com/v1_1/search/"+encodedUrl+"?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat%2Cnf_protein%2Cnf_total_carbohydrate%2Cnf_cholesterol%2Cnf_sodium%2Cnf_dietary_fiber%2Cnf_sugars%2Cnf_vitamin_a_dv%2Cnf_vitamin_c_dv%2Cnf_calcium_dv%2Cnf_iron_dv")
					.header("X-Mashape-Key", "0NfQvugXm6mshSsqKHXEADk2Scjnp1QS5uGjsn3qu5h2EJ3e8l")
					.header("Accept", "application/json")
					.asJson();
			JSONArray jsonArray = response.getBody().getObject().getJSONArray("hits");
			  for (int i = 0; i < jsonArray.length(); i++)
		        {
		            JSONObject jsonObj = jsonArray.getJSONObject(i);
		            JSONObject fields =jsonObj.getJSONObject("fields");
		            Food food=new Food();
		            food.setFood_type(fields.get("item_name").toString());
		            food.setFood_brand(fields.get("brand_name").toString());
		            food.setFood_carbohydrate(fields.get("nf_total_carbohydrate").toString());
		            food.setFood_calories(fields.get("nf_calories").toString());
		            food.setFood_fat(fields.get("nf_total_fat").toString());
		            food.setFood_protein(fields.get("nf_protein").toString());
		            food.setFood_cholesterol(fields.get("nf_cholesterol").toString());
		            food.setFood_sodium(fields.get("nf_sodium").toString());
		            food.setFood_dietary_fiber(fields.get("nf_dietary_fiber").toString());
		            food.setFood_sugars(fields.get("nf_sugars").toString());
		            food.setFood_vitamin_a(fields.get("nf_vitamin_a_dv").toString());
		            food.setFood_vitamin_c(fields.get("nf_vitamin_c_dv").toString());
		            food.setFood_calcium(fields.get("nf_calcium_dv").toString());
		            food.setFood_iron(fields.get("nf_iron_dv").toString());
		            items.add(food);
		        }
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return items;
	 }
	
	public ArrayList<String> searchItemThroughInstant(String s){
		 ArrayList<String> items = new ArrayList<String>();
		try {
			String encodedUrl;
			//curl -XGET "https://api.nutritionix.com/v2/autocomplete?q=greek%20y" -H 'X-APP-ID: YOUR_APP_ID' -H 'X-APP-KEY: YOUR_APP_KEY'
			encodedUrl =URLEncoder.encode(s, "UTF-8");
			HttpResponse<JsonNode> response = Unirest.get("https://api.nutritionix.com/v2/autocomplete?q="+encodedUrl)
					.header("X-APP-ID", "da4eca4e")
					.header("x-app-key", "7c63ab447685ac1e66e8a5b16dc9aa42")
					.header("Accept", "application/json")
					.asJson();
			String rawBody=response.getBody().toString();
			JSONArray jsonArray = new JSONArray(rawBody);
		    for (int i = 0; i < jsonArray.length(); i++)
		        {
		            JSONObject jsonObj = jsonArray.getJSONObject(i);
		            items.add((String) jsonObj.get("text"));
		        }
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return items;
	}

}
