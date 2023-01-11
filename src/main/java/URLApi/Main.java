package URLApi;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
	public boolean read() throws Exception {
		URL url = new URL("https://sp11-cart.000webhostapp.com/api/carts/read.php");
		try (InputStream input = url.openStream()) {
			InputStreamReader isr = new InputStreamReader(input);
			BufferedReader reader = new BufferedReader(isr);
			StringBuilder json = new StringBuilder();
			int c;
			while ((c = reader.read()) != -1) {
				json.append((char) c);
			}
			System.out.printf("content: %s\n", json.toString());

			return true;
		}
	}

	public boolean create(String jsonInputString) throws Exception {
		URL url = new URL("https://sp11-cart.000webhostapp.com/api/carts/create.php");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
			JSONParser parser = new JSONParser();
			try {
				Object object = parser.parse(response.toString());
				JSONObject jsonObject = (JSONObject) object;
				System.out.println(jsonObject.toString());

				return true;
				// System.out.println(map.get("data"));

			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}

		}
	}
	
	public boolean showDetails(String cartId) throws Exception{
		String urlString = "https://sp11-cart.000webhostapp.com/api/carts_details/show.php?cart_id=";
		urlString += cartId;
		//System.out.println(urlString);
		URL url = new URL(urlString);
		try (InputStream input = url.openStream()) {
			InputStreamReader isr = new InputStreamReader(input);
			BufferedReader reader = new BufferedReader(isr);
			StringBuilder json = new StringBuilder();
			int c;
			while ((c = reader.read()) != -1) {
				json.append((char) c);
			}
			//System.out.printf("content: %s\n", json.toString());

			JSONParser parser = new JSONParser();
			Object object = parser.parse(json.toString());
			ObjectMapper oMapper = new ObjectMapper();

			@SuppressWarnings("unchecked")
			Map<String, Object> map = oMapper.convertValue(object, Map.class);
			if (map.get("data").toString() != null) {
				System.out.println(map.get("data"));
				return true;
			}

			return false;
		}
	}
	
	public boolean updateCart(String jsonInputString) throws Exception {
		URL url = new URL("https://sp11-cart.000webhostapp.com/api/carts_details/update.php");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
			
			return true;
			
		}
	}
	
	public boolean daleteProductInCart(String jsonInputString) throws Exception {
		URL url = new URL("https://sp11-cart.000webhostapp.com/api/carts_details/delete.php");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
			
			return true;
			
		}
	}
	
	public boolean showDetailsForAUser(String cartId) throws Exception{
		String urlString = "https://sp11-cart.000webhostapp.com/api/carts_details/show.php?cart_id=";
		urlString += cartId;
		//System.out.println(urlString);
		URL url = new URL(urlString);
		try (InputStream input = url.openStream()) {
			InputStreamReader isr = new InputStreamReader(input);
			BufferedReader reader = new BufferedReader(isr);
			StringBuilder json = new StringBuilder();
			int c;
			while ((c = reader.read()) != -1) {
				json.append((char) c);
			}
			//System.out.printf("content: %s\n", json.toString());

			JSONParser parser = new JSONParser();
			Object object = parser.parse(json.toString());
			ObjectMapper oMapper = new ObjectMapper();

			@SuppressWarnings("unchecked")
			Map<String, Object> map = oMapper.convertValue(object, Map.class);
			if (map.get("data").toString() != null) {
				System.out.println(map.get("data"));
				return true;
			}

			return false;
		}
	}
	
	public boolean addProductToCart(String jsonInputString) throws Exception {
		URL url = new URL("https://sp11-cart.000webhostapp.com/api/carts_trans/add-to-cart.php");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);
		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			System.out.println(response.toString());
			
			return true;
			
		}
	}
}
