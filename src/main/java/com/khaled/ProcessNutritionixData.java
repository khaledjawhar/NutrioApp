package com.khaled;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ProcessNutritionixData {
	ProcessNutritionixData(){
		try {
			HttpResponse<JsonNode> response = Unirest.get("https://nutritionix-api.p.mashape.com/v1_1/search/cherry?fields=item_name%2Citem_id%2Cbrand_name%2Cnf_calories%2Cnf_total_fat")
					.header("X-Mashape-Key", "0NfQvugXm6mshSsqKHXEADk2Scjnp1QS5uGjsn3qu5h2EJ3e8l")
					.header("Accept", "application/json")
					.asJson();
			System.out.println(response.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
