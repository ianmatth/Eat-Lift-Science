
package com.example.ian.eatliftscience;

public class NutritionixRequest {

    String name;
    String password;
    String xuj;

    protected int getWeight(name, password) {
        String url = "https://trackapi.nutritionix.com/v2/auth/signin/" + "user={"password":"\" + password + \"", "email":"" + "\" + name + \""}";
        JSONObjectRequest jsObjRequestRequest = new JSONObjectRequest(Request.METHOD.GET, url, {"userID":"name","x-user-jwt":"xuj","begin":"CURR_DATE","end":"CURR_DATE-7"},
        new Response.Listener<JSONObject>(){
            public void onResponse(JSONObject response) {
                int weight = response.get(user.weight).toInt();
            }
        }
        return weight;
    }

    protected String getXUJ(name, password) {
        String url = "https://trackapi.nutritionix.com/v2/log/" + name;
        JSONObjectRequest jsObjRequestRequest = new JSONObjectRequest(Request.METHOD.GET, url, {"userID":"name","x-user-jwt":"xuj","begin":"CURR_DATE","end":"CURR_DATE-7"},
        new Response.Listener<JSONObject>(){
            public void onResponse(JSONObject response) {
                xuj = response.get(user.x-user-jwt).toString();
            }
        }
        return xuj;
    }

    protected int getCalories(name, password) {
        String url = "https://trackapi.nutritionix.com/v2/auth/signin/" + "user={"password":"\" + password + \"","email":"" + "\" + name +\""}";
        JSONObjectRequest jsObjRequestRequest = new JSONObjectRequest(Request.METHOD.GET, url, {"userID":"name","xuj":"\" + getXUJ(name, password) + \"","begin":"CURR_DATE","end":"CURR_DATE-7"},
        new Response.Listener<JSONObject>(){
            public void onResponse(JSONObject response) {
                int cal = response.get(log.Calories).toInt();
            }
        }
        return cal;
    }
}
